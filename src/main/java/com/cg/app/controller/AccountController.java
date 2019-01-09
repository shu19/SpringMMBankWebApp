package com.cg.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.app.account.SavingsAccount;
import com.cg.app.account.service.SavingsAccountService;


@Controller
public class AccountController {
	
	@Autowired
	SavingsAccountService service;
	
	@RequestMapping("/getAll")
	public String getAllSavingAccounts(Model model) {
		List<SavingsAccount> accounts=service.getAllSavingsAccount();
		model.addAttribute("accounts",accounts);		
		return "AccountDetails";
	}
}
