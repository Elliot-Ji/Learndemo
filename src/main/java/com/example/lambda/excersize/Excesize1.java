package com.example.lambda.excersize;

import com.example.lambda.data.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Elliot Ji on 2019/10/9.
 */
public class Excesize1 {
    public static void main(String[] args) {
        //lambda表达式 排序
        List<Person> list = new ArrayList<>();
        list.add(new Person("lily",19));
        list.add(new Person("lucy",9));
        list.add(new Person("hanmeimei",29));
        list.add(new Person("jack",3));
        list.add(new Person("lisi",8));
        list.add(new Person("wangwu",19));
        list.add(new Person("uncle li",39));

        list.sort((o1,o2) -> o2.getAge()-o1.getAge());

        System.out.println(list);

        TreeSet<Person> treeSet = new TreeSet<>((o1,o2)->{
            if(o1.getAge()>=o2.getAge()){
                return -1;
            }else{
                return 1;
            }
        });
        treeSet.add(new Person("lily",19));
        treeSet.add(new Person("lucy",9));
        treeSet.add(new Person("hanmeimei",29));
        treeSet.add(new Person("jack",3));
        treeSet.add(new Person("lisi",8));
        treeSet.add(new Person("wangwu",19));
        treeSet.add(new Person("uncle li",39));
        System.out.println(treeSet);


    }

}
