package dbUilt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUilt {
		public static final String DRIVER="com.mysql.jdbc.Driver";
		public static final String URL = "jdbc:mysql://127.0.0.1:3306/demo1203";
		public static final String NAME = "root";
		public static final String PASSWORD = "1234";
		static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//获取连接对象
		public static Connection getConnection(){
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(URL, NAME, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
		}
		//关闭资源
		public static void close(Connection connection,Statement statement,ResultSet set){
			if(set != null){
			try {
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
			if(connection != null){
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement != null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
}
