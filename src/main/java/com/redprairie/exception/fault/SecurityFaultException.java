package com.redprairie.exception.fault;

import com.redprairie.exception.bean.SecurityFault;
import javax.xml.ws.WebFault;

@WebFault(faultBean = "com.redprairie.exception.bean.IncorrectParameter")
public class SecurityFaultException extends Exception {
	private SecurityFault faultBean;

	public SecurityFaultException() {
	}

	public SecurityFaultException(String message, SecurityFault faultBean, Throwable cause) {
		super(message, cause);
		this.faultBean = faultBean;
	}

	public SecurityFaultException(String message, SecurityFault faultBean) {
		super(message);
		this.faultBean = faultBean;
	}

	public SecurityFault getFaultInfo() {
		return this.faultBean;
	}
}