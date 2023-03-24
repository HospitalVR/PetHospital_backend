package com.rjsj.pethospital.controller;

import com.rjsj.pethospital.entity.User;
import com.rjsj.pethospital.service.LoginService;
import com.rjsj.pethospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.login(user));
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity logout() {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.logout());
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllCommonUser());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseEntity<Void> delete(String name) {
        userService.deleteByName(name);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
