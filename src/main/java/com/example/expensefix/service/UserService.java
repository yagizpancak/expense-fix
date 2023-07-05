package com.example.expensefix.service;

import com.example.expensefix.dto.LoginRequest;
import com.example.expensefix.dto.SignupRequest;
import com.example.expensefix.exception.GenericBadRequestException;
import com.example.expensefix.model.User;
import com.example.expensefix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;


	public void addUser(SignupRequest userInfo) {
		User user = new User();
		user.setEmail(userInfo.getEmail());
		user.setUsername(userInfo.getUsername());
		user.setPassword(userInfo.getPassword());

		userRepository.save(user);
	}

	public Boolean login(LoginRequest loginRequest) throws GenericBadRequestException {
		var user = userRepository.findByUsername(loginRequest.getUsername())
				.orElseThrow(()-> new GenericBadRequestException("There is no user with this username: " + loginRequest.getUsername()));

		if(!user.getPassword().equals(loginRequest.getPassword())){
			throw new GenericBadRequestException("Email or password is invalid.");
		}
		return true;
	}
}
