package com.redprairie;

import com.redprairie.StatusResponse;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({ StatusResponse.class })
public class ReceiveMessageResponse {
	protected List<StatusResponse> statusList;

	@XmlElement(name = "StatusResponse", required = true, namespace = "http://ws.redprairie.com/")
	public List<StatusResponse> getStatusList() {
		return this.statusList;
	}

	public void setStatusList(List<StatusResponse> statusList) {
		this.statusList = statusList;
	}
}