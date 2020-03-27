package com.example.pattern.proxy;

/**
 * Created by Elliot Ji on 2019/9/3.
 */
public class TeacherDao implements IteacherDao {
    @Override
    public void teach() {
        System.out.println("老师授课中....");
    }
}
