package com.example.pattern.reflect;

/**
 * Created by Elliot Ji on 2018/10/15.
 */
public class HairFactory {

    public Hair getHair(String name){
        if("left".equals(name)){
            return  new LeftHair();
        }else if("right".equals(name)){
            return new RightHair();
        }else if("in".equals(name)){
            return new InHair();
        }
        return  null;
    }

    public Hair getHairClass(String className){
        try {
            Hair hair = (Hair)Class.forName(className).newInstance();
            return hair;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    //AOP
    /**
     * 1,基本概念参考官方文档
     * 2.springAOP的用途
     * 3.
     * */
}
