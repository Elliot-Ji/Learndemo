package com.example.testdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.regex.Pattern;

/**
 * @author 聂旸
 * @date 2025/03/21
 */
public class X5_3_5 {
    

    String pattern =  "^(?:[a-zA-Z0-9_]+\\.)?[a-zA-Z0-9_]+$";
    private static final Pattern SAFE_FIELD_PATTERN = Pattern.compile( "^(?:[a-zA-Z]+\\.)?[a-zA-Z0-9_]+$");
    public static boolean isValidSortField(String field) {
        return SAFE_FIELD_PATTERN.matcher(field).matches();
    }
    public static void main(String[] args) {
        String sortField = "date_fasdf";
        if (isValidSortField(sortField)) {
            System.out.println("正确");
            // 后续执行查询操作
        } else {
            System.out.println("排序字段不合法");
        }
    }
}
class Person {
    private String name;
    private String gender;
    private int age;

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("姓名: " + name + ", 性别: " + gender + ", 年龄: " + age);
    }
}

class Student extends Person {
    private String studentId;

    public Student(String name, String gender, int age, String studentId) {
        super(name, gender, age);
        this.studentId = studentId;
    }

    public void displayStudentId() {
        System.out.println("学号: " + studentId);
    }
}