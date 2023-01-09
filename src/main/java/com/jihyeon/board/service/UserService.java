package com.jihyeon.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jihyeon.board.dto.response.ResponseDto;
import com.jihyeon.board.dto.user.PostUserDto;
import com.jihyeon.board.dto.user.PostUserResponseDto;
import com.jihyeon.board.entity.MemberEntity;
import com.jihyeon.board.repository.MemberRepository;

@Service
public class UserService {
	
	@Autowired MemberRepository memberRepository;

	public ResponseDto<PostUserResponseDto> postUser(PostUserDto dto) {
		String password = dto.getPassword();
		String password2 = dto.getPassword2();
		
		if (!password.equals(password2)) 
			return ResponseDto.setFailed("비밀번호가 맞지 않습니다.");
			
		MemberEntity member = MemberEntity
				.builder()
				.email(dto.getEmail())
				.password(dto.getPassword())
				.nickname(dto.getNickname())
				.telNumber(dto.getTelNumber())
				.address(dto.getAddress() + " " + dto.getAddressDetail())
				.build();
		
		memberRepository.save(member);
		
		return ResponseDto.setSuccess("회원가입에 성공했습니다.", new PostUserResponseDto(true));
		
	}
	
}
