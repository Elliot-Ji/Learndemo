package com.example.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Created by Elliot Ji on 2018/12/21.
 */
public class TestQuery {

    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setAge(15);
        f1.setId(1);
        //f1.setBirthday(new Date());

        Filter f2 = new Filter();
        f2.setId(10);
        f2.setUserName("Luffy");

        Filter f3 = new Filter();
        f3.setEmail("13246564@qq.com,sdfsdf@qq.com,Neer@qq.com");

        String qurey1 = query(f1);
        String qurey2 = query(f2);
        String qurey3 = query(f3);

        System.out.println(qurey1);
        System.out.println(qurey2);
        System.out.println(qurey3);

    }


    /**
     * 根据查询条件,打印出SQL语句
     * */
    public static String query(Filter f){
        StringBuilder sb = new StringBuilder();
        //1.获取到class
        Class c = f.getClass();
        //2.获取表名
        boolean exist =  c.isAnnotationPresent(Table.class);
        if(!exist){
            return null;
        }
        Table a = (Table) c.getAnnotation(Table.class);
        String tableName = a.value();
        sb.append("select * from ").append(tableName).append(" where 1 = 1");

        //3.遍历所有字段
        Field[] fArray = c.getDeclaredFields();
        for(Field field : fArray){
            //4.处理每个字段对应的SQL
            //4.1拿到字段名
            boolean isExist = field.isAnnotationPresent(Column.class);
            if(!isExist){
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            //4.2拿到字段的值
            String fieldName = field.getName();
            String getMethodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Object fieldValue =null;
            try {
                Method getMethod = c.getMethod(getMethodName);
                fieldValue = getMethod.invoke(f);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //4.3拼装SQL
            if(fieldValue == null ||(fieldValue instanceof  Integer &&(Integer)fieldValue == 0)){
                continue;
            }
            sb.append(" and ").append(columnName);
            if(fieldValue instanceof String){
                if(((String) fieldValue).contains(",")){
                    String[] values = ((String)fieldValue).split(",");
                    sb.append(" in(");
                    for(String v : values){
                        sb.append("'").append(v).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    sb.append(")");

                }else{
                    sb.append("=").append("'").append(fieldValue).append("'");
                }
            }
            if(fieldValue instanceof Integer){
                sb.append("=").append(fieldValue);
            }
            if(fieldValue instanceof Date){
                SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
                sb.append("=").append(sp.format(fieldValue));
            }
        }


        return sb.toString();
    }

}





















