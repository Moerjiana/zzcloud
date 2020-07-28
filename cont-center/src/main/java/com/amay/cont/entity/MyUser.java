package com.amay.cont.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (MyUser)实体类
 *
 * @author makejava
 * @since 2020-07-28 16:16:29
 */
@Data
public class MyUser implements Serializable {
    private static final long serialVersionUID = 824468046796424421L;

    private Integer userId;

    private String name;

    private String password;

    private Integer loginType;

}