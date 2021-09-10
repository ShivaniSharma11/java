package com.example.MiniProject.Controller;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.MiniProject.Bo.BookdataBo;
import com.example.MiniProject.Bo.LibraryBo;
import com.example.MiniProject.Bo.SessionBo;
import com.example.MiniProject.Bo.StaffdataBo;
import com.example.MiniProject.Connection.DbConnection;
import com.example.MiniProject.Model.Bookdata;
import com.example.MiniProject.Model.Staffdata;
import com.example.MiniProject.Model.Userdata;
import com.example.MiniProject.Service.Service;

import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class Controller {
	
	@Autowired
	LibraryBo lb;
	
	@Autowired
	BookdataBo bb;
	
	@Autowired
	SessionBo ub;
	
	@Autowired
	Service us;
	
	@Autowired
	StaffdataBo sd;
	
	
// ------------------------ USERDATA TABLE ----------------------------------
	
//Index Page	
//	value="login", method = RequestMethod.POST
	@RequestMapping("/index")
	public ModelAndView Mainpage(HttpServletRequest request) {
		System.out.println("Index Page");
		return new ModelAndView("index");
	}
	
//Register	
	@RequestMapping("/register")
	public ModelAndView register() {
		System.out.println("registration Page");
		return new ModelAndView("registration");
		
	}
	
	// Confirm the user
	@RequestMapping(value="validateuser",method = RequestMethod.POST)
	public ModelAndView verifyuser(HttpServletRequest request, Model model) throws SQLException{
		

		Connection con = DbConnection.getConnection();
		Statement s = con.createStatement();
		
		ModelAndView mv = null;
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		
		Userdata u=ub.checkUserbyEmail(email);
		System.out.println("User is null"+u);
		
		
		if(u.equals(null)) {
			model.addAttribute("msg", "Your User Name is Wrong");
			mv=new ModelAndView("login");
		}
		else if(u.getEmail().equals("admin@gmail.com")) {
	   	  if(u.getPassword().equals("Adminroot@1")){
	   		  System.out.println("admin page");
	   		  return new ModelAndView("Admin");
	   	  }else {
	   		  return new ModelAndView("index");
	   	  }
	     }
		else if(u.getEmail().equals(email)) {
			if(password.equals(u.getPassword())) {
				
				model.addAttribute("name", u.getName());
				model.addAttribute("email", u.getEmail());
				model.addAttribute("id",u.getId());
				int id = u.getId();
				
				System.out.println("started fetching");
				
				ResultSet rs = s.executeQuery ("select count(*) as totalbooks from staffdata where userid ="+id+"");
				while(rs.next()) {
					String total = rs.getString(1);
					System.out.println(total);
					model.addAttribute("Totalbooks",total);
		
				   ModelAndView m=new ModelAndView("MainPage");
							List<Bookdata> ud=bb.findAll();
							model.addAttribute("List", ud);
							mv=new ModelAndView("MainPage");
							return m;
							
				}
				/*
	//----------------------------
				// ModelAndView m=new ModelAndView("MainPage");
				ResultSet rs1 = s.executeQuery ("select * from staffdata where userid ="+id+"");
				while(rs1.next()) {
				//	String id = rs.getString(1);
			//		model.addAttribute("bookid",rs1.getString(2));
			//		model.addAttribute("bookname",rs1.getString(3));
			//		model.addAttribute("returndate",rs1.getString(5));
					//return m;
					List<Staffdata> s1=sd.findAllById(u.getId());
					model.addAttribute("List", s1);
					
					
				}
					*/					
	//-------------------------------------
							
				
			}
			else {
				model.addAttribute("msg", "Enter Valid Details");
				mv=new ModelAndView("index");
			}
		}
		else {
			model.addAttribute("msg", "Enter Valid Details");
			mv=new ModelAndView("index");
		}
		return mv;
	}

	
	
	
// Insert Data in Register page and redirect to the Inpage after successfull data insertion
	
	@RequestMapping(value ="insertdata" , method = RequestMethod.POST)
	public ModelAndView insertdatatodatabase(Model model,HttpServletRequest request) {
		
		System.out.println("Started");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String utype = request.getParameter("uutype");
		int userid = Integer.parseInt(request.getParameter("id"));
		String upassword = request.getParameter("password");
		
		System.out.println("started insert");
		
		
		Userdata u=new Userdata(email,userid,uname,upassword,utype);
		System.out.println(u);
		boolean b=ub.insertUser(u);
		if(b==false) {
			model.addAttribute("msg", "Successfully Inserted.. ");
			return new ModelAndView("Inpage");
		}else {
			return new ModelAndView("index");
		}
	}


	@RequestMapping("/addbooks")
	public ModelAndView books() {
		System.out.println("BookPage");
		return new ModelAndView("addbooks");
		
	}

// Add book details in booksdata table
	@RequestMapping(value = "addbooks" , method = RequestMethod.POST)
	public ModelAndView booksadded(HttpServletRequest request, Model model) {
		System.out.println("Started book");
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String bauthor = request.getParameter("bauthor");
		String bpublisher = request.getParameter("bpublisher");
		LocalDate byear=LocalDate.parse(request.getParameter("year_of_publication"));
		String bcopies = request.getParameter("num_of_copies");
		//String bimage = request.getParameter("imagefile");
		
		System.out.println("started inserted");
		Bookdata b=new Bookdata(bid,bname,bauthor,bpublisher,bcopies,byear);
		System.out.println(b);
		boolean book=ub.insertBook1(b);
		if(book==false) {
			model.addAttribute("msg", "Successfully Inserted.. ");
			return new ModelAndView("Inpage");
		}else {
			return new ModelAndView("index");
		}
			
	}
	/*
	@RequestMapping(value = "addbooks" , method = RequestMethod.POST)
	public ModelAndView addbooks(
    		//@RequestParam("bid") String bid,
    	//	@RequestParam("bname") String bname,
    	//	@RequestParam("bauthor") String bauthor,
    	//	@RequestParam("bpublisher") String bpublisher,
    	//	@RequestParam("year_of_publication") String byear,
    	//	@RequestParam("num_of_copies") String bcopies,
    		//@RequestParam("file") MultipartFile file,
			HttpServletRequest request, Model model){
		System.out.println("Started book");
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String bauthor = request.getParameter("bauthor");
		String bpublisher = request.getParameter("bpublisher");
		LocalDate byear=LocalDate.parse(request.getParameter("year_of_publication"));
		String bcopies = request.getParameter("num_of_copies");
	 
		
		Bookdata us=new Bookdata(bid,bname,bauthor,bpublisher,bcopies,byear);
		System.out.println(us);
		
	//	boolean b=ub.savebook(bid,bname,bauthor,bpublisher,bcopies,byear);
		if(b==false) {
			model.addAttribute("msg", "Successfully Inserted.. ");
			return new ModelAndView("Inpage");
		}else {
			return new ModelAndView("index");
		}
		//Userdata u=new Userdata(email,userid,uname,upassword,utype);
		// 	us.saveUser(bid,bname,bauthor,bpublisher,bcopies,byear,file);
		 	//return new ModelAndView("index");
    }
	*/
//--------------------------------ADMIN PAGE ------------------------------------- 	
	 //------------------- BOOKDATA Table -------------------------------------

// Show the registered users
@RequestMapping("/viewusers")
public ModelAndView showcredentials(Model model) {
	ModelAndView mv=new ModelAndView("showdata");
	List<Userdata> li=lb.findAll();
	model.addAttribute("list", li);
	return mv;
	
}
	
@RequestMapping("/showbooks")
public ModelAndView showbooks(Model model) {
	ModelAndView mv=new ModelAndView("showbooks");
	List<Bookdata> l=bb.findAll();
	model.addAttribute("List", l);
	return mv;
	
}


@RequestMapping("/delete")
public ModelAndView delete() {
	System.out.println("delete Page");
	return new ModelAndView("delete");
	
}

@RequestMapping(value ="deletebook" , method = RequestMethod.POST)
public ModelAndView deletebook(Model model,HttpServletRequest request) throws SQLException {
	
	
	System.out.println("Started");
	String bid = request.getParameter("bid");
	
	Connection con = DbConnection.getConnection();

	Statement s = con.createStatement();
	System.out.println("started deleting");
	
	ResultSet rs = s.executeQuery ("select * from bookdata");
	
    while (rs.next ())
    { 
    	System.out.print("executed");
    	String dbid =  rs.getString(1);
    	System.out.print("executed 2");
        //System.out.println ("userid:  " + rs.getInt (1));
        System.out.println ("n:" + rs.getString (1)); 
  
    		if(bid.equals(dbid)) {
    		boolean b = s.execute("delete from bookdata where bookid= "+bid+" ");
    		System.out.print("Successfully executed");
			return new ModelAndView("Inpage");
    		}
    		
    			model.addAttribute("msg", " Invalid BID");
				  return new ModelAndView("delete");
    }
    //return mv;
	return null;
}


// ----------------------------- STAFFDATA TABLE ------------------------\
// ----------------1. 

@RequestMapping("/issuebook")
public ModelAndView issue() {
	System.out.println("Issue page");
	return new ModelAndView("Issuebook");
}

@RequestMapping(value ="issuebook" , method = RequestMethod.POST)
public ModelAndView issuebook(HttpServletRequest request, Model model ) {

//Connection con = DbConnection.getConnection();
	//Statement s = con.createStatement();
	
//	model.addAttribute("Email");
	System.out.println("Started book");
	int uid = Integer.parseInt(request.getParameter("uid"));
	String type = request.getParameter("type");
	String bid = request.getParameter("bid");
	String bname = request.getParameter("bname");
	LocalDate issuedate=LocalDate.parse(request.getParameter("date"));
	LocalDate returndate=LocalDate.parse(request.getParameter("newdate"));
	
	System.out.println("started inserted");
	Staffdata sd=new Staffdata(uid,type,bid,bname, issuedate,returndate);
	System.out.println(sd);
	boolean book=ub.insertIssuedata(sd);
	if(book==false) {
		model.addAttribute("msg", "Successfully Inserted.. ");
		return new ModelAndView("Inpage");
	}else {
		return new ModelAndView("index");
	}
	/*	
	ResultSet rs = s.executeQuery ("select count(*) as totalbooks from staffdata where userid ="+id+"");
	while(rs.next()) {
		String total = rs.getString(1);
		System.out.println(total);
		model.addAttribute("Totalbooks",total);

	   ModelAndView m=new ModelAndView("MainPage");
				List<Bookdata> ud=bb.findAll();
				model.addAttribute("List", ud);
				mv=new ModelAndView("MainPage");
				return m;
	  
	} */
	
}

@RequestMapping("/returnbook")
public ModelAndView returnbook() {
	System.out.println("return page");
	return new ModelAndView("returnbook");
}

@RequestMapping(value ="returnbook" , method = RequestMethod.POST)
public ModelAndView returnbook(Model model,HttpServletRequest request) throws SQLException {
	
	System.out.println("Started");
	String uid = request.getParameter("uid");
	//String bid = request.getParameter("bid");
	String bname = request.getParameter("bname");
	
	Connection con = DbConnection.getConnection();

	Statement s = con.createStatement();
	System.out.println("started deleting");
	
	ResultSet rs = s.executeQuery ("select * from staffdata");
	
    while (rs.next ())
    { 
    	String duid =  rs.getString(1);
    //	String dbid =  rs.getString(3);
    	String dbname =rs.getString(3);
        //System.out.println ("userid:  " + rs.getInt (1));
        System.out.println ("n:" + rs.getString (1)); 
        System.out.println ("n:" + rs.getString (3)); 
    	System.out.println("started deleting 2");
    	
    	if(bname.equals(dbname)) {
    		System.out.println("started deleting ma");
    		if(uid.equals(duid)) {
    			System.out.println("started deleting pass");
    			
    			boolean b = s.execute("delete from staffdata where userid= "+uid+" and bookname = '"+bname+"'");
    			
    			System.out.print("Successfully executed");		
    			return new ModelAndView("Inpage");
    					}
    		model.addAttribute("msg", " Invalid UID");
  		  return new ModelAndView("returnbook");
    		}}
    	 model.addAttribute("msg", " Invalid UID");
   	  return new ModelAndView("returnbook");
    	}

}

//--------------------------- Available books------------------
//select count(*) as totalbooks from staffdata where userid =234509;
	/*
@RequestMapping (value = "/username", method = RequestMethod.GET)
@ResponseBody
public String name(Authentication authentication) {
	return authentication.name();
}
*/






	
	
	
	



