package com.srkapi.base.shared;

import lombok.Getter;

@Getter
public class ApplicationException extends Exception {
	private Errors code;
	private String detail;

	public ApplicationException(Errors code, String detail) {
		this.code = code;
		this.detail = detail;
	}
}
