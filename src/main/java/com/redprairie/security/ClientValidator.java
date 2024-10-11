package com.redprairie.security;

import com.redprairie.MessageHeader;
import com.redprairie.exception.bean.SecurityFault;
import com.redprairie.exception.fault.SecurityFaultException;

public class ClientValidator {
	public static void validateClientAccount(MessageHeader header) throws SecurityFaultException {
		if (header.getUser() == null && header.getPass() == null)
			throw new SecurityFaultException("Usuario y password son requeridos.", new SecurityFault());
	}
}
