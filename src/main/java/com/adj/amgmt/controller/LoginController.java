package com.adj.amgmt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	// it should be the home page
	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping("/login")
	public String getloginPage() {
		return "login";
	}

	/*
	 * // not working
	 * 
	 * @RequestMapping(value = "/logout", method = RequestMethod.GET) public String
	 * logoutPage(HttpServletRequest request, HttpServletResponse response) {
	 * System.out.println("logout controlle******************"); Authentication auth
	 * = SecurityContextHolder.getContext().getAuthentication(); if (auth != null) {
	 * new SecurityContextLogoutHandler().logout(request, response, auth); } return
	 * "/login"; }
	 */

//	@RequestMapping(value = "/error")
//	public String errorPage() {
//		return "error";
//	}

}
