package com.board.boardprac.controller;

import com.board.boardprac.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
public class PostController2 {
	
	@PostMapping("/viewtest")
	public String showView(@ModelAttribute("dto") MemberDto dto) {
		log.info("----------------");
		log.info("PostController:showView() : Called");
		log.info("----------------");
		return "view";
	}

}
