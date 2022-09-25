package com.Spring.test.day1.controller;

import java.net.http.HttpRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
public class Err_Controller implements ErrorController{
	@RequestMapping("/error")
	public String errorStringHandler(HttpServletRequest req) {
		Object statusObject = req.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
		
		if (statusObject != null) {
			int status_code = Integer.valueOf(statusObject.toString());
			
			if (status_code == HttpStatus.NOT_FOUND.value()) {
				return "Error, 404404404404404404404404404404404404404404404404404404404404404404404404";
			}
			return "Error, 500500500500500500500500500500500500500500500500500500500500500500500500";
		}
		return "????????????????????????";
	}
}
