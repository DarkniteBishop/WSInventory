package com.redprairie;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "StatusResponse", propOrder = { "wh_id", "status", "message", "prtnum", "prt_client_id", "total_qty" })
public class StatusResponse {
	protected String wh_id;

	protected String status;

	protected String message;

	protected String prtnum;

	protected String prt_client_id;

	protected String total_qty;

	public String getWh_id() {
		return this.wh_id;
	}

	public void setWh_id(String wh_id) {
		this.wh_id = wh_id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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

	public String getTotal_qty() {
		return this.total_qty;
	}

	public void setTotal_qty(String total_qty) {
		this.total_qty = total_qty;
	}
}
