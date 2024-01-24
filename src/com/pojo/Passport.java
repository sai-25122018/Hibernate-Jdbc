package com.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passport {
	@Id
	@GeneratedValue
	private int ppid;
	private String pnum;
	private String pexpdate;
	
	public Passport() {
		
	}

	public Passport(int ppid, String pnum, String pexpdate) {
		super();
		this.ppid = ppid;
		this.pnum = pnum;
		this.pexpdate = pexpdate;
	}

	public int getPpid() {
		return ppid;
	}

	public void setPpid(int ppid) {
		this.ppid = ppid;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public String getPexpdate() {
		return pexpdate;
	}

	public void setPexpdate(String pexpdate) {
		this.pexpdate = pexpdate;
	}
	
}
