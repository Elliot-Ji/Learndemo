package com.example.lambda;

/**
 * Lambda表达式的作用:快速实现一个接口的实现方式
 *       使用的前提是:该接口为函数式接口.即抽象方法只能有一个;可使用@FunctionalInterface来注明
 * Created by Elliot Ji on 2019/10/9.
 */
public class TestLambda {
    public static void main(String[] args) {
        //1.方式一:接口的实现类
        Comparator  comparator = new MyComparator();
        int i = comparator.compare(4, 6);

        //2.方式二:匿名内部类
        Comparator comparator2 = new Comparator(){
            @Override
            public int compare(int a, int b) {
                return a-b;
            }
        };

        //3.方式三:lambda表达式
        Comparator comparator3 = (a,b) -> a-b;
        int compare = comparator3.compare(4, 5);
        System.out.println(compare);
    }

}

class MyComparator implements Comparator{
    @Override
    public int compare(int a, int b) {
        return a-b;
    }
}
@FunctionalInterface
interface Comparator{
    int compare(int a,int b);
}
