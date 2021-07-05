package com.example.pattern.composite.jj;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Elliot Ji
 * @createDate: 2021-07-01
 **/
@Data
@AllArgsConstructor
public abstract class OrganizationComponent {
    private String name;
    private String des;

    protected void add(OrganizationComponent organizationComponent){
       //默认实现
    }

    protected void remove(OrganizationComponent organizationComponent){
        //默认实现
    }
    public abstract void print();


}
