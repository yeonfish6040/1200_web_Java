package com.board.boardprac.controller;

import com.board.boardprac.DevController.logger;
import com.board.boardprac.dto.MemberDto;
import com.board.boardprac.dto.SubjectDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

//@Controller
public class GetController2 {

	private logger log = new logger();
	@GetMapping("/viewtest")
	public String showView(@ModelAttribute("dto") MemberDto dto) {
		log.info("----------------");
		log.info("GetController2:showView() : Called");
		log.info("dto : " + dto.toString());
		log.info("----------------");
		return "thymeleaf/view";
	}
	
	@GetMapping("/testresult")
	public String showResult(@ModelAttribute("dto") SubjectDto dto) {
		log.info("----------------");
		log.info("GetController2:showResult() : Called");
		log.info("dto : " + dto.toString());
		log.info("----------------");
		return "thymeleaf/testresult2";
	}
}
