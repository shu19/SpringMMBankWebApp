package com.cg.app.account.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.app.account.CurrentAccount;
import com.cg.app.account.dao.mapper.CurrentAccountMapper;

@Primary
@Repository
public class CurrentAccountSJDAOImpl implements CurrentAccountDAO {

	Logger logger = Logger.getLogger(CurrentAccountSJDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public CurrentAccount createNewAccount(CurrentAccount account) {
		String query = "INSERT INTO ACCOUNT (account_hn,account_bal,odLimit,type) VALUES(?,?,?,?)";
		jdbcTemplate.update(query, new Object[] { account.getBankAccount().getAccountHolderName(),
				account.getBankAccount().getAccountBalance(), account.getOdLimit(), "CA" });
		logger.debug("Current Account created Successfully!!!");
		return account;
	}

	@Override
	public CurrentAccount getAccountById(int accountNumber) {

		String query = "SELECT * FROM account where account_id=? AND TYPE='CA'";

		return jdbcTemplate.queryForObject(query, new Object[] { accountNumber }, new CurrentAccountMapper());
	}

	@Override
	public boolean deleteAccount(int accountNumber) {

		String query = "DELETE FROM ACCOUNT WHERE account_id=? AND TYPE='CA'";
		jdbcTemplate.update(query, new Object[] { accountNumber });

		return false;
	}

	@Override
	public List<CurrentAccount> getAllCurrentAccount() {
		String query = "SELECT * FROM ACCOUNT WHERE TYPE='CA'";

		return jdbcTemplate.query(query, new CurrentAccountMapper());
	}

	@Override
	public void updateBalance(int accountNumber, double currentBalance) {
		String query = "UPDATE ACCOUNT SET account_bal=? where account_id=? AND TYPE='CA'";
		jdbcTemplate.update(query, new Object[] { currentBalance, accountNumber });
	}

	@Override
	public List<CurrentAccount> getSortedAccounts(int choice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAccount(int accountnumber, String newAccountHolderName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAccountBalance(int accountnumber) {

		String query = "SELECT account_bal FROM ACCOUNT WHERE account_id=? AND TYPE='CA'";
		
		return jdbcTemplate.queryForObject(query, new Object[] {
				accountnumber
		},Double.class);
	}

	@Override
	public CurrentAccount getAccountByHolderName(String accountHolderName) {

		String query = "SELECT * FROM ACCOUNT WHERE account_hn LIKE ? AND TYPE='CA'";
		return jdbcTemplate.queryForObject(query, new Object[] {
				accountHolderName
		},new CurrentAccountMapper());
	}

	@Override
	public List<CurrentAccount> getAllCurrentAccountInBalanceRange(double minimumAccountBalance,
			double maximumAccountBalance) {

		String query = "SELECT * FROM ACCOUNT WHERE account_bal >= ? AND account_bal <= ? AND TYPE='CA'";
		return jdbcTemplate.query(query, new Object[] {
				minimumAccountBalance,maximumAccountBalance
		},new CurrentAccountMapper());
	}

}
