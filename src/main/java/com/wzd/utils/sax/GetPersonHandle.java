package com.wzd.utils.sax;

import com.wzd.entity.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;

/**
 * @Author ZeDongW
 * @ClassName GetPersonHandle
 * @Description 通过Sax解析获取对象
 * @Version 1.0
 * @date ：Created in 2019/4/19 0019 6:55
 * @modified By：
 */

public class GetPersonHandle extends DefaultHandler {

    private String tag = ""; //当前标签名

    private Person p; //联系人

    private HashSet<Person> set = new HashSet<Person>(); //联系人集合

    /**
     * @Author: ZeDongW
     * @Description: 打印Xml对象
     * @Date: 2019/4/19 0019 6:59
     * @Param: []
     * @return: void
     */
    public void printPerson(){
        for (Person person : set) {
            System.out.println(person);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tag = qName;
        if ("contact".equals(tag)){
            p = new Person();
            p.setId(attributes.getValue("id"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch,start,length);

        if("name".equals(tag)){
            p.setName(content);
        } else if ("age".equals(tag)){
            p.setAge(content);
        } else if ("mobile".equals(tag)){
            p.setMobile(content);
        } else if ("email".equals(tag)){
            p.setEmail(content);
        } else if("qq".equals(tag)){
            p.setQq(content);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tag = null;
        if("contact".equals(qName)){
            set.add(p);
        }
    }
}
