package com.example.mybatis.mybatisTest;


import com.example.mybatis.Employee;
import com.example.mybatis.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Elliot Ji on 2019/1/9.
 */
public class MybatisTest {


    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession openSession = sqlSessionFactory.openSession();
       try{
           Employee employee = openSession.selectOne("getEmpById",1);
           System.out.println(employee);
       }finally{
           openSession.close();
       }
    }

    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            //获取接口的实现类对象,
            //mybatis 会创建一个代理对象
            EmployeeMapper mapper =  openSession.getMapper(EmployeeMapper.class);
            Employee emp = mapper.getEmpById(1);
            System.out.println(emp);
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //该方法不会自动提交
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            Employee employee = new Employee(null,"Rose","1","Rose@155.com");
            EmployeeMapper mapper =  openSession.getMapper(EmployeeMapper.class);
            mapper.addEmp(employee);
            //手动提交
            openSession.commit();
            System.out.println("添加成功!"+employee.getId());
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //该方法不会自动提交
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            Employee employee = new Employee(4,"Red","1","Red@155.com");
            EmployeeMapper mapper =  openSession.getMapper(EmployeeMapper.class);
            mapper.updateEmp(employee);
            //手动提交
            openSession.commit();
            System.out.println("修改成功!");
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //该方法不会自动提交
        SqlSession openSession = sqlSessionFactory.openSession();
        try{

            EmployeeMapper mapper =  openSession.getMapper(EmployeeMapper.class);
            mapper.deleteEmpById(8);
            //手动提交
            openSession.commit();
            System.out.println("删除成功!");
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test5() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            //获取接口的实现类对象,
            //mybatis 会创建一个代理对象
            EmployeeMapper mapper =  openSession.getMapper(EmployeeMapper.class);
            Employee emp = mapper.getEmpByIdAndLastName(1,"tom");
            System.out.println(emp);
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test6() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper =  openSession.getMapper(EmployeeMapper.class);
            Map<String,Object> map = new HashMap<>();
            map.put("id",1);
            map.put("lastName","tom");
            Employee emp = mapper.getEmpByMap(map);
            System.out.println(emp);
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test7() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper =  openSession.getMapper(EmployeeMapper.class);
            List<Employee> empByLastName = mapper.getEmpByLastName("tom");
           Map<String,Employee> d =  mapper.getEmpMap("Red");
            for (Employee e : empByLastName) {
                System.out.println(e);
            }
            System.out.println(d);
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test8() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper =  openSession.getMapper(EmployeeMapper.class);
            Map<String, Object> empByIdRe = mapper.getEmpByIdRe(1);
            System.out.println(empByIdRe);
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test9() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper =  openSession.getMapper(EmployeeMapper.class);
            Employee empAndDept = mapper.getEmpAndDept(1);
            System.out.println(empAndDept);
            System.out.println(empAndDept.getDepartment());
        }finally {
            openSession.close();
        }
    }

}
