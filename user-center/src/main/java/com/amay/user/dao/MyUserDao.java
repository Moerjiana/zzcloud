package com.amay.user.dao;

import com.amay.user.entity.MyUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (MyUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-03 17:29:53
 */
public interface MyUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    MyUser queryById(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MyUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param myUser 实例对象
     * @return 对象列表
     */
    List<MyUser> queryAll(MyUser myUser);

    /**
     * 新增数据
     *
     * @param myUser 实例对象
     * @return 影响行数
     */
    int insert(MyUser myUser);

    /**
     * 修改数据
     *
     * @param myUser 实例对象
     * @return 影响行数
     */
    int update(MyUser myUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);

}