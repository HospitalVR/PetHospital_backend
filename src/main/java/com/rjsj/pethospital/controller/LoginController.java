package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.User;
import com.rjsj.pethospital.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.login(user));
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity logout() {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.logout());
    }
}
