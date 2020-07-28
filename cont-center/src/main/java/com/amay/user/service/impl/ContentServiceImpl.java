package com.amay.user.service.impl;

import com.amay.user.dao.ContentDao;
import com.amay.user.entity.Content;
import com.amay.user.service.ContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Content)表服务实现类
 *
 * @author makejava
 * @since 2020-07-28 15:51:05
 */
@Service("contentService")
public class ContentServiceImpl implements ContentService {
    @Resource
    private ContentDao contentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param contId 主键
     * @return 实例对象
     */
    @Override
    public Content queryById(Integer contId) {
        return this.contentDao.queryById(contId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Content> queryAllByLimit(int offset, int limit) {
        return this.contentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param content 实例对象
     * @return 实例对象
     */
    @Override
    public Content insert(Content content) {
        this.contentDao.insert(content);
        return content;
    }

    /**
     * 修改数据
     *
     * @param content 实例对象
     * @return 实例对象
     */
    @Override
    public Content update(Content content) {
        this.contentDao.update(content);
        return this.queryById(content.getContId());
    }

    /**
     * 通过主键删除数据
     *
     * @param contId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer contId) {
        return this.contentDao.deleteById(contId) > 0;
    }
}