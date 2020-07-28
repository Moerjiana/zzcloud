package com.amay.user.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (MyUser)实体类
 *
 * @author makejava
 * @since 2020-07-28 15:54:12
 */
@Data
public class MyUser implements Serializable {
    private static final long serialVersionUID = -73301964948051248L;

    private Integer userId;

    private String name;

    private String password;

    private Integer loginType;

}