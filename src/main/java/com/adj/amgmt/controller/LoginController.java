package com.adj.amgmt.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class LoginController {

	// it should be the home page(first landing page)
	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping("/login")
	public String loginView() {
		return "login";
	}

	@RequestMapping("/authFail")
	public String wrongCredentials(Model model) {
		model.addAttribute("wrongCredentials", "Invalid User Details");
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

	// ---------------------------------------------------------------------------------------------------------
//
//	@GetMapping("/book/{id}")
//	public String getBook(@PathVariable Integer id, Model model) {
//		Book book = bookService.getBook(id);
//		model.addAttribute("bookName", book.getBookName());
//		model.addAttribute("bookBill", Base64.getEncoder().encodeToString(book.getBookBill().getData()));
//		return "viewbook";
//	}
}
