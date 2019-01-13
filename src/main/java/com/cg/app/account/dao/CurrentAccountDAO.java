package com.cg.app.account.dao;

import java.util.List;
import com.cg.app.account.CurrentAccount;

public interface CurrentAccountDAO {

	CurrentAccount createNewAccount(CurrentAccount account);

	CurrentAccount getAccountById(int accountNumber);

	boolean deleteAccount(int accountNumber);

	List<CurrentAccount> getAllCurrentAccount();

	void updateBalance(int accountNumber, double currentBalance);

	List<CurrentAccount> getSortedAccounts(int choice);

	int updateAccount(int accountnumber, String newAccountHolderName);

	double getAccountBalance(int accountnumber);

	CurrentAccount getAccountByHolderName(String accountHolderName);

	List<CurrentAccount> getAllCurrentAccountInBalanceRange(double minimumAccountBalance, double maximumAccountBalance);

}
