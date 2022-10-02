package com.Spring.board.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.board.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/board*")
@Slf4j
public class mainControl {
	@RequestMapping("")
	public String main() {
		log.info("----------");
		log.info("main");
		log.info("----------");
		return "Board like this";
	}
	
	@RequestMapping("/request")
	public String getRequestParam(MemberDto memberdto) {
		return memberdto.toString();
	}
}
