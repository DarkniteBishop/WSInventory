package com.redprairie;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageHeader", propOrder = { "wh_id", "user", "pass" })
public class MessageHeader {
	@XmlElement(name = "wh_id", required = true, namespace = "http://ws.redprairie.com/")
	protected String wh_id;

	@XmlElement(name = "user", required = true, namespace = "http://ws.redprairie.com/")
	private String user;

	@XmlElement(name = "pass", required = true, namespace = "http://ws.redprairie.com/")
	private String pass;

	public String getWh_id() {
		return this.wh_id;
	}

	public void setWh_id(String wh_id) {
		this.wh_id = wh_id;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
