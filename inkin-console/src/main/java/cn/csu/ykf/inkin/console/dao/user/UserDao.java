package cn.csu.ykf.inkin.console.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csu.ykf.inkin.console.mapper.UserMapper;

@Service
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public boolean login(String username, String password) {
        return userMapper.login(username, password) > 0;
    }
}
