package com.example.suanfa.leveltwo.class03;

import java.util.Comparator;

/**
 * @author: Elliot Ji
 * @createDate: 2023-03-13
 **/
public class Code01_Comparator {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    //比较器,
    // 返回负数的时候,认为第一个参数排前面,
    // 返回正数时,第二个正数排前面,
    // 返回0时,都可以谁先放
    public static class AgeShengOrder implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

}
