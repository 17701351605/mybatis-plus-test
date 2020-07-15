package com.dj.mp.web;

import com.dj.mp.domain.ResultModel;
import com.dj.mp.domain.User;
import com.dj.mp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Mybatis-Plus 基础CRUD操作
 */
@RestController
public class CRUDController {

    /**
     * 用户服务
     */
    @Autowired
    private UserService userService;

    /**
     * 新增
     *
     * @param user 用户信息
     * @return
     */
    @RequestMapping("/insert")
    public ResultModel insert(User user) {
        try {
            // 新增并返回主键
            userService.saveUser(user);
//            userService.save(user);
            return new ResultModel().success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * 根据主键ID获取用户信息
     *
     * @param id 主键
     * @return
     */
    @RequestMapping("/get")
    public ResultModel get(Integer id) {
        try {
            // 根据主键ID获取用户信息
            User user = userService.getById(id);
            return new ResultModel().success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * 根据主键ID修改用户信息
     *
     * @param user 用户信息
     * @return
     */
    @RequestMapping("/update")
    public ResultModel update(User user) {
        try {
            // 根据主键ID更新
            userService.updateById(user);
            return new ResultModel().success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * 根据主键删除用户信息
     *
     * @param id 主键ID
     * @return
     */
    @RequestMapping("/delete")
    public ResultModel delete(Integer id) {
        try {
            userService.removeById(id);
            return new ResultModel().success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

}
