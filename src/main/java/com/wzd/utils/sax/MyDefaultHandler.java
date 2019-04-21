package com.wzd.utils.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @Author ZeDongW
 * @ClassName MyDefaultHandler
 * @Description sax解析工具
 * @Version 1.0
 * @date ：Created in 2019/4/18 0018 22:13
 * @modified By：
 */

public class MyDefaultHandler extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("MyDefaultHandler.startDocument()");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("MyDefaultHandler.startElement()----->ElementName='" + qName +"'");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("MyDefaultHandler.endElement()----->ElementName='" + qName +"'");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //得到当前文本内容
        String content = new String(ch,start,length);
        System.out.println("MyDefaultHandler.characters()-->"+content);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("MyDefaultHandler.endDocument()");
    }
}
