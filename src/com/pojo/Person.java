package com.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Person {
	@Id
	@GeneratedValue
	private int pid;
	private String pname;
	private int page;
	private String qual;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkpid")
	private Passport pass;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "mkpid")
	private List<Mobile> mobi;
	
	public Person() {
		
	}

	public Person(int pid, String pname, int page, String qual, Passport pass, List<Mobile> mobi) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.page = page;
		this.qual = qual;
		this.pass = pass;
		this.mobi = mobi;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getQual() {
		return qual;
	}

	public void setQual(String qual) {
		this.qual = qual;
	}

	public Passport getPass() {
		return pass;
	}

	public void setPass(Passport pass) {
		this.pass = pass;
	}

	public List<Mobile> getMobi() {
		return mobi;
	}

	public void setMobi(List<Mobile> mobi) {
		this.mobi = mobi;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", page=" + page + ", qual=" + qual + ", pass=" + pass
				+ ", mobi=" + mobi + "]";
	}
	
	}
