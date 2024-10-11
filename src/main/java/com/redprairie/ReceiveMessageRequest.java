package com.redprairie;

import com.redprairie.HeaderSeg;
import com.redprairie.MessageHeader;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReceiveMessageRequest", propOrder = { "messageHeader", "headerSeg" })
public class ReceiveMessageRequest {
	@XmlElement(name = "MessageHeader", required = true, namespace = "http://ws.redprairie.com/")
	protected MessageHeader messageHeader;

	@XmlElement(name = "HeaderSeg", required = true, namespace = "http://ws.redprairie.com/")
	protected List<HeaderSeg> headerSeg;

	public MessageHeader getMessageHeader() {
		return this.messageHeader;
	}

	public void setMessageHeader(MessageHeader messageHeader) {
		this.messageHeader = messageHeader;
	}

	public List<HeaderSeg> getHeaderSeg() {
		return this.headerSeg;
	}

	public void setHeaderSeg(List<HeaderSeg> headerSeg) {
		this.headerSeg = headerSeg;
	}
}
