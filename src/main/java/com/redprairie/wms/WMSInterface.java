package com.redprairie.wms;

import com.redprairie.MessageHeader;
import com.redprairie.exception.fault.MocaErrorException;
import com.redprairie.moca.MocaException;
import com.redprairie.moca.MocaResults;
import com.redprairie.moca.client.ConnectionUtils;
import com.redprairie.moca.client.HttpConnection;
import com.redprairie.moca.client.MocaConnection;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WMSInterface {
	private static String getPropertiesServiceURLConnection() {
		Properties fileProperties = new Properties();
		InputStream is = com.redprairie.wms.WMSInterface.class.getResourceAsStream("mocaServerConnection.properties");
		try {
			fileProperties.load(is);
		} catch (IOException ex) {
			Logger.getLogger(com.redprairie.wms.WMSInterface.class.getName()).log(Level.SEVERE, (String) null, ex);
		}
		String urlConnection = "";
		urlConnection = "http://" + fileProperties.getProperty("host") + ":" + fileProperties.getProperty("port")
				+ "/service";
		return urlConnection;
	}

	private static final String SERVICE_URL = getPropertiesServiceURLConnection();

	public static ArrayList<String> executeWMSCall(MessageHeader msgHeader, String prtnum, String prt_client_id)
			throws MocaErrorException {
		String command = "list var inventory qty by sku WHERE prt_client_id = '" + prt_client_id + "' and prtnum = '"
				+ prtnum + "'  and wh_id = '" + msgHeader.getWh_id() + "'";
		ArrayList<String> wsResponse = new ArrayList<String>();
		try {
			HttpConnection conex = null;
			conex = new HttpConnection(SERVICE_URL);
			ConnectionUtils.login((MocaConnection) conex, msgHeader.getUser(), msgHeader.getPass());
			MocaResults res = conex.executeCommand(command);
			if (res.next()) {
				wsResponse.add("OK");
				wsResponse.add(res.getString("totqty"));
			} else {
				wsResponse.add("OK");
				wsResponse.add("0");
			}
			conex.close();
		} catch (MocaException ex) {
			if (ex.getErrorCode() == 510) {
				wsResponse.add("OK");
				wsResponse.add("0");
			} else {
				wsResponse.add("QUERY ERROR");
				wsResponse.add(ex.getMessage());
			}
		}
		return wsResponse;
	}
}
