package com.wzd.dom4jdemo;

import org.dom4j.DocumentException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class Dom4jDemoTest {

    Dom4jDemo  dom4jDemo = new Dom4jDemo();

    @Test
    public void dom4jDemo() {
        dom4jDemo.dom4jDemo();
    }

    @Test
    public void printXml() throws DocumentException {
        dom4jDemo.printXml();
    }

    @Test
    public void writeXml() throws IOException, DocumentException {
        dom4jDemo.writeXml();
    }
}