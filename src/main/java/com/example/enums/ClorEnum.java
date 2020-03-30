package com.example.enums;



/**
 * 枚举类
 * Created by Elliot Ji on 2018/9/19.
 */
public enum ClorEnum {
    /**
     * 枚举可以定义常量
     * */
    RED,BLACK,GREEN,ORGEEN,YELLOW,Mod(true),Tue(true),Wed(true),Thu(true),

    /**
     * 枚举定义的常量可以重写枚举类型中的方法
     * */
    Fri(true){
       public String helloEnum(){
            return "bad day";
        }
    },
    Sat(false),Sun(false);

   /**
    * 枚举可以有成员变量
    * */
    private Boolean mIsWork;

    /**
     * 枚举可以有构造函数
     * */
     private ClorEnum(){

    }

    private ClorEnum(Boolean mIsWork){
        this.mIsWork = mIsWork;
    }

    /**
     * 枚举可以有成员方法
     * */
    public Boolean isWork(){
        return mIsWork;
    }

    public  String helloEnum(){
        return "hello Enum";
    }

    /**
     * 枚举可以有静态方法
     * */
    public static String inforPrint(){
        return "Monday to Sunday";
    }

}
