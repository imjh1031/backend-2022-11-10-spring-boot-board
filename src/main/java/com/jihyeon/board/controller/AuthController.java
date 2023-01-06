package com.jihyeon.board.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jihyeon.board.dto.auth.AuthPostDto;
import com.jihyeon.board.dto.auth.LoginDto;
import com.jihyeon.board.dto.response.ResponseDto;

@RestController
@RequestMapping("api/auth/")
public class AuthController {

	@PostMapping("")
	public ResponseDto<LoginDto> login(@RequestBody AuthPostDto requestBody) {
		LoginDto result = new LoginDto("JWT", 3600000);
		return ResponseDto.setSuccess("login success", result);
	}
}
