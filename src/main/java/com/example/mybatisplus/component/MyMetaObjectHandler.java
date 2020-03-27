package com.example.mybatisplus.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;

/**
 * Created by Elliot Ji on 2019/10/10.
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //从传入的实体类中,判断是否存在createTime字段
        boolean createTime = metaObject.hasGetter("createTime");
        if(createTime){
            setInsertFieldValByName("createTime",LocalDateTime.now(),metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //更新语句中,先从SQL语句中获取对应字段的值,如果为null,则走下面的值,如果不为null,则走自己填充的值
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if(updateTime == null){
            System.out.println("updateFill");
            setUpdateFieldValByName("updateTime",LocalDateTime.now(),metaObject);
        }
    }
}
