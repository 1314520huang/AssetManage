package com.asset.manage.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {

	private final static String username = "root";
	private final static String password = "0337@ch";
	private final static String url = "jdbc:mysql://localhost:3306/salary?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
	private final static String driver = "com.mysql.cj.jdbc.Driver";
	private static Connection conn;
	private final static String sql = " select user_id, user_name, count(*) as sum from sign GROUP BY user_id, user_name ";

	static {
		if (conn == null) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Map<String, String>> getSign() throws Exception {

		PreparedStatement prep = conn.prepareStatement(sql);
		ResultSet rs = prep.executeQuery();
		List<Map<String, String>> datas = new ArrayList<>();
		while (rs.next()) {
			Map<String, String> data = new HashMap<>();
			data.put("userId", rs.getString("user_id"));
			data.put("userName", rs.getString("user_name"));
			data.put("sum", rs.getString("sum"));
			datas.add(data);
		}
		return datas;
	}
}
