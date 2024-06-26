package com.gfg.jbdll.controller;

import com.gfg.jbdll.domain.MyUser;
import com.gfg.jbdll.service.MyUserDetailService;
import com.gfg.jbdll.service.resources.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    MyUserDetailService myUserDetailService;

    @PostMapping(value = "/signup")
    public ResponseEntity<?> addUser(UserRequest userRequest) {
        myUserDetailService.addUser(userRequest.toUser());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
