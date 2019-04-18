package com.wzd.dom4jdemo.exercise;

import org.dom4j.DocumentException;
import org.junit.Test;

import java.io.IOException;

public class Dom4jExerciseTest {

    @Test
    public void createStudents() throws IOException {
        new Dom4jExercise().createStudents();
    }

    @Test
    public void updateStudent() throws IOException, DocumentException {
        new Dom4jExercise().updateStudent();
    }

    @Test
    public void deleteStudent() throws IOException, DocumentException {
        new Dom4jExercise().deleteStudent();
    }

    @Test
    public void createXml() throws IOException {
        new Dom4jExercise().createXml();
    }
}