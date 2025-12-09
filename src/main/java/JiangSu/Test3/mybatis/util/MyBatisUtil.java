package JiangSu.Test3.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: 聂旸
 * @Date: 2025/10/13
 */
public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // 加载mybatis核心配置文件
            String resource = "mybatis-config-two.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 创建SqlSessionFactory实例
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取SqlSession对象
    public static SqlSession getSqlSession() {
        // 参数true表示自动提交事务
        return sqlSessionFactory.openSession(true);
    }
}
