package com.redprairie;

import com.redprairie.ReceiveMessageRequest;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Receive", propOrder = { "receiveMessageRequest" })
public class Receive {
	@XmlElement(name = "ReceiveMessageRequest", required = true)
	protected ReceiveMessageRequest receiveMessageRequest;

	public ReceiveMessageRequest getReceiveMessageRequest() {
		return this.receiveMessageRequest;
	}

	public void setReceiveMessageRequest(ReceiveMessageRequest receiveMessageRequest) {
		this.receiveMessageRequest = receiveMessageRequest;
	}
}
