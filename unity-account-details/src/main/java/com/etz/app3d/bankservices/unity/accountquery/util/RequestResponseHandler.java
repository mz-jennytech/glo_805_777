package com.etz.app3d.bankservices.unity.accountquery.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Set;

public class RequestResponseHandler implements SOAPHandler<SOAPMessageContext> {

	public static Logger log = LoggerFactory.getLogger(RequestResponseHandler.class);
	private Transformer transformer = null;
	private DocumentBuilderFactory docBuilderFactory = null;
	private DocumentBuilder docBuilder = null;

	public RequestResponseHandler() {
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
			docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docBuilderFactory.newDocumentBuilder();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public boolean handleFault(SOAPMessageContext messageContext) {
		log(messageContext);
		return true;
	}

	public boolean handleMessage(SOAPMessageContext messageContext) {
		log(messageContext);
		return true;
	}

	private void log(SOAPMessageContext messageContext) {
		String xml = "";
		SOAPMessage msg = messageContext.getMessage();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			msg.writeTo(out);
			xml = out.toString("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}       

		String direction = "";
		Boolean outbound = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY); 
		if (outbound) { 
			direction += "Request: \n"; 
		} else { 
			direction += "Response: \n";
		} 
		
		log.info(direction + getXMLprettyPrinted(xml));
	}

	public Set<QName> getHeaders() {
		return Collections.emptySet();
	}


	public String getXMLprettyPrinted(String xml) {

		if (transformer == null || docBuilder == null)
			return xml;

		try {
			StringReader reader = new StringReader(xml);
			StringWriter writer = new StringWriter();

			transformer.transform(
					new javax.xml.transform.stream.StreamSource(reader), 
					new javax.xml.transform.stream.StreamResult(writer));

			return writer.toString();
		} catch (TransformerException e) {
			e.printStackTrace();
			return xml;
		}
	}

	public void close(MessageContext arg0) {

	}
}
