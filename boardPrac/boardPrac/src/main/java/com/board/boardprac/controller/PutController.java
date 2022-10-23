package com.board.boardprac.controller;

import com.board.boardprac.DevController.logger;
import com.board.boardprac.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@RestController
public class PutController {

	private logger log = new logger();
	
	//http://localhost:10002/member1
	@PutMapping("/member1")
	public String putMemberDto1(@RequestBody MemberDto memberdto) {
		return memberdto.toString();
	}
	
	//http://localhost:10002/member2
	@PutMapping("/member2")
	public MemberDto putMemberDto2(@RequestBody MemberDto memberdto) {
		return memberdto;
	}
	
	//Extends putMemberDto2
	//http://localhost:10002/member2
	@PutMapping("/member3")
	public ResponseEntity putMemberDto3(@RequestBody MemberDto memberdto){
		return ResponseEntity
			 .status(HttpStatus.ACCEPTED)
			 .body(memberdto);
	}
}