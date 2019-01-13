package com.cg.app.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.account.CurrentAccount;
import com.cg.app.account.dao.CurrentAccountDAO;
import com.cg.app.account.factory.AccountFactory;
import com.cg.app.exception.InsufficientFundsException;
import com.cg.app.exception.InvalidInputException;

@Service
public class CurrentAccountServiceImpl implements CurrentAccountService {

	private AccountFactory factory;

	@Autowired
	private CurrentAccountDAO currentAccountDAO;

	public CurrentAccountServiceImpl() {
		factory = AccountFactory.getInstance();
	}

	@Override
	public CurrentAccount createNewAccount(String accountHolderName, double accountBalance, double odLimit) {
		CurrentAccount account = factory.createNewCurrentAccount(accountHolderName, accountBalance, odLimit);
		currentAccountDAO.createNewAccount(account);
		return null;
	}

	@Override
	public List<CurrentAccount> getAllCurrentAccount() {
		return currentAccountDAO.getAllCurrentAccount();
	}

	@Override
	public void deposit(CurrentAccount account, double amount) {
		if (amount > 0) {
			double currentBalance = account.getBankAccount().getAccountBalance();
			currentBalance += amount;
			currentAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(), currentBalance);
			// savingsAccountDAO.commit();
		} else {
			throw new InvalidInputException("Invalid Input Amount!");
		}
	}

	@Override
	public void withdraw(CurrentAccount account, double amount) {
		double currentBalance = account.getBankAccount().getAccountBalance() + account.getOdLimit();
		if (amount > 0 && currentBalance >= amount) {
			currentBalance -= amount;
			currentAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(), currentBalance);
			// savingsAccountDAO.commit();
		} else {
			throw new InsufficientFundsException("Invalid Input or Insufficient Funds!");
		}
	}

	@Override
	public void fundTransfer(CurrentAccount sender, CurrentAccount receiver, double amount) {
			withdraw(sender, amount);
			deposit(receiver, amount);
	}

	@Override
	public CurrentAccount getAccountById(int accountNumber) {
		return currentAccountDAO.getAccountById(accountNumber);
	}

	@Override
	public boolean deleteAccount(int accountNumber) {

		return currentAccountDAO.deleteAccount(accountNumber);
	}

	@Override
	public List<CurrentAccount> getSortedAccounts(int choice) {
		return currentAccountDAO.getSortedAccounts(choice);
	}

	@Override
	public int updateAccount(int accountnumber, String newAccountHolderName) {

		return currentAccountDAO.updateAccount(accountnumber, newAccountHolderName);
	}

	@Override
	public double checkAccountBalance(int accountnumber) {

		return currentAccountDAO.getAccountBalance(accountnumber);
	}

	@Override
	public CurrentAccount getAccountByHolderName(String accountHolderName) {

		return currentAccountDAO.getAccountByHolderName(accountHolderName);
	}

	@Override
	public List<CurrentAccount> getAllCurrentAccountInBalanceRange(double minimumAccountBalance,
			double maximumAccountBalance) {

		return currentAccountDAO.getAllCurrentAccountInBalanceRange(minimumAccountBalance, maximumAccountBalance);
	}

}
