package com.adj.amgmt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController extends Exception {

	// 500(Internal_Server_Error ) error handling
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public String error500(Model model, Exception exception, HttpServletRequest request) {
		model.addAttribute("msg", "500 Internal Server Error..." + exception + "-----" + request);
		return "500";
	}

	// 404 PageNotFoundException handler
	@ExceptionHandler(value=NoHandlerFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String error404(Model model, Exception exception, HttpServletRequest request) {
		System.out.println("Page Not Found");
		model.addAttribute("msg", "404 Page Not Found..." + exception + "-----" + request);
		return "404";
	}

}
