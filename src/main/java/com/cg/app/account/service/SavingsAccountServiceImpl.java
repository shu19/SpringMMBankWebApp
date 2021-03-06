package com.cg.app.account.service;

import java.util.List;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.app.account.SavingsAccount;
import com.cg.app.account.dao.SavingsAccountDAO;
import com.cg.app.account.factory.AccountFactory;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService {

	private AccountFactory factory;
	@Autowired
	private SavingsAccountDAO savingsAccountDAO;

	public SavingsAccountServiceImpl() {
		factory = AccountFactory.getInstance();
	}

	@Override
	public SavingsAccount createNewAccount(String accountHolderName, double accountBalance, boolean salary) {
		SavingsAccount account = factory.createNewSavingsAccount(accountHolderName, accountBalance, salary);
		savingsAccountDAO.createNewAccount(account);
		return account;
	}

	@Override
	public List<SavingsAccount> getAllSavingsAccount() {
		return savingsAccountDAO.getAllSavingsAccount();
	}

	@Override
	public void deposit(SavingsAccount account, double amount) {
		savingsAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(),
				account.getBankAccount().getAccountBalance() + amount);
	}

	@Override
	public void withdraw(SavingsAccount account, double amount) {
		savingsAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(),
				account.getBankAccount().getAccountBalance() - amount);
	}

	@Transactional
	@Override
	public void fundTransfer(SavingsAccount sender, SavingsAccount receiver, double amount) {
		

		((SavingsAccountService) AopContext.currentProxy()).withdraw(sender, amount);
		((SavingsAccountService) AopContext.currentProxy()).deposit(receiver, amount);

	}

	@Override
	public SavingsAccount getAccountById(int accountNumber) {
		return savingsAccountDAO.getAccountById(accountNumber);
	}

	@Override
	public boolean deleteAccount(int accountNumber) {

		return savingsAccountDAO.deleteAccount(accountNumber);
	}

	@Override
	public List<SavingsAccount> getSortedAccounts(int choice) {
		return savingsAccountDAO.getSortedAccounts(choice);
	}

	@Override
	public int updateAccount(int accountnumber, String newAccountHolderName) {

		return savingsAccountDAO.updateAccount(accountnumber, newAccountHolderName);
	}

	@Override
	public double checkAccountBalance(int accountnumber) {

		return savingsAccountDAO.getAccountBalance(accountnumber);
	}

	@Override
	public SavingsAccount getAccountByHolderName(String accountHolderName) {

		return savingsAccountDAO.getAccountByHolderName(accountHolderName);
	}

	@Override
	public List<SavingsAccount> getAllSavingsAccountInBalanceRange(double minimumAccountBalance,
			double maximumAccountBalance) {

		return savingsAccountDAO.getAllSavingsAccountInBalanceRange(minimumAccountBalance, maximumAccountBalance);
	}

	@Override
	public SavingsAccount updateAccount(SavingsAccount savingsAccount) {

		return savingsAccountDAO.updateAccount(savingsAccount);
	}

}
