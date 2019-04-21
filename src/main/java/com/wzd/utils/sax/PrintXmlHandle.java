package com.wzd.utils.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @Author ZeDongW
 * @ClassName PrintXmlHandle
 * @Description sax解析打印Xml文件
 * @Version 1.0
 * @date ：Created in 2019/4/19 0019 6:35
 * @modified By：
 */

public class PrintXmlHandle extends DefaultHandler {
    StringBuilder sb = new StringBuilder();

    public void printXml(){
        System.out.println(sb.toString());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        sb.append("<" + qName);
        if(attributes != null){
            for (int i = 0; i < attributes.getLength(); i++){
                sb.append(" " + attributes.getQName(i) + "= '" + attributes.getValue(i) + "'");
            }
        }
        sb.append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        sb.append(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        sb.append("<" + qName + "/>");
    }
}

