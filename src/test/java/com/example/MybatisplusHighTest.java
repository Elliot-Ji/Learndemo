package com.example;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.mybatisplus.dao.UserMapper;
import com.example.mybatisplus.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Elliot Ji on 2019/10/10.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisplusHighTest {

    @Autowired
    private UserMapper userMapper;

    /*
     * MP高级功能一: 逻辑删除功能
     * 需求: 后台系统中,要删除一条(多条)数据信息,不是在数据库中真正删除数据,而是利用删除标识字段,实现逻辑删除
     *实现步骤:
     *  1.实体类(数据库表)中有删除标识的字段添加注解:@TableLogic
     * 2.在配置文件中:0 表示未删除,1 表示删除(可根据实际情况选择)
     *               mybatis-plus:
                       global-config:
                          db-config:
                             logic-not-delete-value: 0
                             logic-delete-value: 1
     * 3.在Configuration类中加入ISqlInjector 实体对象(springboot 3.1以上可以不用加,已默认实现)
     * 4.以上操作完成后,通过Mapper的查询,更新和删除操作 的SQL语句中都会加上where条件 deleted = 0
     * 5注意事项:
     *         5.1 查询语句中不需要出现某个字段时,使用注解: @TableField(select = false)
     *         5.2 自定义的Mapper方法中,是不会加上where deleted = 0 条件语句的,如果想要加上限定语句可以做Wrapper中加入,
     *              或者在SQL语句中加入
     * */
    @Test
    public void deleteById(){
        int i = userMapper.deleteById(1094592041087729666L);
        System.out.println("影响行数: "+i );
    }

    @Test
    public void select(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void update(){
        User user = new User();
        user.setAge(28);
        user.setId(1088248166370832385L);
        int i = userMapper.updateById(user);
        System.out.println("影响行数: "+ i);
    }

    @Test
    public void mySelect(){
        List<User> users = userMapper.myList(Wrappers.<User>lambdaQuery().gt(User::getAge,25));
        users.forEach(System.out::println);
    }

    /*
     * 高级功能二: 自动填充功能
     * 需求:表中的创建时间和更新时间字段实现自动填充
     *实现步骤:
     *   1.在需要自动填充的字段上加上注解@TableField(fill = FieldFill.INSERT )   @TableField(fill = FieldFill.UPDATE)
     *   2.一个类实现MetaObjectHandler 在更新,插入等步骤时进行一些操作
     *  注意事项:
     *     在MetaObjectHandler中,每次都会执行该方法,当某些类中没有createTime需要填充的字段,也会执行该方法,影响性能
     *     改善方法:见MyMetaObjectHandler
     * */
    @Test
    public void insertOne(){
        User user = new User();
        user.setAge(20);
        user.setName("霸天虎");
        user.setManagerId(1088248166370832385L);
        user.setEmail("bth@baomidou.com");
        int insert = userMapper.insert(user);
        System.out.println("影响行数 :"+insert );
    }

    @Test
    public void updateOne(){
        User user = new User();
        user.setAge(30);
        user.setId(1088248166370832385L);
        //user.setUpdateTime(LocalDateTime.now());
        int i = userMapper.updateById(user);
        System.out.println("影响行数: "+ i);
    }

    /*
     * 高级功能三: 乐观锁功能
     * 实现步骤:
     * 1.在配置类中加入乐观锁插件实例:
     * 2.实体类中对应的字段加上注解@version
     *
     * 注意事项: 使用@Version的限制条件,详见官网
     * */
    @Test
    public void updateOneOpt(){
        //假设从数据库中获取了某一对象的version值
        int version = 1;
        User user = new User();
        user.setEmail("bet@baomidou.com");
        user.setId(1182175138510565377L);
        //user.setUpdateTime(LocalDateTime.now());
        user.setVersion(version);//MP中乐观锁字段 version默认自增+1
        int i = userMapper.updateById(user);
        System.out.println("影响行数: "+ i);
    }

    /*
    * 高级功能四: 性能分析插件:测试环境使用
    * 使用步骤:
    * 1.在配置类中配置性能分析插件实例
    *
    * */

    /*
    * 高级功能五:多租户sql解析器
    * */

    /*
    * 高级功能六:动态表
    * */

    /*
    * 高级功能七:SQL注入器
    * */
}







































