package JiangSu.Test3.mybatis.entity;

/**
 * @Auther: 聂旸
 * @Date: 2025/10/13
 */
public class User {
    private int id;
    private String name;
    private int age;

    // 无参构造
    public User() {}

    // 有参构造
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter和setter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}

