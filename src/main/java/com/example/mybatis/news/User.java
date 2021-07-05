package com.example.mybatis.news;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Elliot Ji
 * @createDate: 2021-07-01
 **/
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
}
