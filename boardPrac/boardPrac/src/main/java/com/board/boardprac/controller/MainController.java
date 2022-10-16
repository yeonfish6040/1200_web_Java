package com.board.boardprac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping(value="/")
	public String loadPage() {
		return "thymeleaf/testresult.html";
	}
}
