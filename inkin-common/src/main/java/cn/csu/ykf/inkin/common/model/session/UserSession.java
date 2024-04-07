package cn.csu.ykf.inkin.common.model.session;

import lombok.Data;

@Data
public class UserSession {

    private Long userId;
    private String name;
    private String token;
}
