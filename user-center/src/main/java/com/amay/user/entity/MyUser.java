package com.amay.user.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * (MyUser)实体类
 *
 * @author makejava
 * @since 2020-08-03 17:29:51
 */
@Builder
@Data
public class MyUser implements Serializable {
    private static final long serialVersionUID = 431574755589379945L;

    private Integer userId;

    private String name;

    private String password;

    private Object loginType;

    private Integer integral;

}