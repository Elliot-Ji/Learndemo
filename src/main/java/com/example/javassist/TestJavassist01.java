package com.example.javassist;

import javassist.*;

/**
 * Created by Elliot Ji on 2019/12/11.
 */
public class TestJavassist01 {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("com.example.javassist.bean.Emp");

        //创建属性
        CtField f1 = CtField.make("private int empno;", cc);
        CtField f2 = CtField.make("private String ename;",cc);
        cc.addField(f1);
        cc.addField(f2);

        //创建方法
        CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}", cc);
        cc.addMethod(m1);

        //添加构造器
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")}, cc);
        ctConstructor.setBody("{this.empno = empno; this.ename = ename;}");
        cc.addConstructor(ctConstructor);

        cc.writeFile("d:/myjavassist");
        System.out.println("生成类,成功");
    }

}
