package com.wzd.dom4jdemo;

import com.wzd.entity.Person;
import com.wzd.utils.dom4j.Dom4jUtils;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author ZeDongW
 * @ClassName Dom4jDemo
 * @Description Dom4j使用
 * @Version 1.0
 * @date ：Created in 2019/4/16 8:37
 * @modified By：
 */

public class Dom4jDemo {
    /**
     * @Author: ZeDongW
     * @Description: Dom4j解析Xml文件
     * @Date: 2019/4/17 8:43
     * @Param: []
     * @return: void
     */
    public void dom4jDemo(){

        ArrayList<Person> list = new ArrayList<Person>();
        try {
            //创建一个xml解析器对象
            SAXReader saxReader = new SAXReader();
            //读取xml文件，返回document对象
//            Document dom = saxReader.read(App.class.getResource("/contacts.xml"));
            Document dom = saxReader.read(Dom4jDemo.class.getClassLoader().getResourceAsStream("contacts.xml"));
            /*Iterator<Node> it = dom.nodeIterator();//获取XML的节点
            while (it.hasNext()){
                Node node = it.next();
                System.out.println(node.getName());
            }
            System.out.println("------------------------------------------------------------------------------------");*/
            /*String path = dom.getPath(); //获取XML路径
            System.out.println(path);*/
            /*short nodeType = dom.getNodeType();//获取节点类型
            System.out.println(nodeType);*/
            Element rootElement = dom.getRootElement();//获取根节点
            Iterator<Element> iterator = rootElement.elementIterator();//获取根节点元素迭代器
            while(iterator.hasNext()){
                Person p = new Person();
                Element next = iterator.next();
                p.setId(next.attributeValue("id"));
                Iterator<Element> iterator1 = next.elementIterator();
                while (iterator1.hasNext()){
                    Element element = iterator1.next();
                    if("name".equals(element.getName())){
                        p.setName(element.getText());
                    } else if("age".equals(element.getName())){
                        p.setAge(Integer.parseInt(element.getText()));
                    } else if("mobile".equals(element.getName())){
                       p.setMobile(element.getText());
                    } else if("email".equals(element.getName())){
                        p.setEmail(element.getText());
                    } else if("qq".equals(element.getName())){
                        p.setQq(Integer.parseInt(element.getText()));
                    }
                }
                list.add(p);
            }
            for (Person person : list) {
                System.out.println(person);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author: ZeDongW
     * @Description: Dom4j解析XML并打印
     * @Date: 2019/4/17 8:48
     * @Param: []
     * @return: void
     */ 
    public void printXml() throws DocumentException {
        String resource = "contacts.xml";
        Document dom = Dom4jUtils.getDocument(resource);
        Element rootElement = dom.getRootElement();
        StringBuilder sb = new StringBuilder();
        sb = printNode(rootElement,sb);
        System.out.println(sb.toString());
    }

    public void writeXml() throws DocumentException, IOException {
        String resource = "contacts.xml";
        Document dom = Dom4jUtils.getDocument(resource);
        Element rootElement = dom.getRootElement();
        
        //修改第一个contact
        //获取第一个contact节点
        Element contact1 = (Element)rootElement.elements().get(0);
        contact1.attribute("id").setValue("999");//修改属性id的值为999
        Element name = contact1.element("name");
        name.setText("王五");

        Element element2 = (Element) rootElement.elements().get(1);
        element2.detach();

        Element contact = rootElement.addElement("contact");
        Element id = contact.addAttribute("id", "007");
        Element name1 = contact.addElement("name");
        name1.setText("赵六");
        String target = "src/main/Resource/new.xml";
        Dom4jUtils.writeDocument(target,dom);
    }

    /**
     * @Author: ZeDongW
     * @Description: 遍历节点并打印
     * @Date: 2019/4/17 18:33
     * @Param: [rootElement, sb]
     * @return: java.lang.StringBuilder
     */
    private StringBuilder printNode(Element element, StringBuilder sb) {
        sb.append("<" + element.getName());
        List<Attribute> list = element.attributes();
        for (Attribute attribute : list) {
            sb.append(" " + attribute.getName() + "=\"" + attribute.getValue() + "\"");
        }
        sb.append(">");
        Iterator<Node> it = element.nodeIterator();
        while (it.hasNext()){
            Node node = it.next();
           /* if(node instanceof Text){
                sb.append(node.getText());
            } else if(node instanceof  Element){
                printNode((Element) node,sb);
            }*/
            if(node instanceof  Element){
                printNode((Element) node,sb);
            } else if(node instanceof Text){
                sb.append(node.getText());
            }
        }
        sb.append("</" + element.getName() + ">");
        return sb;
    }

}
