package com.amay.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (MyUser)实体类
 *
 * @author makejava
 * @since 2020-08-03 17:29:51
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String name;

    private String password;

    private Object loginType;

    private Integer integral;

}