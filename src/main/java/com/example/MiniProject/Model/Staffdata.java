package com.example.MiniProject.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Staffdata {
	
	@Id
	private int userid;
	private String type;
	private String bookid;
	private String bookname;
	private LocalDate issuedate;
	private LocalDate returndate;
	
	
	public Staffdata() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Staffdata(int uid, String type, String bookid, String bookname, LocalDate issuedate,
			LocalDate returndate) {
		this.userid = uid;
		this.type = type;
		this.bookid = bookid;
		this.bookname = bookname;
		this.issuedate = issuedate;
		this.returndate = returndate;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getBookid() {
		return bookid;
	}


	public void setBookid(String bookid) {
		this.bookid = bookid;
	}


	public String getBookname() {
		return bookname;
	}


	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	public LocalDate getIssuedate() {
		return issuedate;
	}


	public void setIssuedate(LocalDate issuedate) {
		this.issuedate = issuedate;
	}


	public LocalDate getReturndate() {
		return returndate;
	}


	public void setReturndate(LocalDate returndate) {
		this.returndate = returndate;
	}


	@Override
	public String toString() {
		return "Staffdata [userid=" + userid + ", type=" + type + ", bookid=" + bookid + ", bookname=" + bookname
				+ ", issuedate=" + issuedate + ", returndate=" + returndate + "]";
	}
	
	
	
	
	
}
