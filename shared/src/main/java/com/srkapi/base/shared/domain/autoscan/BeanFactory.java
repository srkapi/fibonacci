package com.srkapi.base.shared.domain.autoscan;

public interface BeanFactory {
  <R> R createBean(Class<R> beanClass);
}
