package com.amay.user.controller;

import com.amay.user.entity.MyUser;
import com.amay.user.service.MyUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (MyUser)表控制层
 *
 * @author makejava
 * @since 2020-07-28 15:54:12
 */
@RestController
@RequestMapping("myUser")
public class MyUserController {
    /**
     * 服务对象
     */
    @Resource
    private MyUserService myUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MyUser selectOne(Integer id) {
        return this.myUserService.queryById(id);
    }

}