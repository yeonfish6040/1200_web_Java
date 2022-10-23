package com.board.boardprac.controller;

import com.board.boardprac.DevController.logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

//@RestController
public class DeleteController {

	private logger log = new logger();

	@DeleteMapping("/member/{variable}")
	public String DeleteMember(@PathVariable String variable) {
		return variable;
	}
	
	//http://localhost:10002/request?email=XXX
	@DeleteMapping(value="/request")
	public String DeleteRequest(@RequestParam String email) {
		return email + "을 가지고 있는 유저가 delete됩니다.";
	}
}
