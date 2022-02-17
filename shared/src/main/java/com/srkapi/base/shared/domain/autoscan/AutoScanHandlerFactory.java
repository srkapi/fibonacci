package com.srkapi.base.shared.domain.autoscan;

import static java.util.Arrays.asList;

import com.srkapi.base.shared.domain.command.Command;
import com.srkapi.base.shared.domain.command.CommandHandler;
import com.srkapi.base.shared.domain.command.CommandHandlerFactory;
import com.srkapi.base.shared.domain.query.Query;
import com.srkapi.base.shared.domain.query.QueryHandler;
import com.srkapi.base.shared.domain.query.QueryHandlerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

@Slf4j
public class AutoScanHandlerFactory implements QueryHandlerFactory, CommandHandlerFactory {

  private Map<String, Class<? extends QueryHandler>> handlerClassByQueryNameMap = new HashMap<>();
  private Map<String, Class<? extends CommandHandler>> handlerClassByCommandNameMap =
      new HashMap<>();

  private BeanFactory beanFactory;

  public AutoScanHandlerFactory(BeanFactory beanFactory) {
    this.beanFactory = beanFactory;
  }

  public void scanAndRegisterHandlers(String packageToScan) {
    Reflections reflections = new Reflections(packageToScan);
    Set<Class<? extends QueryHandler>> queryClasses = reflections.getSubTypesOf(QueryHandler.class);
    Set<Class<? extends CommandHandler>> commandClasses =
        reflections.getSubTypesOf(CommandHandler.class);

    queryClasses.forEach(
        queryClass -> {
          QueryMappings multiMappingAnnotation = queryClass.getAnnotation(QueryMappings.class);
          QueryMapping mappingAnnotation = queryClass.getAnnotation(QueryMapping.class);
          if (multiMappingAnnotation != null) {
            List<QueryMapping> queryMappings = asList(multiMappingAnnotation.value());
            queryMappings.forEach(
                queryMapping -> {
                  handlerClassByQueryNameMap.put(queryMapping.value().getName(), queryClass);
                });
          } else if (mappingAnnotation != null) {
            handlerClassByQueryNameMap.put(mappingAnnotation.value().getName(), queryClass);
          }
        });

    commandClasses.forEach(
        commandClass -> {
          CommandMappings multiMappingAnnotation =
              commandClass.getAnnotation(CommandMappings.class);
          CommandMapping mappingAnnotation = commandClass.getAnnotation(CommandMapping.class);
          if (multiMappingAnnotation != null) {
            List<CommandMapping> commandMappings = asList(multiMappingAnnotation.value());
            commandMappings.forEach(
                commandMapping -> {
                  log.info(
                      String.format(
                          "Registering handler %s to handle the command %s",
                          commandClass.getSimpleName(), commandMapping.value().getName()));

                  handlerClassByCommandNameMap.put(commandMapping.value().getName(), commandClass);
                });
          } else if (mappingAnnotation != null) {
            log.info(
                String.format(
                    "Registering handler %s to handle the command %s",
                    commandClass.getSimpleName(), mappingAnnotation.value().getName()));

            handlerClassByCommandNameMap.put(mappingAnnotation.value().getName(), commandClass);
          }
        });
  }

  @SuppressWarnings("unchecked")
  @Override
  public <R> QueryHandler<Query<R>, R> createQueryHandler(String queryName) {
    Class<? extends QueryHandler> handlerClass = handlerClassByQueryNameMap.get(queryName);
    if (handlerClass == null) {
      return null;
    }

    return beanFactory.createBean(handlerClass);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <R> CommandHandler<Command<R>, R> createCommandHandler(String commandName) {
    Class<? extends CommandHandler> handlerClass = handlerClassByCommandNameMap.get(commandName);
    if (handlerClass == null) {
      return null;
    }

    return beanFactory.createBean(handlerClass);
  }
}
