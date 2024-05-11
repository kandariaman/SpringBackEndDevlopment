package com.gfg.jbdll.controller;

import com.gfg.jbdll.domain.MyUser;
import com.gfg.jbdll.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    MyUserDetailService myUserDetailService;

    @PostMapping(value = "/signup")
    public ResponseEntity<?> addUser(MyUser user) {
        myUserDetailService.addUser(user);
    }
}
