package com.dj.mp.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.mp.domain.User;
import com.dj.mp.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean saveUser(User user){
        //super.getBaseMapper().insert(user);
        //this.save(user);
        super.save(user);
        return true;
    }

}
