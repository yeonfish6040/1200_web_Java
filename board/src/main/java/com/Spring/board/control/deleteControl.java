package com.Spring.board.control;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class deleteControl {
	@DeleteMapping("/member/{variable}")
	public String DeleteMember(@PathVariable String variable) {
		return variable;
	}
	
	@DeleteMapping("/req")
	public String DeleteRequest(@RequestParam String email) {
		return email;
	}
}
