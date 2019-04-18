package com.wzd.dom4jdemo.xpath;

import com.wzd.utils.dom4j.Dom4jUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @Author ZeDongW
 * @ClassName XpathDemo
 * @Description xpath快速获取所需节点对象
 * @Version 1.0
 * @date ：Created in 2019/4/17 0017 22:53
 * @modified By：
 */

public class XpathDemo {

    /**
     * @Author: ZeDongW
     * @Description: 通过Xpath快速删除标签
     * @Date: 2019/4/17 0017 22:56
     * @Param: []
     * @return: void
     */
    public void deleteStudentByXpath() throws DocumentException, IOException {
        String source = "Students.xml";
        Document dom = Dom4jUtils.getDocument(source);

        String xPath = "//Student[@id='2']";

        Element element = (Element)dom.selectSingleNode(xPath);

        if(element != null){
            element.detach();
        }

        String target = "src/main/Resource/Students.xml";
        Dom4jUtils.writeDocument(target,dom);
    }

    /**
     * @Author: ZeDongW
     * @Description: Xpath表达式
     * @Date: 2019/4/18 0018 6:16
     * @Param: []
     * @return: void
     */
    public void xpathDemo() throws DocumentException {
        String source = "contacts.xml";
        Document dom = Dom4jUtils.getDocument(source);

        String  xPath ="";

        /**
         * 1.  	/      绝对路径      表示从xml的根位置开始或子元素（一个层次结构）
         */
        xPath="/contacts";
        xPath="/contacts/contact";

        /**
         * 2. //     相对路径       表示不分任何层次结构的选择元素。
         */
        xPath="//contact/name";
        xPath="//name";

        /**
         * 3. *      通配符         表示匹配所有元素
         */
        xPath="/contacts/*"; //根标签contacts下的所有子标签签
        xPath="/contacts//*";//contacts下面所有标签

        /**
         * 4. []      条件           表示选择什么条件下的元素
         */
        xPath="//contact[@id]";//所有带有id属性的contact标签
        xPath="//contact[2]";//第二个的contact标签
        xPath="//contact[last()]";//选择最后一个contact标签

        /**
         * 5. @     属性            表示选择属性节点
         */
        xPath="//@id";//选择id属性节点对象，返回的是Attribute对象
        xPath="//contact[not(@id)]";//选择不包含id属性的contact标签节点
        xPath="//contact[@id='002']";//选择id属性值为002的contact标签
        xPath="//contact[@id='001' and @name='eric']";//选择id属性值为001，且name属性为eric的contact标签

        /**
         *6.  text()   表示选择文本内容
         */
        xPath="//name/text()";//选择name标签下的文本内容，返回Text对象
        xPath="//name[text()='张三']";//选择姓名为张三的name标签
        List<Node> list = dom.selectNodes(xPath);
        for (Node node : list) {
            System.out.println(node);
        }

    }

    public static void loginDeno() throws DocumentException, IOException {
        String source = "Users.xml";
        Document dom = Dom4jUtils.getDocument(source);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("请输入用户名：");
        String name = bufferedReader.readLine();

        System.out.println("请输入密码");
        String password = bufferedReader.readLine();

        String  xPath ="//User[@name='" + name + "' and @password='" + password + "']";
        System.out.println(xPath);
        List list = dom.selectNodes(xPath);
        if(list.size() > 0){
            System.out.println("登录成功");
        } else {
            System.out.println("登陆失败");
        }
    }

    public void readHtml() throws DocumentException {
        String source = "personList.html";
        Document dom = Dom4jUtils.getDocument(source);

        List<Node> list = dom.selectNodes("//title");
        for (Node node : list) {
            System.out.println(node.getText());
        }

        List<Element> list1 = (List<Element>) dom.selectNodes("//tbody/tr");
        for (Element elem : list1) {
            //编号
            String id = ((Element)elem.elements().get(0)).getText();
            //姓名
            String name = ((Element)elem.elements().get(1)).getText();
            //性别
            String gender = ((Element)elem.elements().get(2)).getText();
            //年龄
            String age = ((Element)elem.elements().get(3)).getText();
            //地址
            String address = ((Element)elem.elements().get(4)).getText();
            //电话
            String phone = ((Element)elem.elements().get(5)).getText();

            System.out.println("编号："+id+"\t姓名："+name+"\t性别："+
                    gender+"\t年龄："+
                    age+"\t地址："+address+
                    "\t电话："+phone);
        }
    }
}
