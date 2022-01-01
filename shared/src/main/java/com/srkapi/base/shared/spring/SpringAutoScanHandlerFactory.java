package com.srkapi.base.shared.spring;

import com.srkapi.base.shared.autoscan.AutoScanHandlerFactory;
import com.srkapi.base.shared.autoscan.BeanFactory;
import org.springframework.context.ApplicationContext;

public class SpringAutoScanHandlerFactory extends AutoScanHandlerFactory {

    private ApplicationContext context;

    public SpringAutoScanHandlerFactory(ApplicationContext context, String basePackage) {
        super(new BeanFactory() {
            @Override
            public <R> R createBean(Class<R> beanClass) {
                context.getAutowireCapableBeanFactory().autowireBean(beanClass);
                return context.getAutowireCapableBeanFactory().createBean(beanClass);
            }
        });
        this.context = context;
        scanAndRegisterHandlers(basePackage);
    }

}
