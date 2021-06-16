package com.example.pattern.prototype.deepcopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: Elliot Ji
 * @createDate: 2021-06-16
 **/
@Data
@ToString
@AllArgsConstructor
public class DeepPrototypTarget implements Serializable,Cloneable {
    private String name;
    private int age;

    @Override
    protected Object clone() {
        DeepPrototypTarget target = null;
        try {
            target = (DeepPrototypTarget)super.clone();
            return target;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
