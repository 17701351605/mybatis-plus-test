package com.dj.mp.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserQuery implements Serializable {

    private String username;

    private Integer startAge;

    private Integer endAge;

    private Integer sex;

    private Integer pageNo = 1;

    private Integer pageSize = 2;

}
