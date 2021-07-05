package com.example.mybatis.news;

import com.beust.jcommander.internal.Maps;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author: Elliot Ji
 * @createDate: 2021-07-01
 **/
public class TestM {
    public static void main(String[] args) {
        UserMapper mapper = (UserMapper) Proxy.newProxyInstance(TestM.class.getClassLoader(), new Class<?>[]{UserMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Select annotation = method.getAnnotation(Select.class);
                //System.out.println(Arrays.toString(args));//参数的值
                Map<String, Object> nameArgMap = buildMethodArgNameMap(method, args);

                if(annotation != null){
                    String[] value = annotation.value();
                    String sql = value[0];
                    sql = parseSQL(sql, nameArgMap);
                    System.out.println(sql);
                }
                //System.out.println(method.getName());
                return "adf";
            }
        });
        mapper.selectUserByID(2,"test");

    }

    //解析sql
    public static String parseSQL(String sql,Map<String, Object> nameArgMap){
        StringBuilder stringBuilder = new StringBuilder();
        int  length = sql.length();
        for(int i = 0;i < length; i++){//遍历这个sql语句,利用char来实现 select * from user where id = #{id} and name = #{name}
            char c = sql.charAt(i);
            if(c == '#'){
                int nextIndex = i +1;
                char nextChar = sql.charAt(nextIndex);
                if(nextChar != '{'){
                    throw new RuntimeException(String.format("这里应该为#{\nsql:%s\nindex:%d",stringBuilder.toString(),nextIndex));
                }
                StringBuilder argSB =  new StringBuilder();
                i = parseSQLArg(argSB, sql, nextIndex);
                String argName = argSB.toString();
                Object argValue = nameArgMap.get(argName);
                if(argValue == null){
                    throw new RuntimeException(String.format("这里找不到参数值:%s",argName));
                }
                stringBuilder.append(argValue.toString());
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static int parseSQLArg(StringBuilder argSB, String sql, int nextIndex) {
        //sql = select * from user where id = #{id} and name = #{name}
        nextIndex++;
        for(;nextIndex<sql.length();nextIndex++){
            char c = sql.charAt(nextIndex);
            if(c != '}'){
                argSB.append(c);
                continue;
            }
            if(c == '}'){
                return nextIndex;
            }
        }
        throw new RuntimeException(String.format("缺失右括号}\nindex:%d",nextIndex));
    }

    //获取参数名
    public static Map<String,Object> buildMethodArgNameMap(Method method, Object[] args){
        Map<String, Object> map = Maps.newHashMap();
        Parameter[] parameters = method.getParameters();
        if(parameters.length != args.length){

        }
        int index[] = {0};
        Arrays.asList(parameters).forEach(parameter -> {
            String name = parameter.getName();//参数的名
            map.put(name,args[index[0]]);
            index[0]++;
        });
        return  map;
    }

}


interface UserMapper{
    @Select("select * from user where id = #{id}")
    List<User> selectUserByID(Integer id,String name);
}
