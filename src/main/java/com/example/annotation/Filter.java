package com.example.annotation;


import java.util.Date;

/**
 * Created by Elliot Ji on 2018/12/21.
 */

@Table("user")
public class Filter {

    @Column("id")
    private int  id;

    @Column("user_Name")
    private String userName;

    @Column("age")
    private int age;

    @Column("email")
    private String email;

    @Column("city")
    private String city;

    @Column("phone")
    private String phone;

    @Column("birthday")
    private Date birthday;


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
