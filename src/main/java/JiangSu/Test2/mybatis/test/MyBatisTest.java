package JiangSu.Test2.mybatis.test;

import JiangSu.Test2.mybatis.entity.User;
import JiangSu.Test2.mybatis.mapper.UserMapper;
import JiangSu.Test2.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Auther: 聂旸
 * @Date: 2025/10/13
 */
public class MyBatisTest {
    public static void main(String[] args) {
        // 测试添加用户
        testAddUser();

        // 测试查询所有用户
        testQueryAllUsers();

        // 测试根据id查询用户
        testQueryUserById(1);

        // 测试更新用户
        testUpdateUser();

        // 测试删除用户
        testDeleteUser(3);
    }

    // 添加用户
    public static void testAddUser() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User("Alice", 20);
        int result = userMapper.addUser(user);
        if (result > 0) {
            System.out.println("添加成功！");
        }

        sqlSession.close();
    }

    // 删除用户
    public static void testDeleteUser(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int result = userMapper.deleteUserById(id);
        if (result > 0) {
            System.out.println("删除成功！");
        }

        sqlSession.close();
    }

    // 更新用户
    public static void testUpdateUser() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(1);
        user.setAge(25);
        int result = userMapper.updateUser(user);
        if (result > 0) {
            System.out.println("更新成功！");
        }

        sqlSession.close();
    }

    // 根据id查询用户
    public static void testQueryUserById(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(id);
        System.out.println("查询结果：" + user);

        sqlSession.close();
    }

    // 查询所有用户
    public static void testQueryAllUsers() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.getAllUsers();
        System.out.println("所有用户：");
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
