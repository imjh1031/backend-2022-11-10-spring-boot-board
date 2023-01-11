package com.jihyeon.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jihyeon.board.dto.response.ResponseDto;
import com.jihyeon.board.dto.user.GetUserResponseDto;
import com.jihyeon.board.dto.user.PatchUserDto;
import com.jihyeon.board.dto.user.PostUserDto;
import com.jihyeon.board.dto.user.ResultResponseDto;
import com.jihyeon.board.service.UserService;

// 회원가입 화면
@RestController
@RequestMapping("api/user/")
public class UserController {
	
	@Autowired UserService userService;
	
	// c = create
	@GetMapping("{email}")
	public ResponseDto<GetUserResponseDto> getUser(@PathVariable("email") String email) {
		return userService.getUser(email);
	}
	
	// r = read
	@PostMapping("")
	public ResponseDto<ResultResponseDto> postUser(@RequestBody PostUserDto requestBody) {
		return userService.postUser(requestBody);
	}
	
	// u = update
	@PatchMapping("")
	public ResponseDto<GetUserResponseDto> patchUser(@RequestBody PatchUserDto requestBody) {
		return userService.patchUser(requestBody);
	}
	
	// d = delete
	@DeleteMapping("{email}")
	public ResponseDto<ResultResponseDto> deleteUser(@PathVariable("email") String email) {
		return userService.deleteUser(email);
	}
}
