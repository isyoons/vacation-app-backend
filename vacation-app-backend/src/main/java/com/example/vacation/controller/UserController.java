package com.example.vacation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vacation.payload.UserInfo;
import com.example.vacation.security.CurrentUser;
import com.example.vacation.security.UserPrincipal;
import com.example.vacation.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
    private UserService userService;
	
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    // 사용자정보조회
    @GetMapping("/{username}")
    public UserInfo getUserInfo(@PathVariable(value = "username") String username) {
        return userService.getUserInfo(username);
    }
    
    // 토큰정보확인
    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public UserInfo getCurrentUser(@CurrentUser UserPrincipal currentUser) {
    	UserInfo userInfo = new UserInfo(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userInfo;
    }
}
