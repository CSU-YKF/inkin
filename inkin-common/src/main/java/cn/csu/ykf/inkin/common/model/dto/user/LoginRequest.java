package cn.csu.ykf.inkin.common.model.dto.user;

import lombok.Data;

@Data
public class LoginRequest {

    private String name;
    private String password;
}
