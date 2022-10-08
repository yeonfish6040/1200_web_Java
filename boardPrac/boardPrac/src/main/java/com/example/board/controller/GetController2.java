package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.board.dto.MemberDto;
import com.example.board.dto.SubjectDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GetController2 {
	@GetMapping("/viewtest")
	public String showView(@ModelAttribute("dto") MemberDto dto) {
		log.info("----------------");
		log.info("GetController2:showView() : Called");
		log.info("dto : " + dto.toString());
		log.info("----------------");
		return "view";
	}
	
	@GetMapping("/testresult")
	public String showResult(@ModelAttribute("dto") SubjectDto dto) {
		log.info("----------------");
		log.info("GetController2:showResult() : Called");
		log.info("dto : " + dto.toString());
		log.info("----------------");
		return "testresult2";
	}
}
