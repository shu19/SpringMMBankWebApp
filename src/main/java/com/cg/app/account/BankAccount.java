package com.cg.app.account;

public class BankAccount {
	private int accountNumber;
	private double accountBalance;
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	private String accountHolderName;

	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	public BankAccount(String accountHolderName, double accountBalance) {
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public BankAccount(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public BankAccount(int accountNumber, String accountHolderName, double accountBalance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance
				+ ", accountHolderName=" + accountHolderName + "]";
	}

}
