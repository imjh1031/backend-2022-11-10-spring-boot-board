package com.jihyeon.board.service;

import org.springframework.stereotype.Service;

import com.jihyeon.board.dto.auth.AuthPostDto;
import com.jihyeon.board.dto.auth.LoginDto;
import com.jihyeon.board.dto.response.ResponseDto;

@Service
public class AuthService {
	public ResponseDto<LoginDto> login(AuthPostDto dto){
	      LoginDto result = new LoginDto("",3600000);
	      return ResponseDto.setSuccess("", result); 
	}
}
