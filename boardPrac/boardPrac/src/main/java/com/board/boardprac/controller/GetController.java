package com.board.boardprac.controller;

import com.board.boardprac.DevController.logger;
import com.board.boardprac.dto.MemberDto;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
public class GetController {

	private logger log = new logger();
	
	@GetMapping("/board")
	public String showBoard() {
		log.info("----------------");
		log.info("GetController:showBoard() : Called");
		log.info("----------------");
		return "(Get) Board like this";
	}
	
	//http://localhost:10002/request?name=v1&email=v2&organization=v3
	//Getter/Setter Auto Configuration
	@GetMapping(value="/request")
	public String getRequestParam(MemberDto memberdto) {
		return memberdto.toString();
	}
	
}
