package com.wzd.utils.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author ZeDongW
 * @ClassName Dom4jUtils
 * @Description Dom4j解析文档工具
 * @Version 1.0
 * @date ：Created in 2019/4/17 8:51
 * @modified By：
 */

public class Dom4jUtils {

    /**
     * @Author: ZeDongW
     * @Description: 根据路径返回Xml的Document对象
     * @Date: 2019/4/17 0017 21:23
     * @Param: [s]
     * @return: org.dom4j.Document
     */
    public static Document getDocument(String s) throws DocumentException {
        return new SAXReader().read(Dom4jUtils.class.getClassLoader().getResourceAsStream(s));
    }
    
    /**
     * @Author: ZeDongW
     * @Description: TODO
     * @Date: 2019/4/17 0017 21:27
     * @Param: [s, dom]
     * @return: void
     */ 
    public static void writeDocument(String s, Document dom) throws IOException {
        //获取文件输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(s));

        //输出格式
        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();

        //编码方式
        prettyPrint.setEncoding("UTF-8");

        //创建XML写出对象
        XMLWriter xmlWriter = new XMLWriter(bufferedWriter, prettyPrint);

        //写出对象
        xmlWriter.write(dom);

        //关闭流
        xmlWriter.close();
    }
}
