package com.wzd.saxdemo;

import com.wzd.utils.sax.GetPersonHandle;
import com.wzd.utils.sax.MyDefaultHandler;
import com.wzd.utils.sax.PrintXmlHandle;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @Author ZeDongW
 * @ClassName SaxDemo
 * @Description Sax解析XML
 * @Version 1.0
 * @date ：Created in 2019/4/18 0018 8:48
 * @modified By：
 */

public class SaxDemo {

    SAXParser saxParser;

    {
        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author: ZeDongW
     * @Description: sax解析演示
     * @Date: 2019/4/19 0019 6:33
     * @Param: []
     * @return: void
     */
    public void saxDemo() throws SAXException, IOException {
        saxParser.parse(SaxDemo.class.getClassLoader().getResourceAsStream("contacts.xml"),new MyDefaultHandler());
    }


    /**
     * @Author: ZeDongW
     * @Description: 通过Sax解析打印Xml
     * @Date: 2019/4/19 0019 6:52
     * @Param: []
     * @return: void
     */
    public void printXml() throws IOException, SAXException {
        PrintXmlHandle printXmlHandle = new PrintXmlHandle();
        saxParser.parse(SaxDemo.class.getClassLoader().getResourceAsStream("personList.html"),printXmlHandle);
        printXmlHandle.printXml();
    }

    /**
     * @Author: ZeDongW
     * @Description: 打印Xml对象
     * @Date: 2019/4/19 0019 7:15
     * @Param: []
     * @return: void
     */
    public void getPerson() throws IOException, SAXException {
        GetPersonHandle getPersonHandle = new GetPersonHandle();
        saxParser.parse(SaxDemo.class.getClassLoader().getResourceAsStream("contacts.xml"),getPersonHandle);
        getPersonHandle.printPerson();
    }
}
