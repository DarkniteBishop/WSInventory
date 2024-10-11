package com.redprairie;

import com.redprairie.LineSeg;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderSeg", propOrder = { "lineSeg" })
public class HeaderSeg {
	@XmlElement(name = "LineSeg", required = true, namespace = "http://ws.redprairie.com/")
	protected List<LineSeg> lineSeg;

	public List<LineSeg> getLineSeg() {
		return this.lineSeg;
	}

	public void setLineSeg(List<LineSeg> lineSeg) {
		this.lineSeg = lineSeg;
	}
}
