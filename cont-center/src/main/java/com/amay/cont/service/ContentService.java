package com.amay.cont.service;

import com.amay.cont.entity.Content;

import java.util.List;

/**
 * (Content)表服务接口
 *
 * @author makejava
 * @since 2020-07-28 15:51:05
 */
public interface ContentService {

    /**
     * 通过ID查询单条数据
     *
     * @param contId 主键
     * @return 实例对象
     */
    Content queryById(Integer contId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Content> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param content 实例对象
     * @return 实例对象
     */
    Content insert(Content content);

    /**
     * 修改数据
     *
     * @param content 实例对象
     * @return 实例对象
     */
    Content update(Content content);

    /**
     * 通过主键删除数据
     *
     * @param contId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer contId);

}