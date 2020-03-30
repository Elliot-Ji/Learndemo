package com.example.enums;

/**
 * Created by Elliot Ji on 2018/9/10.
 */
public interface One extends Two,Three {

}

class Student implements  One{

    public void go(){
        System.out.println("Stuent.class go");
    }

    @Override
    public void back() {

        System.out.println("interface Two");
    }

    @Override
    public void come() {
        System.out.println("interface Three");
    }

    public static void main(String[] args) {
        One one = new Student();
        one.back();
        one.come();
        Student s = new Student();
        s.go();
    }
}