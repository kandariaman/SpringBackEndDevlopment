package com.gfg.jbdll.service.resources;

import com.gfg.jbdll.domain.MyUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
    private String username;
    private String password;
    private boolean isAdmin;

    public MyUser toUser(){
        return MyUser.builder().username(username).password(password).authorities(isAdmin?"admin": "user").build();
    }
}
