package com.reflect;

import org.junit.Test;

import java.util.stream.Stream;

public class TestReflect {

    /**
     * tesseract-job-admin
     * 利用反射在一个对象中注入另一个对象
     *         一个对象中的成员变量要有get set方法,
     *         反射获取成员变量的set方法,利用method的invoke方法,执行set方法
     *         从而注入另一个对象;
     * @throws Exception
     */
    @Test
    public void testDemo() throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
//        Field[] declaredFields = clazz.getDeclaredFields();
//        Arrays.asList(declaredFields).stream().forEach(System.out::println);

        //利用set方法注入对象
       /* Field userServiceField = clazz.getDeclaredField("userService");
        UserService userService = new UserService();
        userServiceField.setAccessible(true);
        String name = userServiceField.getName();
        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        System.out.println("get"+name);
        String setMethodName = "set"+name;
        //        userServiceField.set(userController,userService);
        Method method = clazz.getMethod(setMethodName,UserService.class);
        method.invoke(userController,userService);*/

        //利用注解注入对象
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            String name = field.getName();
            Autowired annotation = field.getAnnotation(Autowired.class);
            if(annotation != null){
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {
                    /*
                     * 这里的对象是直接newInstance出来的
                     * 在spring中,这个bean 是定义在注解或者xml文件中,如何找到?
                     *             -->这些信息存在容器中(本质是一个map,key就是它的id)
                     */
                    Object o = type.newInstance();
                    field.set(userController,o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(userController.getUserService());

    }
}
