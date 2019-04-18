package com.wzd.dom4jdemo.xpath;

import org.dom4j.DocumentException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class XpathDemoTest {

    @Test
    public void deleteStudentByXpath() throws IOException, DocumentException {
        new XpathDemo().deleteStudentByXpath();
    }

    @Test
    public void xpathDemo() throws DocumentException {
        new XpathDemo().xpathDemo();
    }

    @Test
    public void loginDeno() throws IOException, DocumentException {
        new XpathDemo().loginDeno();
    }

    @Test
    public void readHtml() throws DocumentException {
        new XpathDemo().readHtml();
    }
}