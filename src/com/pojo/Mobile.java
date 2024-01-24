package com.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mobile {
	@Id
	@GeneratedValue
	private int mid;
	private long mnum;
	private String msim;
	private String mloc;
	
	public Mobile() {
		
	}

	public Mobile(int mid, long mnum, String msim, String mloc) {
		super();
		this.mid = mid;
		this.mnum = mnum;
		this.msim = msim;
		this.mloc = mloc;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public long getMnum() {
		return mnum;
	}

	public void setMnum(long mnum) {
		this.mnum = mnum;
	}

	public String getMsim() {
		return msim;
	}

	public void setMsim(String msim) {
		this.msim = msim;
	}

	public String getMloc() {
		return mloc;
	}

	public void setMloc(String mloc) {
		this.mloc = mloc;
	}
	
	
}
