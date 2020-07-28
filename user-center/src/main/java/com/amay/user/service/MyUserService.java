package com.amay.user.service;

import com.amay.user.entity.MyUser;

import java.util.List;

/**
 * (MyUser)表服务接口
 *
 * @author makejava
 * @since 2020-07-28 15:54:12
 */
public interface MyUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    MyUser queryById(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MyUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param myUser 实例对象
     * @return 实例对象
     */
    MyUser insert(MyUser myUser);

    /**
     * 修改数据
     *
     * @param myUser 实例对象
     * @return 实例对象
     */
    MyUser update(MyUser myUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

}