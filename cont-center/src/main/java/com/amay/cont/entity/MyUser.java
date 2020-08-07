package com.amay.cont.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (MyUser)实体类
 *
 * @author makejava
 * @since 2020-07-28 16:16:29
 */
@Data
@Builder
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