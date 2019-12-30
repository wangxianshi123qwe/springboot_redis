package com.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class JaBeanToXml {

	private Header header;

	private Body body;

	public Header getHeader() {
		return header;
	}

	@XmlElement(name = "header")
	public void setHeader(Header header) {
		this.header = header;
	}

	public Body getBody() {
		return body;
	}

	@XmlElement(name = "body")
	public void setBody(Body body) {
		this.body = body;
	}

	public static void main(String[] args) {
		Body b = new Body();

		Header h = new Header();
		h.setBustinNo("2019-07012");
		h.setChnl("1230100064");
		h.setSerialNo("111111");
		h.setTradeDate(System.currentTimeMillis() + "");

		JaBeanToXml jaBeanToXml = new JaBeanToXml();
		jaBeanToXml.setBody(b);
		jaBeanToXml.setHeader(h);

		String xmlStr = JaxbObjectAndXmlUtil.object2Xml(jaBeanToXml);// 构造报文 XML 格式的字符串
		System.out.println("对象转xml报文： \n" + xmlStr.replaceAll("<body/>", "<body><body/>"));
	}

}
