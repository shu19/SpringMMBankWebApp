package com.cg.app.account.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cg.app.account.CurrentAccount;

public class CurrentAccountMapper implements RowMapper<CurrentAccount> {

	@Override
	public CurrentAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
		int accountNumber=rs.getInt(1);
		String accountHolderName=rs.getString(2);
		double accountBalance=rs.getDouble(3);
		double odLimit=rs.getDouble(5);
		return new CurrentAccount(accountNumber, accountHolderName, accountBalance, odLimit);
	}

}
