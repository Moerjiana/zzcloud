package com.amay.user.controller;

import com.amay.user.entity.MyUser;
import com.amay.user.service.MyUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@Slf4j
public class MyUserController {
    /**
     * 服务对象
     */
    @Resource
    private MyUserService myUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param userId 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne/{userId}")
    public MyUser selectOne(@PathVariable Integer userId) {
        log.info("user模块访问....");
        return this.myUserService.queryById(userId);
    }

}