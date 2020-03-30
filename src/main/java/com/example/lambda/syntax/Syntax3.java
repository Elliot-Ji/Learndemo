package com.example.lambda.syntax;

import com.example.lambda.interfaces.LambdaSingleReturnSingleParameter;

/**
 * Created by Elliot Ji on 2019/10/9.
 */
public class Syntax3 {
    public static void main(String[] args) {
        //方法的引用:
        //可以快速的将一个lambda表达式的实现指向一个已经实现的方法
        //备注:当有多处需要引用接口中的该方法时,可以将该方法的具体实现定义在某处对象的方法中,
        //     当需要调用该方法时,直接引用该函数
        //语法: 方法隶属者::方法名

        //注意:
        //1.引用的方法中的参数数量和类型一定要和接口中定义的一致
        //2.引用的方法中的返回值类型一定要和接口中定义的一致
        LambdaSingleReturnSingleParameter lambda1 = a -> change(a);
        int test = lambda1.test(20);
        System.out.println(test);


        LambdaSingleReturnSingleParameter lambda2 = Syntax3::change;
        int test1 = lambda2.test(10);
        System.out.println(test1);

        Syntax3 syntax3 = new Syntax3();
        LambdaSingleReturnSingleParameter lambda3 = syntax3::exchange;
        int test2 = lambda3.test(30);
        System.out.println(test2);


    }

    private static int  change(int a){
        return a*2;
    }

    private int exchange(int a){
        return (a+20);
    }
}
