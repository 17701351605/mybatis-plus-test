package com.dj.mp.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dj.mp.domain.User;

public interface UserService extends IService<User> {

    boolean saveUser(User user);


}
