package com.cg.app;

import org.junit.Test;

import com.cg.app.account.service.SavingsAccountService;
import com.cg.app.account.service.SavingsAccountServiceImpl;

public class AccountTransactionsTest {

	@Test
	public void deposit() {
		
		SavingsAccountService savingsAccountService=new SavingsAccountServiceImpl();
		
//		savingsAccountService.deposit(account, amount);
	}
	
	@Test
	public void depositNegativeAmount() {
		SavingsAccountService savingsAccountService=new SavingsAccountServiceImpl();
		
//		savingsAccountService.deposit(account, amount);
	}
	
	
	
	
	@Test
	public void withdraw() {
		SavingsAccountService savingsAccountService=new SavingsAccountServiceImpl();
		
//		savingsAccountService.deposit(account, amount);
	}
	
	@Test
	public void withdrawNegativeAmount() {
		SavingsAccountService savingsAccountService=new SavingsAccountServiceImpl();
		
//		savingsAccountService.deposit(account, amount);
	}
	
	
	@Test
	public void withdrawAmountGreaterThanBalance() {
		SavingsAccountService savingsAccountService=new SavingsAccountServiceImpl();
		
//		savingsAccountService.deposit(account, amount);
	}
	
	@Test
	public void withdrawAmountLessThanBalance() {
		SavingsAccountService savingsAccountService=new SavingsAccountServiceImpl();
		
//		savingsAccountService.deposit(account, amount);
	}
	
	
}
