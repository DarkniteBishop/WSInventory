package com.redprairie.exception.fault;

import com.redprairie.exception.bean.MocaError;
import javax.xml.ws.WebFault;

@WebFault(faultBean = "com.redprairie.exception.bean.MocaWMSException")
public class MocaErrorException extends Exception {
	private MocaError faultBean;

	public MocaErrorException() {
	}

	public MocaErrorException(String message, MocaError faultBean, Throwable cause) {
		super(message, cause);
		this.faultBean = faultBean;
	}

	public MocaErrorException(String message, MocaError faultBean) {
		super(message);
		this.faultBean = faultBean;
	}

	public MocaError getFaultInfo() {
		return this.faultBean;
	}
}