package com.jihyeon.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jihyeon.board.dto.response.ResponseDto;
import com.jihyeon.board.dto.user.GetUserResponseDto;
import com.jihyeon.board.dto.user.PostUserDto;
import com.jihyeon.board.dto.user.PostUserResponseDto;
import com.jihyeon.board.service.UserService;

// 회원가입 화면
@RestController
@RequestMapping("api/user/")
public class UserController {
	
	@Autowired UserService userService;
	
	@GetMapping("{email}")
	public ResponseDto<GetUserResponseDto> getUser(@PathVariable("eamil") String email) {
		return userService.getUser(email);
	}
	
	@PostMapping("")
	public ResponseDto<PostUserResponseDto> postUser(@RequestBody PostUserDto requestBody) {
		return userService.postUser(requestBody);
	}
}
