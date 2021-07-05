package com.example.pattern.composite.jj;

/**
 * 叶子结点
 * @author: Elliot Ji
 * @createDate: 2021-07-01
 **/
public class Department extends OrganizationComponent {

    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    public void print() {
        System.out.println(getName());
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }
}
