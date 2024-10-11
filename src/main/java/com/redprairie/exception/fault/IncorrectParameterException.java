package com.redprairie.exception.fault;

import com.redprairie.exception.bean.IncorrectParameter;
import javax.xml.ws.WebFault;

@WebFault(faultBean = "com.redprairie.exception.bean.IncorrectParameter")
public class IncorrectParameterException extends Exception {
	private IncorrectParameter faultBean;

	public IncorrectParameterException() {
	}

	public IncorrectParameterException(String message, IncorrectParameter faultBean, Throwable cause) {
		super(message, cause);
		this.faultBean = faultBean;
	}

	public IncorrectParameterException(String message, IncorrectParameter faultBean) {
		super(message);
		this.faultBean = faultBean;
	}

	public IncorrectParameter getFaultInfo() {
		return this.faultBean;
	}
}