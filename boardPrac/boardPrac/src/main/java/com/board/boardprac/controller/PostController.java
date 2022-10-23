package com.board.boardprac.controller;

import com.board.boardprac.DevController.logger;
import com.board.boardprac.dto.MemberDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@RestController
public class PostController {

	private logger log = new logger();
	
	@PostMapping("/board")
	public String showBoard() {
		log.info("----------------");
		log.info("PostController:showBoard() : Called");
		log.info("----------------");
		return "(Post) Board like this";
	}
	
	//http://localhost:10002/request
	//Getter/Setter Auto Configuration
	@PostMapping(value="/request")
	public String getRequestParam(@RequestBody MemberDto memberdto) {
		log.info("MemberDTO");
		return memberdto.toString();
	}
	
}
