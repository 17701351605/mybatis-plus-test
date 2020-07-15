package com.dj.mp.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dj.mp.domain.ResultModel;
import com.dj.mp.domain.User;
import com.dj.mp.domain.UserQuery;
import com.dj.mp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Mybatis-Plus Where 操作
 */
@RestController
public class QueryController {

    @Autowired
    private UserService userService;

    /**
     * 查询单条
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("/getOne")
    public ResultModel getOne(String username, String password) {
        try {
            // MP 查询条件构造器
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", username);
            queryWrapper.eq("password", password);
            // where username = ? and password = ?
            User user = userService.getOne(queryWrapper);
            return new ResultModel().success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * 简单查询
     *
     * @return
     */
    @RequestMapping("/list")
    public ResultModel list(UserQuery query) {
        try {
            // 条件构造器
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("sex", query.getSex());
            queryWrapper.like("username", query.getUsername());
            // queryWrapper.ge("age", 10);
            // queryWrapper.le("age", 20);
            // queryWrapper.between("age", 10, 20);
            // where sex = ? and like %?% and age >= 10 and age <= 20
            // .list(); // 查询全部
            List<User> userList = userService.list(queryWrapper);
            return new ResultModel().success(userList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * OR查询
     *
     * @return
     */
    @RequestMapping("/list/or")
    public ResultModel listOr() {
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper();
            // where age = 20 or sex = 2 or username = zs
//            queryWrapper.eq("age", "20");
//            queryWrapper.or().eq("sex", "2");
//            queryWrapper.or().eq("username", "zs");

            // 一行
//            queryWrapper.eq("age", 20).or().eq("sex", 2).or().eq("username", "zs");

            // where age = 20 and (sex = 1 or username = zs)
            // lambda
//            queryWrapper.eq("age", 20).and(q -> q.eq("sex", "1").or().eq("username", "zs"));

//            queryWrapper.eq("age", 20);
//            queryWrapper.and(q -> q.eq("sex", 1).or().eq("username", "zs"));
            List<User> userList = userService.list(queryWrapper);
            return new ResultModel().success(userList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * 排序查询
     *
     * @return
     */
    @RequestMapping("/list/order")
    public ResultModel listOrder(UserQuery query) {
        try {
            // 条件构造器
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            // 排序
            // orderByAsc(columns)/orderByDesc(columns) 升序/降序 columns可以填多列
            // queryWrapper.orderByAsc("id", "age");
            // SQL ... order by id DESC, age DESC
            // 组合
            queryWrapper.orderByAsc("age");// 可以多列
            queryWrapper.orderByDesc("id");
            // 最终SQL ... order by age ASC, id DESC 排序字段的先后顺序与设置的顺序有关
            List<User> userList = userService.list(queryWrapper);
            return new ResultModel().success(userList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * 分组查询
     *
     * @return
     */
    @RequestMapping("/list/group")
    public ResultModel listGroup() {
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.groupBy("age", "sex");
            List<User> userList = userService.list(queryWrapper);
            return new ResultModel().success(userList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * 指定列查询
     *
     * @return
     */
    @RequestMapping("/list/portion")
    public ResultModel queryPortion() {
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.select("id", "username");
            List<User> userList = userService.list(queryWrapper);
            return new ResultModel().success(userList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

}
