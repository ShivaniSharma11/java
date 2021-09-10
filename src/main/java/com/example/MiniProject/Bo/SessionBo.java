package com.example.MiniProject.Bo;



import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.MiniProject.Model.Bookdata;
import com.example.MiniProject.Model.Staffdata;
import com.example.MiniProject.Model.Userdata;

@Repository
public class SessionBo {

	@Autowired
	SessionFactory sf;
	
	public boolean insertUser(Userdata u) {
		System.out.println("Inside USER BO--Beginning");
	    Session s=sf.openSession();
	    s.beginTransaction();
	  
	    s.save(u);
	    s.getTransaction().commit();
	    s.close();
		System.out.println("Inside USER BO--END");
		return false;
	}
	
	public Userdata checkUserbyEmail(String email) {
		System.out.println("Inside USER BO--Beginning");
		//User u=null;
		Session s=sf.openSession();
		s.beginTransaction();
		Userdata u1=(Userdata) s.load(Userdata.class,email);
		s.getTransaction().commit();
		System.out.println("Inside USER BO--END");
		return u1;
	}
	
	public boolean updateUser(Userdata u) {
		Session s=sf.openSession();
	    s.beginTransaction();
	   // s.merge(u);
	    s.saveOrUpdate(u);
	   
	    s.getTransaction().commit();
	    s.close();
	    return true;
	}

	public boolean insertBook1(Bookdata b) {
		// TODO Auto-generated method stub
		System.out.println("Inside USER BO--Beginning");
	    Session s=sf.openSession();
	    s.beginTransaction();
	    s.save(b);
	    s.getTransaction().commit();
	    s.close();
		System.out.println("Inside USER BO--END");
		return false;
		
	}

	public boolean insertIssuedata(Staffdata b) {
		// TODO Auto-generated method stub
		System.out.println("Inside USER BO--Beginning");
	    Session s=sf.openSession();
	    s.beginTransaction();
	    s.save(b);
	    s.getTransaction().commit();
	    s.close();
		System.out.println("Inside USER BO--END");
		return false;
	}
/*
	public boolean savebook(String bid, String bname, String bauthor, String bpublisher, String bcopies,
			LocalDate byear) {
		// TODO Auto-generated method stub
		System.out.println("Inside USER BO--Beginning");
	    Session s=sf.openSession();
	    s.beginTransaction();
	    s.save(s);
	    s.getTransaction().commit();
	    s.close();
		System.out.println("Inside USER BO--END");
		return false;
	}

*/
/*
	public boolean savebook(String bid, String bname, String bauthor, String bpublisher, String bcopies,
			LocalDate byear,MultipartFile file) { 
		// TODO Auto-generated method stub
		System.out.println("Inside USER BO--Beginning");
	    Session s=sf.openSession();
	    s.beginTransaction();
	    s.save(s);
	    s.getTransaction().commit();
	    s.close();
		System.out.println("Inside USER BO--END");
		return false;
	}

	*/
}
