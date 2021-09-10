package com.example.MiniProject.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Bookdata {

	@Id
	//@Lob
	//@GeneratedValue(strategy =GenerationType.IDENTITY)
	private String bookid;
	private String bookname;
	private String bookauthor;
	private String bookpublisher;	
	private String ncopy;
	private LocalDate publication;
//	@Column(columnDefinition = "MEDIUMBLOB")
	//private String image;
	
	


	public String getBookid() {
		return bookid;
	}







	public Bookdata() {
		super();
		// TODO Auto-generated constructor stub
	}







	public Bookdata(String bookid, String bookname, String bookauthor, String bookpublisher, String ncopy,
			LocalDate publication) {
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookauthor = bookauthor;
		this.bookpublisher = bookpublisher;
		this.ncopy = ncopy;
		this.publication = publication;
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







	public String getBookauthor() {
		return bookauthor;
	}







	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}







	public String getBookpublisher() {
		return bookpublisher;
	}







	public void setBookpublisher(String bookpublisher) {
		this.bookpublisher = bookpublisher;
	}







	public String getNcopy() {
		return ncopy;
	}







	public void setNcopy(String ncopy) {
		this.ncopy = ncopy;
	}







	public LocalDate getPublication() {
		return publication;
	}







	public void setPublication(LocalDate publication) {
		this.publication = publication;
	}

	
	@Override
	public String toString() {
		return "Bookdata [bookid=" + bookid + ", bookname=" + bookname + ", bookauthor=" + bookauthor
				+ ", bookpublisher=" + bookpublisher + ", ncopy=" + ncopy + ", publication=" + publication + "]";
	}




	

	
}
