package com.example.expensefix.controller;

import com.example.expensefix.dto.LoginRequest;
import com.example.expensefix.dto.SignupRequest;
import com.example.expensefix.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	private final UserService userService;

	@PostMapping("/signup")
	public void signup(@Valid @RequestBody SignupRequest userInfo){
		userService.addUser(userInfo);
	}

	@PostMapping("/login")
	public Boolean login(@Valid @RequestBody LoginRequest userInfo){
		return userService.login(userInfo);
	}


}
