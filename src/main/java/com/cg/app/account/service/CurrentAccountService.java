package com.cg.app.account.service;

import java.util.List;

import com.cg.app.account.CurrentAccount;

public interface CurrentAccountService {

	CurrentAccount createNewAccount(String accountHolderName, double accountBalance, double odLimit);

	CurrentAccount getAccountById(int accountNumber);

	boolean deleteAccount(int accountNumber);

	List<CurrentAccount> getAllCurrentAccount();

	void fundTransfer(CurrentAccount sender, CurrentAccount receiver, double amount);

	void deposit(CurrentAccount account, double amount);

	void withdraw(CurrentAccount account, double amount);

	List<CurrentAccount> getSortedAccounts(int sortBy);

	int updateAccount(int accountnumber, String newAccountHolderName);

	double checkAccountBalance(int accountnumber);

	CurrentAccount getAccountByHolderName(String accountHolderName);

	List<CurrentAccount> getAllCurrentAccountInBalanceRange(double minimumAccountBalance, double maximumAccountBalance);

}
