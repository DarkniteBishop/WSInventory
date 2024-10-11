package com.redprairie;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineSeg", propOrder = { "prtnum", "prt_client_id" })
public class LineSeg {
	@XmlElement(name = "prtnum", required = true, namespace = "http://ws.redprairie.com/")
	protected String prtnum;

	@XmlElement(name = "prt_client_id", required = true, namespace = "http://ws.redprairie.com/")
	protected String prt_client_id;

	public String getPrtnum() {
		return this.prtnum;
	}

	public void setPrtnum(String prtnum) {
		this.prtnum = prtnum;
	}

	public String getPrt_client_id() {
		return this.prt_client_id;
	}

	public void setPrt_client_id(String prt_client_id) {
		this.prt_client_id = prt_client_id;
	}
}
