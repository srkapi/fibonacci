package com.srkapi.base.shared.autoscan;

public interface BeanFactory {
  <R> R createBean(Class<R> beanClass);
}
