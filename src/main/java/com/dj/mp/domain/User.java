package com.dj.mp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("mp_user")// 实体类对应数据库表名
public class User {

    @TableId(type = IdType.AUTO) //主键策略
    private Integer id;

    private String username;

    private String password;

    private Integer age;

    private Integer sex;

    private String email;

    // Jackson 日期转化主键
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    //@TableField("create_time") // 字段名与数据库名不一致时使用,等同于Mybatis下划线自动转驼峰，二者取其一即可
    private Date createTime;


}
