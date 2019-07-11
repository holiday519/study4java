package com.ee.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HiveJdbcDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.apache.hive.jdbc.HiveDriver");
		Connection conn = DriverManager.getConnection("jdbc:hive2://szq-ops-hdnna-02.cc.kuyun.com:10000/cloud_game", "service", "service");
		String sql = "select sum(dt) from game_log_v1 where i='1003' and action='1' and date='20190519'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) System.out.println(rs.getInt(1));
		rs.close();
		stmt.close();
		conn.close();
	}
}
