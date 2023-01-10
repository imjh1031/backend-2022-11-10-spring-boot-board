package com.jihyeon.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jihyeon.board.dto.response.ResponseDto;
import com.jihyeon.board.dto.user.GetUserResponseDto;
import com.jihyeon.board.dto.user.PostUserDto;
import com.jihyeon.board.dto.user.PostUserResponseDto;
import com.jihyeon.board.entity.MemberEntity;
import com.jihyeon.board.repository.MemberRepository;

@Service
public class UserService {
	
	@Autowired MemberRepository memberRepository;
	
	public ResponseDto<GetUserResponseDto> getUser(String email) {
		// 해당 이메일을 데이터베이스에서 검색
		MemberEntity member;
		
		try {
			member = memberRepository.findById(email).get();
			
		// 존재하지않으면 "Not Exist User" 메세지를 포함한 Failed Response 반환
		} catch (Exception e) {
			return ResponseDto.setFailed("Not Exist User");
		}
		// 존재하면 User 정보 반환
		
//      1.
//		GetUserResponseDto responseData = new GetUserResponseDto();
//		responseData.setEmail(member.getEmail());
//		responseData.setNickname(member.getNickname());
//		responseData.setProfile(member.getProfile());
//		responseData.setTelNumber(member.getTelNumber());
//		responseData.setAddress(member.getAddress());
//		
//		return ResponseDto.setSuccess("Get User Success", responseData);
		
//		2.
//		GetUserResponseDto responseData =
//				GetUserResponseDto
//				.builder()
//				.email(member.getEmail())
//				.nickname(member.getNickname())
//				.profile(member.getProfile())
//				.telNumber(member.getTelNumber())
//				.address(member.getAddress())
//				.build();
//		
//		return ResponseDto.setSuccess("Get User Success", responseData);
		
//		3.
//		return ResponseDto.setSuccess(
//				"Get User Success",
//				new GetUserResponseDto(
//						member.getEmail(),
//						member.getNickname(),
//						member.getProfile(),
//						member.getTelNumber(),
//						member.getAddress()
//						)
//				);
		
		return ResponseDto.setSuccess("Get User Success", new GetUserResponseDto(member));
		
	}

	public ResponseDto<PostUserResponseDto> postUser(PostUserDto dto) {
		
		// 데이터베이스에 해당 이메일이 존재하는지 체크
		// 존재한다면 Failed Response를 반환
		String email = dto.getEmail();
		
		// if (memberRepository.existsById(email))
		//     return ResponseDto.setFailed("이미 존재하는 이메일입니다.");
		// 이렇게 써도 되지만 try, catch를 쓰는 것이 좋음. 쓰더라도 if문은 안에 씀 
		
		try {
			if (memberRepository.existsById(email))
				return ResponseDto.setFailed("이미 존재하는 이메일입니다.");
		} catch (Exception e) {
			return ResponseDto.setFailed("데이터베이스 오류입니다.");
		}
		
//		try {
//			MemberEntity member = memberRepository.findById(email).get();
//		} catch (Exception e) {
//			return ResponseDto.setFailed("이미 존재하는 이메일입니다.");
//		}
		
		String password = dto.getPassword();
		String password2 = dto.getPassword2();
		
		// 비밀번호 검증
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
		
		// JpaRepository.save(Entity) 메서드
		// 해당 Entity Id가 데이터베이스 테이블에 존재하지 않으면!
		// Entity INSERT 작업을 수행
		// !!! 하지만 !!!
		// 해당 Entity Id가 데이터베이스 테이블에 존재하면!
		// 존재하는 Entity UPDATE 작업을 수행
		memberRepository.save(member);
		
		return ResponseDto.setSuccess("회원가입에 성공했습니다.", new PostUserResponseDto(true));
		
	}
	
}
