package com.cg.app.account.service;

import java.sql.SQLException;
import java.util.List;

import com.cg.app.account.SavingsAccount;
import com.cg.app.exception.AccountNotFoundException;

public interface SavingsAccountService {

	SavingsAccount createNewAccount(String accountHolderName, double accountBalance, boolean salary) ;

//	SavingsAccount updateAccount(SavingsAccount account);

	SavingsAccount getAccountById(int accountNumber);

	boolean deleteAccount(int accountNumber) ;
	
	List<SavingsAccount> getAllSavingsAccount() ;

	void fundTransfer(SavingsAccount sender, SavingsAccount receiver, double amount);
	void deposit(SavingsAccount account, double amount);
	void withdraw(SavingsAccount account, double amount);

	
	List<SavingsAccount> getSortedAccounts(int sortBy) ;

	int updateAccount(int accountnumber, String newAccountHolderName);
	SavingsAccount updateAccount(SavingsAccount savingsAccount) ;

	double checkAccountBalance(int accountnumber) ;

	SavingsAccount getAccountByHolderName(String accountHolderName) ;

	List<SavingsAccount> getAllSavingsAccountInBalanceRange(
			double minimumAccountBalance, double maximumAccountBalance);
	
}











