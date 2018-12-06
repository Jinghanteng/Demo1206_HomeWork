package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUilt.DBUilt;
import model.User;

public class UserDao {
	//����name��ȡ�û���Ϣ
	public User getInfoByName(String name){
		User user=null;
		Connection connection=DBUilt.getConnection();
		String sql="select * from user where name=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				user =new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("password"));
				
				
			}
			DBUilt.close(connection, preparedStatement, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	//����û�
	public static void addUser(String name,String password){
		Connection connection=DBUilt.getConnection();
		String sql="insert into user(name,password) values(?,?)";
		try {
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			preparedStatement.execute();
			DBUilt.close(connection, preparedStatement, null);
			System.out.println("asd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
