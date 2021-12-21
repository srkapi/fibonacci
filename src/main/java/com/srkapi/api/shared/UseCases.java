package com.srkapi.api.shared;

public interface UseCases<R, T> {
	R execute(T t)throws DomainException;
}
