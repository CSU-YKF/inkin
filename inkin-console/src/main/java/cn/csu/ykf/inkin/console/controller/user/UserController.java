package cn.csu.ykf.inkin.console.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.csu.ykf.inkin.common.model.dto.user.LoginRequest;
import cn.csu.ykf.inkin.common.model.po.User;
import cn.csu.ykf.inkin.console.dao.user.UserDao;

@RestController("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if (userDao.login(request.getName(), request.getPassword())) {
            return ResponseEntity.ok().body("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
