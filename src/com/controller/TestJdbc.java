package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.connectivity.JdbcCon;

public class TestJdbc {
	public void savedata() throws ClassNotFoundException, SQLException {
		Connection Con = JdbcCon.getCon();
		Statement s = Con.createStatement();
		int h=   s.executeUpdate("Insert into apple9.Person (page,pname,qual) values (35,'NagaSaiAnusha','TTE')");
		System.out.println("No of Rows Inserted --->"+h);
		
	}
	public void getbyid(int pid) throws ClassNotFoundException, SQLException {
		Connection Con = JdbcCon.getCon();
		PreparedStatement ps =  Con.prepareStatement("select * from  apple9.Person where pid =?");
		ps.setInt(1, pid);
		ResultSet r =  ps.executeQuery();
		while(r.next()) {
			System.out.println(r.getInt("pid"));
			System.out.println(r.getInt("page"));
			System.out.println(r.getString("pname"));
			System.out.println(r.getString("qual"));
		}
		r.close();
		ps.close();
		Con.close();
	}
	public void getAll() throws ClassNotFoundException, SQLException {
		Connection Con = JdbcCon.getCon();
		PreparedStatement ps =  Con.prepareStatement("select * from  apple9.Person ");
		ResultSet r =  ps.executeQuery();
		
		while(r.next()) {
			System.out.println(r.getInt("pid"));
			System.out.println(r.getInt("page"));
			System.out.println(r.getString("pname"));
			System.out.println(r.getString("qual"));
			System.out.println("--------------------------------");
		}
		r.close();
		ps.close();
		Con.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TestJdbc T = new TestJdbc();
//		T.savedata();
//		T.getbyid(5);
		T.getAll();
	}
}
