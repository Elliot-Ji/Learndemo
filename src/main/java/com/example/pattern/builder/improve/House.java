package com.example.pattern.builder.improve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-17
 **/
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class House {
    private String baise;
    private String wall;
    private String roofed;

}
