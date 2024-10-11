package com.redprairie.ws;

import com.redprairie.HeaderSeg;
import com.redprairie.LineSeg;
import com.redprairie.MessageHeader;
import com.redprairie.ReceiveMessageRequest;
import com.redprairie.ReceiveMessageResponse;
import com.redprairie.StatusResponse;
import com.redprairie.exception.bean.IncorrectParameter;
import com.redprairie.exception.fault.IncorrectParameterException;
import com.redprairie.exception.fault.MocaErrorException;
import com.redprairie.exception.fault.SecurityFaultException;
import com.redprairie.security.ClientValidator;
import com.redprairie.wms.WMSInterface;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "varListInventoryQtybySku")
public class varListInventoryQtybySku {
	@WebMethod(operationName = "Receive")
	@WebResult(name = "ReceiveMessageResponse", targetNamespace = "http://ws.redprairie.com/")
	public ReceiveMessageResponse receiveOperation(
			@WebParam(name = "ReceiveMessageRequest", targetNamespace = "http://ws.redprairie.com/") ReceiveMessageRequest req)
			throws IncorrectParameterException, MocaErrorException, SecurityFaultException {
		ReceiveMessageResponse response = new ReceiveMessageResponse();
		MessageHeader msgHeader = req.getMessageHeader();
		List<HeaderSeg> headSegList = req.getHeaderSeg();
		List<StatusResponse> list = new ArrayList<StatusResponse>();
		ClientValidator.validateClientAccount(msgHeader);
		if (msgHeader.getWh_id() != null && !msgHeader.getWh_id().isEmpty()) {
			if (!headSegList.isEmpty()) {
				for (HeaderSeg headSeg : headSegList) {
					List<LineSeg> lineSeg = headSeg.getLineSeg();
					if (lineSeg != null) {
						if (!lineSeg.isEmpty()) {
							for (int x = 0; x < lineSeg.size(); x++) {
								LineSeg l = lineSeg.get(x);
								if (l.getPrtnum() != null && !l.getPrtnum().isEmpty()) {
									if (l.getPrt_client_id() != null && !l.getPrt_client_id().isEmpty()) {
										ArrayList<String> wsResponse = WMSInterface.executeWMSCall(msgHeader,
												l.getPrtnum(), l.getPrt_client_id());
										StatusResponse res = new StatusResponse();
										res.setWh_id(msgHeader.getWh_id());
										res.setPrtnum(l.getPrtnum());
										res.setPrt_client_id(l.getPrt_client_id());
										String status = wsResponse.get(0);
										if (status.equals("OK")) {
											res.setStatus(status);
											res.setTotal_qty(wsResponse.get(1));
										} else {
											res.setStatus(status);
											res.setMessage(wsResponse.get(1));
										}
										list.add(res);
									} else {
										throw new IncorrectParameterException("Parametro [prt_client_id] es requerido.",
												new IncorrectParameter());
									}
								} else {
									throw new IncorrectParameterException("Parametro [prtnum] es requerido.",
											new IncorrectParameter());
								}
							}
							continue;
						}
						throw new IncorrectParameterException("Parametro [LineSeg] debe aparecer al menos una vez.",
								new IncorrectParameter());
					}
					throw new IncorrectParameterException("Parametro [LineSeg] es requerido.",
							new IncorrectParameter());
				}
			} else {
				throw new IncorrectParameterException("Parametro [HeadSeg] debe aparecer al menos una vez.",
						new IncorrectParameter());
			}
		} else {
			throw new IncorrectParameterException("Parametro [wh_id] es requerido.", new IncorrectParameter());
		}
		response.setStatusList(list);
		return response;
	}
}
