package com.example.board.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.HelloDto;
import com.example.board.dto.response.ResponseDto;
// Response로 HTML을 반환하는 Controller가 아닌
// Response Body에 직접 데이터를 담아서 응답하는  Controller
// @Controller + @ResponseBody
@RestController

//requestMapping : //http://localhost:4040/(end-point)/
//end-point의 패턴을 지정하여 해당 패턴의 end-point 일때 해당 Controller를 실행
@RequestMapping("apis/")
public class MainController {
	
	static final String HELLO = "hello";
	
	//http방식://호스트:포트/ 뒤에 부터해당.
	//http://localhost:4040/ 뒤에 부터해당.
	
//	@GetMapping(end-point) : 해당 end-point로 Get 방식의 Request가 왔을 때 동작
	@GetMapping("")
	public String hello() {
		return "Hello Spring Boot World!";
	}
	
	@GetMapping(HELLO)
//	@RequestParam(name="", value="", required=true, defaultvalue="" )
//	: URL로 데이터를 받는 경우 (Get, Delete) 쿼리 형태로 데이터를 받음
//	http://호스트:포트/end-point?name=value&...
	public String getHello(@RequestParam(name = "name", required=false, defaultValue="james") String name) {
		return "this is get method , endpoint'/hello'" + name;
	}
	
	@GetMapping(HELLO + "/{name}/spring")
//		@PathVariable(path) : URL 데이터를 받는 경우(Get, Delete) path 형태로 데이터를 받음
//		http://호스트:포트/end-point/VARIABLE
	public String getHelloName(@PathVariable("name") String name) {
		return "this is get method , endpoint '/hello' " + name;
	}
//	@PostMapping(end-point) : 해당 end-point로 Post 방식의 Request가 왔을 때 동작
	@PostMapping(HELLO)
//	@RequestBody : 해당 Request의 body에서 JSON을 인식하여 인스턴스로 변경해줌
	public ResponseDto<HelloDto> postHello(@RequestBody HelloDto requestBody) {
		return ResponseDto.setSuccess("hello", requestBody);
	}
	
//	@PutMapping(end-point) :해당 end-point로 Put방식의 Request가 왔을때 동작
	@PutMapping(HELLO)
	public String PutHello() {
		return "This is put method, end-point '/hello'";
	}
//	@PatchMapping(end-point) :해당 end-point로 Patch 방식의 Request가 왔을때 동작
	@PatchMapping(HELLO)
	public String PatchHello() {
		return "This is Patch method, end-point '/hello'";
	}
//	@DeleteMapping(end-point) : delete방식의 request왔을때 동작
	@DeleteMapping(HELLO)
	public String deleteHello() {
		return "This is delete method, end-point '/hello'";
	}
}
