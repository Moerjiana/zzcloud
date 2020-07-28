package com.amay.user.service.impl;

import com.amay.user.dao.MyUserDao;
import com.amay.user.entity.MyUser;
import com.amay.user.service.MyUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MyUser)表服务实现类
 *
 * @author makejava
 * @since 2020-07-28 15:54:12
 */
@Service("myUserService")
public class MyUserServiceImpl implements MyUserService {
    @Resource
    private MyUserDao myUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public MyUser queryById(Integer userId) {
        return this.myUserDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<MyUser> queryAllByLimit(int offset, int limit) {
        return this.myUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param myUser 实例对象
     * @return 实例对象
     */
    @Override
    public MyUser insert(MyUser myUser) {
        this.myUserDao.insert(myUser);
        return myUser;
    }

    /**
     * 修改数据
     *
     * @param myUser 实例对象
     * @return 实例对象
     */
    @Override
    public MyUser update(MyUser myUser) {
        this.myUserDao.update(myUser);
        return this.queryById(myUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.myUserDao.deleteById(userId) > 0;
    }
}