package com.example.pattern.decorate;

/**
 * 装饰器模式
 * 模拟给一个人的声音装上扩音器
 * Created by Elliot Ji on 2019/3/14.
 */
public class DecorateTest {

    public static void main(String[] args) {
        Person p = new Person();
        p.say();
        Amplifier ap = new Amplifier(p);
        ap.say();
    }

}

interface say{
        void say();
}

class Person implements say{

    private int voice = 10;

    @Override
    public void say() {
        System.out.println("一个人的声音:"+this.getVoice()+"分贝!");
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}

class Amplifier implements say{

    private Person p;

    public Amplifier(Person p) {
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("扩音之后的分贝:"+this.p.getVoice()*100+"分贝!");
        System.out.println("oh! NO!! it's noise!!!");
    }

}
