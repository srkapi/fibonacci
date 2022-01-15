package com.srkapi.base.shared.domain;

public interface UseCases<R, T> {
	R execute(T t)throws DomainException;
}
