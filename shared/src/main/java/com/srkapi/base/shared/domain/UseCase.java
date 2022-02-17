package com.srkapi.base.shared.domain;

public interface UseCase<R, T> {
  R execute(T t) throws DomainException;
}
