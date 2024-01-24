package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import com.connectivity.JdbcCon;

public class OneToOneJdbc {
	
	
	public static Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apple10", "root", "root");
		return Con;
	}
	public static int insertPerson(Connection Con,int page,String pname,String qual) throws ClassNotFoundException, SQLException {
		Connection C = OneToOneJdbc.getCon();
		String inserPersonSQL = "insert into apple9.Person (page,pname,qual) values (?,?,?)";
		PreparedStatement ps =  C.prepareStatement(inserPersonSQL,PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setInt(1, page);
		ps.setString(2, pname);
		ps.setString(3, qual);
		int RowsAffected = ps.executeUpdate();
		if(RowsAffected >=0) {
			java.sql.ResultSet GK = ps.getGeneratedKeys();
			if(GK.next()) {
				return GK.getInt(1);
			}else {
				throw new SQLException("Failed To Retrive the Person Id");
			}
		}else{
			throw new SQLException("Failed To Insert the Person Details");
		}
		
		
	}
	public static void insertPassport(Connection Con,String pexpdate,String pnum,int fkpid) throws ClassNotFoundException, SQLException {
		Connection C = OneToOneJdbc.getCon();
		String insertPassportSQL = "insert into apple9.Passport (pexpdate,pnum,fkpid) values (?,?,?)";
		PreparedStatement ps =  C.prepareStatement(insertPassportSQL,PreparedStatement.RETURN_GENERATED_KEYS);
	
		ps.setString(1, pexpdate);
		ps.setString(2, pnum);
		ps.setInt(3, fkpid);
		int RowsAffected = ps.executeUpdate();
		if(RowsAffected >=0) {
			throw new SQLException("Failed To Insert the Passport Details");
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection Con = OneToOneJdbc.getCon();
		int Personid = OneToOneJdbc.insertPerson(Con, 40, "Hitasvi", "Inter");
		OneToOneJdbc.insertPassport(Con, "abcd9876", "3000", Personid);
		System.out.println("Data Inserted Successfully");
	}
}
