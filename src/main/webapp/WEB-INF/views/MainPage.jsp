
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" 
	integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
	
	<title>User - Book Checkin</title>
	<style >
		@media(min-width:768px) {
			body {
				margin-top: 50px;
				background-color: orange; 
			}
			/*html, body, #wrapper, #page-wrapper {height: 100%; overflow: hidden;}*/
		}
		#wrapper {
			padding-left: 0;    
		}
		#page-wrapper {
			width: 100%;        
			padding: 0;
			background-color: #fff;
		}
		@media(min-width:768px) {
			#wrapper {
				padding-left: 225px;
			}
			#page-wrapper {
				padding: 22px 10px;
			}
		}
		/* Top Navigation */
		.top-nav {
			padding: 0 15px;
		}
		.top-nav>li {
			display: inline-block;
			float: left;
		}
		.top-nav>li>a {
			padding-top: 20px;
			padding-bottom: 20px;
			line-height: 20px;
			color: #fff;
		}
		.top-nav>li>a:hover,
		.top-nav>li>a:focus,
		.top-nav>.open>a,
		.top-nav>.open>a:hover,
		.top-nav>.open>a:focus {
			color: #fff;
			background-color: #1a242f;
		}
		.top-nav>.open>.dropdown-menu {
			float: left;
			position: absolute;
			margin-top: 0;
			/*border: 1px solid rgba(0,0,0,.15);*/
			border-top-left-radius: 0;
			border-top-right-radius: 0;
			background-color: #fff;
			-webkit-box-shadow: 0 6px 12px rgba(0,0,0,.175);
			box-shadow: 0 6px 12px rgba(0,0,0,.175);
		}
		.top-nav>.open>.dropdown-menu>li>a {
			white-space: normal;
		}
		/* Side Navigation */
		@media(min-width:768px) {
			.side-nav {
				position: fixed;
				top: 75px;
				left: 225px;
				width: 225px;
				margin-left: -225px;
				border: none;
				border-radius: 0;
				border-top: 1px rgba(0,0,0,.5) solid;
				overflow-y: auto;
				background-color: #222;
				/*background-color: #5A6B7D;*/
				bottom: 0;
				overflow-x: hidden;
				padding-bottom: 0;
			}
			.side-nav>li>a {
				width: 225px;
				border-bottom: 1px rgba(0,0,0,.3) solid;
			}
			.side-nav li a:hover,
			.side-nav li a:focus {
				outline: none;
				background-color: #1a242f !important;
			}
		}
		.side-nav>li>ul {
			padding: 0;
			border-bottom: 1px rgba(0,0,0,.3) solid;
		}
		.side-nav>li>ul>li>a {
			display: block;
			padding: 10px 15px 10px 38px;
			text-decoration: none;
			/*color: #999;*/
			color: #fff;    
		}
		.side-nav>li>ul>li>a:hover {
			color: #fff;
		}
		.navbar .nav > li > a > .label {
		  -webkit-border-radius: 50%;
		  -moz-border-radius: 50%;
		  border-radius: 50%;
		  position: absolute;
		  top: 14px;
		  right: 6px;
		  font-size: 10px;
		  font-weight: normal;
		  min-width: 15px;
		  min-height: 15px;
		  line-height: 1.0em;
		  text-align: center;
		  padding: 2px;
		}
		.navbar .nav > li > a:hover > .label {
		  top: 10px;
		}
		.navbar-brand {
			padding: 5px 15px;
		}
		.navi a {
		    border-bottom: 1px solid #0d172e;
		    border-top: 1px solid #0d172e;
		    color: #ffffff;
		    display: block;
		    font-size: 17px;
		    font-weight: 500;
		    padding: 15px 15px;
		    text-decoration: none;
		}
		
		.navi i {
		    margin-right: 15px;
		    color: #5584ff;
		}
		
		.navi .active a {
		    background: #122143;
		    border-left: 5px solid #5584ff;
		    padding-left: 15px;
		}
		
		.navi a:hover {
		    background: #122143 none repeat scroll 0 0;
		    border-left: 5px solid #5584ff;
		    display: block;
		    padding-left: 15px;
		}
		ul, menu, dir {
			display: block;
			list-style-type: disc;
			margin-block-start: 1em;
			margin-block-end: 1em;
			margin-inline-start: 0px;
			margin-inline-end: 0px;
			padding-inline-start: 10px;
		}
		img {
			width: 10%;
			height: 5%;
			}
		
		.well_top {
		    min-height: 20px;
		    padding: 15px;
		    margin-bottom: 20px;
		    top: 75px;
		    background-color: #f5f5f5;
		    border: 1px solid #e3e3e3;
		    border-radius: 4px;
		    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
		    box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
		}
		
		.btn-mokka { 
		  color: #ffffff; 
		  background-color: #B38744; 
		  border-color: #856820; 
		} 
	</style>
	<script>
	
	 function validdate(bok){
		  if(bok==6) {
			  
			  $("#issuebook").off('click');
		  }
	   //   document.getElementsByName("date")[0].setAttribute('min', today);
	   //   document.getElementsByName("newdate")[0].setAttribute('max', nextWeekDate);
		}
	 
	</script>
</head>	
<body onload="validdate()">
<h1>Welcome to the Home Page</h1>
<div id="throbber" style="display:none; min-height:120px;"></div>
<div id="noty-holder"></div>

    <div id="page-wrapper">
        <div class="container-fluid">
			<form action = "showdata" method ="POST">
			<div class="table-responsive table-bordered movie-table">
            	<table class="table movie-table">
            	<h1> Welcome</h1>
			        <thead>
			            <tr>
							<th style="color:green">Name :${name}</th>
							<th style="color:green">Email : ${email}</th>
							<th style="color:green"> Id :${id}</th>
							<th style="color:green" id = "bok" name = "bok"> Totalbooks :${Totalbooks}</th>
			            </tr>
			        </thead>
		    	</table>
		  <table class="table movie-table">
			        <thead>
			            <tr>
							<th>ID</th>
							<th>Book Name</th>
							<th>Book Author</th>
							
							<th>Publisher</th>
							<th>YearOfPublication</th>

							<th>Copies</th>
						

			            </tr>
			        </thead>
			        <tbody>
			        <c:forEach var="b" items="${List}">
					 		<tr>
					 			<td><c:out value="${b.getBookid()}"/></td>
								<td><c:out value="${b.getBookname()}"/></td>
								<td><c:out value="${b.getBookauthor()}"/></td>
								
								<td><c:out value="${b.getBookpublisher()}"/></td>
								<td><c:out value="${b.getPublication()}"/></td>
								
								<td><c:out value="${b.getNcopy()}"/></td>
							  
								
					 		</tr>
					 	</c:forEach> 
			        </tbody>
		    	</table>
		    	
		 <!--   	
		    	<h1> LIST OF ISSUED BOOKS</h1>
		   	  <table class="table movie-table">
			
			<table class="table movie-table">
			        <thead>
			            <tr>
							<th>Book ID</th>
							<th>Book Name</th>
							<th>Book Return date</th>

			            </tr>
			        </thead>
			        <tbody>
			          
			        <tr>
							<td style="color:green">${bookid}</td>
							<td style="color:green">${bookname}</td>
							
							<td style="color:green">${returndate}</td>
							
							
			           
			            </tr> 
			        
			        </tbody>   
		    	</table> --> 
		    	
			<a href = "issuebook">Issue Book</a><br><br>
			<a href = "returnbook">Return Book</a> <br><br>
			<a  style="color:red" href = "/">Logout</a>
		    	
            <!-- /.row -->
        </div>
        </form>
    
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
</div><!-- /#wrapper -->
</body>
</html>