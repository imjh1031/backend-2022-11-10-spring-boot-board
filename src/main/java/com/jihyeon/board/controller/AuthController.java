package com.jihyeon.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jihyeon.board.dto.auth.AuthPostDto;
import com.jihyeon.board.dto.auth.LoginDto;
import com.jihyeon.board.dto.response.ResponseDto;
import com.jihyeon.board.service.AuthService;

@RestController
@RequestMapping("api/auth/")
public class AuthController {
	@Autowired AuthService authService;

	@PostMapping("")
	public ResponseDto<LoginDto> login(@RequestBody AuthPostDto requestBody) {
		LoginDto result = new LoginDto("JWT", 3600000);
		return ResponseDto.setSuccess("login success", result);
		
	}
	
	@GetMapping("")
	public String hello() {
		return authService.hello();
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	
}
