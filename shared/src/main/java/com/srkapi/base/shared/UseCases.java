package com.srkapi.base.shared;

public interface UseCases<R, T> {
	R execute(T t)throws DomainException;
}
