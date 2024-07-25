package com.example.mianshi;

import com.example.mybatis.Employee;
import org.junit.Test;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * java 面试
 * https://www.bilibili.com/video/BV13T421k794?p=5&spm_id_from=pageDriver&vd_source=b5f8254ef4878b9fdd7d9b9213accf9d
 * @author Elliot Ji
 * @date 2024/07/16
 */
public class Base01 {

    /**
     * i++ 和 ++i 的区别
     *    即： 谁先赋值，谁先自增
     */
    @Test
    public  void elliot1() {
        int i = 5;
        System.out.println("i++: " + i++);
        System.out.println("++i: " + ++i);
        System.out.println("i: " + i);
    }

    /**
     * Arrays.asList()数组转集合BUG
     * 阿里巴巴手册中指出，转集合之后，不能再使用add,remove等修改集合的操作
     * 查看源码
     */
    @Test
    public  void elliot2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.add(6);

        //如果非要对转话的集合操作可以再包一层
        //List<Integer> integers = new ArrayList<>(Arrays.asList(1, 3, 4, 5));
        //integers.add(6);

        list.forEach(System.out::println);

    }

    /**
     * 集合遍历过程中的，remove或add操作存在的问题
     */
    @Test
    public void elliot3() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value == 4) {
                list.remove(value);
                //应该这么用：
                //iterator.remove();
            }
        }
        list.forEach(x -> System.out.println(x));
    }

    /**
     * hashcode 冲突
     * Object 中的hashcode()
     */
    @Test
    public void elliot4() {
        //方式一：写一个hashcode冲突的案例
        System.out.println("AA".hashCode());
        System.out.println("BB".hashCode());
        System.out.println("=========================================");

        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
        System.out.println("==========================================");

        //方式二：当我们正常的new对象的时候，new多少次可能出现hash冲突？--》10万次内没有，超过10万后，会出现
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 1; i <= 1 * 10000; i++) {
            int ha = new Object().hashCode();
            if (!hashSet.contains(ha)) {
                hashSet.add(ha);
            }else {
                System.out.println("hash冲突：" + ha);
            }
        }
        System.out.println(hashSet.size());
    }

    /**
     * 整型包装类的比较
     * 阿里手册： 所有整型包装类对象之间的值的比较，全部使用equals()
     * 因为：对于Integer var = ？ 在-128 ~127之间的赋值，会复用已有对象，这个区间的Integer值可以
     *    直接使用 == 进行判断，但是这个区间之外的所有数据，都会在堆上产生，并不会复用已有对象，
     *    这是一个大坑，所以一律使用equals()来判断！！！
     */
    @Test
    public void elliot5() {

        Integer a = Integer.valueOf(660);
        Integer b = Integer.valueOf(660);
        int c = 660;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a == c);

        System.out.println("=======================");
        Integer x = Integer.valueOf(66);
        Integer y = Integer.valueOf(66);
        System.out.println(x == y);
        System.out.println(x.equals(y));

    }

    /**
     * BigDecimal的大坑
     *首先，需要精确计算的结果，必须使用BigDecimal类来操作。
     *阿里手册：禁止使用构造方法BigDecimal(double)的方式把double值转化为BigDecimal对象，会存在精度丢失风险。
     *            正例：先将double转为string
     * 其次，BigDecimal的等值比较请使用compareTo(),而不是equals()!!!
     * java端使用BigDecimal  !!!
     * SQL端使用Decimal  !!!
     */
    @Test
    public void elliot6() {
        /*
         * double精度丢失问题
         * double类型的两个参数相减会转换成二进制，double的有效位数为16位这就会出现存储小数位数不够的情况，从而出现误差
         */
        double a1 = 0.03;
        double a2 = 0.02;
        System.out.println(a1 - a2);
        System.out.println("=========================================");
        /*
          *1.禁止使用BigDecimal(double)的方式把double值转为BigDecimal
          *   优先推荐入参为string的构造方法，或使用BigDecimal.valueOf()
          */
        BigDecimal b1 = new BigDecimal(0.03);
        BigDecimal b2 = new BigDecimal(0.02);
        System.out.println("b1:" + b1);
        System.out.println("b2:" + b2);
        System.out.println("b1 - b2:" + b1.subtract(b2));
        System.out.println("=========================================");
        /*
         * 推荐使用
         */
        BigDecimal c1 = new BigDecimal("0.03");
        BigDecimal c2 = new BigDecimal("0.02");
        System.out.println("c1 - c2" + c1.subtract(c2));
        System.out.println("===========================================");
        BigDecimal d1 = BigDecimal.valueOf(0.03);
        BigDecimal d2 = BigDecimal.valueOf(0.02);
        System.out.println("d1 - d2" + d1.subtract(d2));
        System.out.println("===========================================");
        /*
         *等值比较，使用compareTo(),不使用equals()
         */
        BigDecimal e1 = new BigDecimal("0.9");
        BigDecimal e2 = new BigDecimal("0.90");
        System.out.println("equals比较结果：" + e1.equals(e2));
        System.out.println("compareTo比较结果：" + e1.compareTo(e2));
        System.out.println("===========================================");
        /*
         *除法计算，需指定精度
         * 8中RoundingMode(舍入模式)
         * ROUND_HALF_UP:即我们说的“四舍五入”
         * ROUND_HALF_DOWN：即向下舍入
         */
        BigDecimal f1 = new BigDecimal("2.0");
        BigDecimal f2 = new BigDecimal("3.0");
        System.out.println("除法：" + f1.divide(f2,2, RoundingMode.HALF_UP));
        System.out.println("===========================================");
        /*
         *科学计数法
         */
        BigDecimal g = BigDecimal.valueOf(123434734959345.543582034958034958);
        System.out.println(g);
        System.out.println(g.toString());
        System.out.println(g.toPlainString());//不想使用科学计数法

        BigDecimal g2 =new BigDecimal("123434734959345.543582034958034958");
        System.out.println(g2);
        System.out.println(g2.toString());
        System.out.println(g2.toPlainString());//不想使用科学计数法

    }

    /**
     * 如何去除list去重元素，至少写出三个
     */
    @Test
    public void elliot7() {
        //方法一：for循环遍历判断，没有就新增到newList里
        List<Integer> initList = Arrays.asList(70, 22, 70, -1, 4, 5, 6, 4, 99, 4);
        ArrayList<Integer> srcList = new ArrayList<>(initList);
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < srcList.size(); i++) {
            Integer tmp = srcList.get(i);
            if (!newList.contains(tmp)) {
                newList.add(tmp);
            }
        }
        System.out.println(newList);
        System.out.println("======================================");
        //方法二：HashSet或linkedHashSet去重复
        List<Integer> srcList2 = Arrays.asList(70, 22, 70, -1, 4, 5, 6, 4, 99, 4);
        List<Integer> newList2 = new ArrayList<>(new HashSet<>(srcList2));
        newList2.forEach(System.out::println);
        System.out.println();
        System.out.println();
        List<Integer> newList3 = new ArrayList<>(new LinkedHashSet<>(srcList2));
        newList3.forEach(System.out::println);
        System.out.println("======================================");
        //方法三：Steam流式计算
        List<Integer> initList2 = Arrays.asList(70, 22, 70, -1, 4, 5, 6, 4, 99, 4);
        ArrayList<Integer> srcList3 = new ArrayList<>(initList);
        List<Integer> newList4 = srcList3.stream().distinct().collect(Collectors.toList());
        newList4.forEach(System.out::println);
        System.out.println("======================================");
        //方法四：循环坐标去除重复，类似双指针，按照值找到下标，如果下标不同，表示有重复需删除
        m4();
        //方法五：
        m5();

    }

    //方法四：循环坐标去除重复，类似双指针，按照值找到下标，如果下标不同，表示有重复需删除
    private static void m4() {
        List<Integer> initList = Arrays.asList(70, 22, 70, -1, 4, 5, 6, 4, 99, 4);
        ArrayList<Integer> srcList = new ArrayList<>(initList);
        List<Integer> newList = new ArrayList<>(initList);
        for (Integer element : srcList) {
            if (newList.indexOf(element) != newList.lastIndexOf(element)) {
                newList.remove(newList.lastIndexOf(element));
            }
        }
        newList.forEach(System.out::println);
    }

    //方法5：双for循环对比，通过下标获得值，外层循环和内层循环对比，值相同去重复
    private static void m5() {
        List<Integer> initList = Arrays.asList(70, 22, 70, -1, 4, 5, 6, 4, 99, 4);
        ArrayList<Integer> srcList = new ArrayList<>(initList);
        List<Integer> newList = new ArrayList<>(initList);
        for (int i = 0; i < newList.size() - 1; i++) {
            for (int j = newList.size() - 1; j > i ; j--) {
                if (newList.get(j).equals(newList.get(i))) {
                    newList.remove(j);
                }
            }
        }
        newList.forEach(System.out::println);
    }

    /**
     *  == 和 equals 比较
     *  基本类型还是引用类型？
     *  equals有么有被复写？
     */
    @Test
    public void elliot8() {
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2);  //比较的是内存地址
        System.out.println(s1.equals(s2));//String被复写了
        Set<String> set1 = new HashSet<>();
        set1.add(s1);
        set1.add(s2);
        System.out.println(set1.size());
        System.out.println("============================");

    }

    /**
     *  调用的方法是 传值还是传引用
     */
    @Test
    public void elliot9() {
        Elliot elliot = new Elliot();
        int age = 20;
        elliot.changeValue1(age);
        System.out.println("age -----" + age);
        Employee employee = new Employee();
        employee.setLastName("ffff");
        elliot.changeValue2(employee);
        System.out.println("lastName-----" + employee.getLastName());
        String str = "aaa";
        elliot.changeValue3(str);
        System.out.println("String ------" + str);
    }

    class Elliot {
        public void changeValue1(int age) {
            age = 30;
        }
        public void changeValue2(Employee  employee) {
            employee.setLastName("jack");
        }
        public void changeValue3(String str) {
            str = "xxx";
        }
    }

    /**
     * 深拷贝： 复写clone(),另外创造一个一模一样的对象，不共享内存
     * 浅拷贝：直接调用clone(),只复制引用（对象的指针），不复制对象，共享内存
     * Cloneable接口 ---》实现浅拷贝必须先实现Cloneable接口
     *                   Object对象中的 clone()方法
     */
    @Test
    public void elliot10() {

    }




}


































