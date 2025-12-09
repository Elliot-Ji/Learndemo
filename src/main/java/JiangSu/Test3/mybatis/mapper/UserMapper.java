package JiangSu.Test3.mybatis.mapper;

import JiangSu.Test3.mybatis.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: 聂旸
 * @Date: 2025/10/13
 */
public interface UserMapper {

    // 添加用户
    @Insert("INSERT INTO users(NAME, age) VALUES(#{name}, #{age})")
    int addUser(User user);

    // 根据id删除用户
    @Delete("DELETE FROM users WHERE id = #{id}")
    int deleteUserById(int id);

    // 更新用户
    @Update("UPDATE users SET NAME = #{name}, age = #{age} WHERE id = #{id}")
    int updateUser(User user);

    // 根据id查询用户
    @Select("SELECT * FROM users WHERE id = #{id}")
    User getUserById(int id);

    // 查询所有用户
    @Select("SELECT * FROM users")
    List<User> getAllUsers();
}

