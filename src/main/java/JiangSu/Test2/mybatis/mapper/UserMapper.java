package JiangSu.Test2.mybatis.mapper;

import JiangSu.Test2.mybatis.entity.User;
import java.util.List;

/**
 * @Auther: 聂旸
 * @Date: 2025/10/13
 */
public interface UserMapper {
    // 添加用户
    int addUser(User user);

    // 根据id删除用户
    int deleteUserById(int id);

    // 更新用户
    int updateUser(User user);

    // 根据id查询用户
    User getUserById(int id);

    // 查询所有用户
    List<User> getAllUsers();
}

