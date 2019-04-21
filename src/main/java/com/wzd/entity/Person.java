package com.wzd.entity;

import java.util.Objects;

/**
 * @Author ZeDongW
 * @ClassName Person
 * @Description 实体类
 * @Version 1.0
 * @date ：Created in 2019/4/16 9:35
 * @modified By：
 */

public class Person {
    private String id; //id

    private String name; //姓名

    private String age; //年龄

    private String mobile; //手机号

    private  String email; //邮箱

    private String qq; //QQ

    public Person() {
    }

    public Person(String id, String name, String age, String mobile, String email, String qq) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.email = email;
        this.qq = qq;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) &&
                name.equals(person.name) &&
                age.equals(person.age) &&
                mobile.equals(person.mobile) &&
                email.equals(person.email) &&
                qq.equals(person.qq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, mobile, email, qq);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
