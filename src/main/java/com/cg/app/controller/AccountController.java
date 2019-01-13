package com.cg.app.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cg.app.account.CurrentAccount;
import com.cg.app.account.SavingsAccount;
import com.cg.app.account.service.CurrentAccountService;
import com.cg.app.account.service.SavingsAccountService;

@Controller
@SessionAttributes("account")
public class AccountController {
	Logger logger = Logger.getLogger(AccountController.class);

	@Autowired
	SavingsAccountService savingsAccountService;

	@Autowired
	CurrentAccountService currentAccountService;

	@RequestMapping(value = "/addNewSA", method = RequestMethod.GET)
	public String addNewSavingAccount(Map<String, SavingsAccount> map) {
		map.put("account", new SavingsAccount());
		return "openNewAccount";
	}

	@RequestMapping(value = "/addNewSA", method = RequestMethod.POST)
	public String addNewSavingAccount(@ModelAttribute("account") SavingsAccount savingsAccount, BindingResult result) {
		savingsAccountService.createNewAccount(savingsAccount.getBankAccount().getAccountHolderName(),
				savingsAccount.getBankAccount().getAccountBalance(), savingsAccount.isSalary());
		if (result.hasErrors()) {
			return "openNewAccount";
		}
		System.out.println(savingsAccount);
		return "redirect:afterAddNewSA";
	}

	@RequestMapping(value = "/addNewCA", method = RequestMethod.GET)
	public String addNewCurrentAccount(Map<String, SavingsAccount> map) {
		map.put("account", new SavingsAccount());
		return "openNewAccount";
	}

	@RequestMapping(value = "/addNewCA", method = RequestMethod.POST)
	public String addNewCurrentAccount(@ModelAttribute("account") CurrentAccount currentAccount, BindingResult result) {
		currentAccountService.createNewAccount(currentAccount.getBankAccount().getAccountHolderName(),
				currentAccount.getBankAccount().getAccountBalance(), currentAccount.getOdLimit());
		if (result.hasErrors()) {
			return "openNewAccount";
		}
		System.out.println(currentAccount);
		return "redirect:afterAddNewCA";
	}

	@RequestMapping(value = "/afterAddNewSA")
	public String afterAddNewSavingAccount() {
		return "redirect:getAll";
	}

	@RequestMapping("/getAll")
	public String getAllSavingAccounts(Model model) {
		List<SavingsAccount> accounts = savingsAccountService.getAllSavingsAccount();
		model.addAttribute("accounts", accounts);
		return "AccountDetails";
	}

	int flagAccountHolderName = 1;

	@RequestMapping(value = "/sortbyAccountHolderName", method = RequestMethod.GET)
	public String sortbyAccountHolderName(Model model) {
		TreeSet<SavingsAccount> accounts = new TreeSet<>(new Comparator<SavingsAccount>() {

			@Override
			public int compare(SavingsAccount o1, SavingsAccount o2) {
				return flagAccountHolderName * o1.getBankAccount().getAccountHolderName()
						.compareTo(o2.getBankAccount().getAccountHolderName());
			}
		});
		accounts.addAll(savingsAccountService.getAllSavingsAccount());

		model.addAttribute("accounts", accounts);
		flagAccountHolderName *= -1;
		return "AccountDetails";
	}

	int flagAccountNumber = 1;

	@RequestMapping(value = "/sortByAccountNumber", method = RequestMethod.GET)
	public String sortByAccountNumber(Model model) {

		TreeSet<SavingsAccount> accounts = new TreeSet<>(new Comparator<SavingsAccount>() {

			@Override
			public int compare(SavingsAccount o1, SavingsAccount o2) {
				return flagAccountNumber * o1.getBankAccount().getAccountNumber()
						- o2.getBankAccount().getAccountNumber();
			}
		});
		accounts.addAll(savingsAccountService.getAllSavingsAccount());

		model.addAttribute("accounts", accounts);

		flagAccountNumber *= -1;

		return "AccountDetails";
	}

	int flagAccountBalance = 1;

	@RequestMapping(value = "/sortByAccountBalance", method = RequestMethod.GET)
	public String sortByAccountBalance(Model model) {
		TreeSet<SavingsAccount> accounts = new TreeSet<>(new Comparator<SavingsAccount>() {

			@Override
			public int compare(SavingsAccount o1, SavingsAccount o2) {
				return (int) (flagAccountBalance
						* (o1.getBankAccount().getAccountBalance() - o2.getBankAccount().getAccountBalance()));
			}
		});
		accounts.addAll(savingsAccountService.getAllSavingsAccount());
		flagAccountBalance *= -1;
		model.addAttribute("accounts", accounts);
		return "AccountDetails";
	}

	int flagSortBySalary = 1;

	@RequestMapping(value = "/sortBySalary", method = RequestMethod.GET)
	public String sortBySalary(Model model) {
		TreeSet<SavingsAccount> accounts = new TreeSet<>(new Comparator<SavingsAccount>() {

			@Override
			public int compare(SavingsAccount o1, SavingsAccount o2) {
				if (o1.isSalary() == o2.isSalary()) {
					return 1 * flagSortBySalary;
				} else {
					return -1 * flagSortBySalary;
				}
			}
		});
		accounts.addAll(savingsAccountService.getAllSavingsAccount());
		flagSortBySalary *= -1;
		model.addAttribute("accounts", accounts);
		return "AccountDetails";
	}

	@RequestMapping("/updateForm")
	public String searchAccount() {
		return "UpdateForm";
	}

	@RequestMapping("/updateSaving")
	public String updateForm(HttpServletRequest request, Model model) {
		int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
		SavingsAccount account = savingsAccountService.getAccountById(accountNumber);
		model.addAttribute("account", account);
		return "UpdateAccount";
	}

	@RequestMapping("/updateSavingAccount")
	public String update(HttpServletRequest request, Model model) {

		int accountNumber = Integer.parseInt(request.getParameter("txtAccNo"));
		String accountHolderName = request.getParameter("txtAccHN");
		double accountBalance = Double.parseDouble(request.getParameter("txtAccBal"));
		boolean salary = request.getParameter("rgSalary").equalsIgnoreCase("yes") ? true : false;

		SavingsAccount savingsAccount = new SavingsAccount(accountNumber, accountHolderName, accountBalance, salary);
		savingsAccountService.updateAccount(savingsAccount);
		return "redirect:getAll";
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public String withdraw() {
		return "withdraw";
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String withdraw(@RequestParam("txtAccNo") int accountNumber, @RequestParam("txtAmount") int amount) {
		SavingsAccount account = savingsAccountService.getAccountById(accountNumber);
		savingsAccountService.withdraw(account, amount);
		return "redirect:getAll";
	}

	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public String deposit() {
		return "deposit";
	}

	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public String deposit(@RequestParam("txtAccNo") int accountNumber, @RequestParam("txtAmount") int amount) {
		SavingsAccount account = savingsAccountService.getAccountById(accountNumber);
		savingsAccountService.deposit(account, amount);
		return "redirect:getAll";
	}

	@RequestMapping(value = "/fundTransfer", method = RequestMethod.GET)
	public String fundTransfer() {
		return "fundTransfer";
	}

	@RequestMapping(value = "/fundTransfer", method = RequestMethod.POST)
	public String fundTransfer(@RequestParam("txtSenderAccNo") int senderAccountNumber,
			@RequestParam("txtReceiverAccNo") int receiverAccountNumber, @RequestParam("txtAmount") int amount) {
		SavingsAccount sender = savingsAccountService.getAccountById(senderAccountNumber);
		SavingsAccount receiver = savingsAccountService.getAccountById(receiverAccountNumber);
		savingsAccountService.fundTransfer(sender, receiver, amount);
		return "redirect:getAll";
	}

	@RequestMapping(value = "/currentBalance", method = RequestMethod.GET)
	public String currentBalance() {
		return "CurrentBalance";
	}

	@RequestMapping(value = "/currentBalance", method = RequestMethod.POST)
	public String currentBalance(@RequestParam("txtAccountNumber") int accountNumber, Model model) {
		SavingsAccount account = savingsAccountService.getAccountById(accountNumber);
		model.addAttribute("account", account);
		return "balance";
	}

}
