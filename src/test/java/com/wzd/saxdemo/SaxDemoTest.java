package com.wzd.saxdemo;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SaxDemoTest {

    @Test
    public void saxDemo() throws IOException, SAXException, ParserConfigurationException {
        new SaxDemo().saxDemo();
    }

    @Test
    public void printXml() throws IOException, SAXException {
        new SaxDemo().printXml();
    }

    @Test
    public void getPerson() throws IOException, SAXException {
        new SaxDemo().getPerson();
    }
}