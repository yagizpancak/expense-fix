package com.example.expensefix.controller;

import com.example.expensefix.dto.LoginRequest;
import com.example.expensefix.dto.SignupRequest;
import com.example.expensefix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	private final UserService userService;

	@PostMapping("/signup")
	public void signup(@RequestBody SignupRequest userInfo){
		userService.addUser(userInfo);
	}

	@PostMapping("/login")
	public Boolean login(@RequestBody LoginRequest userInfo){
		return userService.login(userInfo);
	}


}
