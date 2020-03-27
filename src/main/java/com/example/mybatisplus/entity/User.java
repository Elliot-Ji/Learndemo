package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.poi.common.usermodel.Fill;

import java.time.LocalDateTime;

/**
 * Created by Elliot Ji on 2019/10/8.
 */
@Data
//@TableName("") 指定表名
public class User {
    //@TableId 指定表中id
    private Long id;
    //@TableField("") 指定列名,属性名和表名不一致时,在括号中指定
    private String name;
    private Integer age;
    private String email;
    private Long  managerId;
    @TableField(fill = FieldFill.INSERT )
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    @Version
    private Integer version;
    //逻辑删除标识
    @TableLogic
    @TableField(select = false)  //查询时,不显示该字段
    private Integer deleted;
    //排除非表字段方式
    //1.在属性名前加transient
    //2,在属性名前加static
    //3,@TableField(exist=false)
    //private String remark;



}
