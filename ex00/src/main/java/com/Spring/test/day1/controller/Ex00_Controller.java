package com.Spring.test.day1.controller;


import java.util.DoubleSummaryStatistics;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.swing.Spring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/example/*")
@Slf4j
public class Ex00_Controller {
	
	@RequestMapping("/eat")
	public String eating() {
		return "매운 갈비찜 20인분 먹고있음";
	}
	
//	@RequestMapping("/sleep")
//	public String sleeping() {
//		log.info("--------------------------");
//		log.info("Sleeping");
//		log.info("--------------------------");
//		return "20시간째 자는중...";
//	}
	
	@RequestMapping("/login")
	public String login(
			@RequestParam String id,
			@RequestParam String pw
			) {
		log.info("\n"+id+"\n"+pw);
		return "sa";
	}
	
	@RequestMapping("")
	public String luck() {
		return "로또 50회차 미당첨분이 나에게로....";
	}
	
	
	@GetMapping("/play/{args1}")
	public String play(@PathVariable("args1") String var) {
		log.info(var);
		return "20시간째 축제중 ...";
	}
	
	@GetMapping @PostMapping
	public String sing(
			@RequestParam String name,
			@RequestParam String song,
			@RequestParam int duration) {
		log.info(song+name+duration);
		return "20시간째 노래중 ...";
	}
	
}
