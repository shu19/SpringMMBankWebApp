package com.cg.app.account.dao;

import java.util.List;

import com.cg.app.account.SavingsAccount;

public interface SavingsAccountDAO {

	SavingsAccount createNewAccount(SavingsAccount account);

	SavingsAccount getAccountById(int accountNumber);

	boolean deleteAccount(int accountNumber);

	List<SavingsAccount> getAllSavingsAccount();

	void updateBalance(int accountNumber, double currentBalance);

	List<SavingsAccount> getSortedAccounts(int choice);

	int updateAccount(int accountnumber, String newAccountHolderName);

	double getAccountBalance(int accountnumber);

	SavingsAccount getAccountByHolderName(String accountHolderName);

	List<SavingsAccount> getAllSavingsAccountInBalanceRange(double minimumAccountBalance, double maximumAccountBalance);

	SavingsAccount updateAccount(SavingsAccount savingsAccount);

}
