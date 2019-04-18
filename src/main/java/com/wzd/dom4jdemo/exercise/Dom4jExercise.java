package com.wzd.dom4jdemo.exercise;

import com.wzd.utils.dom4j.Dom4jUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.util.List;

/**
 * @Author ZeDongW
 * @ClassName Dom4jExercise
 * @Description dom4j练习
 * @Version 1.0
 * @date ：Created in 2019/4/17 0017 22:15
 * @modified By：
 */

public class Dom4jExercise {

    /**
     * @Author: ZeDongW
     * @Description:
     * 课堂练习：
     * 1.使用dom4j的api来生成以下的xml文件
     * <Students>
     * <Student id="1">
     * 	<name>张三</name>
     * 	<gender>男</gender>
     * 	<grade>计算机1班</grade>
     * 	<address>广州天河</address>
     * </Student>
     * <Student id="2">
     * 	<name>李四</name>
     * 	<gender>女</gender>
     * 	<grade>计算机2班</grade>
     * 	<address>广州越秀</address>
     * </Student>
     * </Students>
     * 2.修改id为2的学生的姓名，改为“王丽”
     * 3.删除id为2的学生
     * @Date: 2019/4/17 0017 22:16
     * @Param: []
     * @return: void
     */
    public void createStudents() throws IOException {
        //创建一个文档对象
        Document dom= DocumentHelper.createDocument();

        //创建根标签
        Element students = dom.addElement("Students");

        //创建第一个学生标签
        Element student1 = students.addElement("Student");
        //设置第一个学生的属性
        student1.addAttribute("id","1");

        student1.addElement("name").setText("张三");
        student1.addElement("gender").setText("男");
        student1.addElement("grade").setText("计算机1班");
        student1.addElement("address").setText("广州天河");

        //创建第二个学生标签
        Element student2 = students.addElement("Student");
        //设置第二个学生的属性
        student2.addAttribute("id","2");

        student2.addElement("name").setText("李四");
        student2.addElement("gender").setText("女");
        student2.addElement("grade").setText("计算机2班");
        student2.addElement("address").setText("广州越秀");

        String target = "src/main/Resource/Students.xml";

        //写入Xml
        Dom4jUtils.writeDocument(target,dom);
    }

    /**
     * @Author: ZeDongW
     * @Description: 修改id为2的学生的姓名，改为“王丽”
     * @Date: 2019/4/17 0017 22:36
     * @Param: []
     * @return: void
     */
    public void updateStudent() throws DocumentException, IOException {
        String source = "Students.xml";
        Document dom = Dom4jUtils.getDocument(source);

        //获取根节点
        Element rootElement = dom.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            if("2".equals(element.attributeValue("id"))){
                element.element("name").setText("王丽");
            }
        }

        String target = "src/main/Resource/Students.xml";
        Dom4jUtils.writeDocument(target,dom);
    }

    public void deleteStudent() throws IOException, DocumentException {
        String source = "Students.xml";
        Document dom = Dom4jUtils.getDocument(source);

        //获取根节点
        Element rootElement = dom.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            if("2".equals(element.attributeValue("id"))){
                element.detach();
            }
        }

        String target = "src/main/Resource/Students.xml";
        Dom4jUtils.writeDocument(target,dom);
    }

    /**
     * @Author: ZeDongW
     * @Description: 创建Users.xml文件
     * @Date: 2019/4/18 0018 7:04
     * @Param: []
     * @return: void
     */
    public void createXml() throws IOException {
        //创建一个文档对象
        Document dom= DocumentHelper.createDocument();

        //创建根标签
        Element users = dom.addElement("Users");

        Element user1 = users.addElement("User");
        user1.addAttribute("id","001");
        user1.addAttribute("name","张三");
        user1.addAttribute("password","123456");

        Element user2 = users.addElement("User");
        user2.addAttribute("id","002");
        user2.addAttribute("name","李四");
        user2.addAttribute("password","abcdef");

        Element user3 = users.addElement("User");
        user3.addAttribute("id","003");
        user3.addAttribute("name","王五");
        user3.addAttribute("password","abc123");

        String target = "src/main/Resource/Users.xml";

        //写入Xml
        Dom4jUtils.writeDocument(target,dom);
    }
}
