package com.example.MiniProject.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.MiniProject.Bo.BookdataBo;
import com.example.MiniProject.Bo.LibraryBo;
import com.example.MiniProject.Model.Bookdata;
import com.example.MiniProject.Model.Userdata;


@org.springframework.stereotype.Service
public class Service {

	@Autowired
	LibraryBo ld;
	@Autowired
	BookdataBo bd;
	//@Autowired
//	Bookdata b;
	
	public Userdata verifyuser(Userdata u) {
		return ld.save(u);
	}
	
	public Bookdata addbook(String bookid, String bookname, String bookauthor, String bookpublisher, String ncopy,
			LocalDate byear) {
		
		Bookdata b = new Bookdata();
	/*	String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		*/
		b.setBookid(bookid);
		b.setBookname(bookname);
		b.setBookauthor(bookauthor);
		b.setBookpublisher(bookpublisher);
		b.setNcopy(ncopy);
		b.setPublication(byear);
	
		/*try {
			b.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return bd.save(b);
		
	}
	
}
