<!DOCTYPE html>
<html lang="en">
<head>
<style>

body {
  margin: 0;
  padding: 0;
  background-color: grey;
  background-size: cover;
  font-family: sans-serif;
}

.loginBox {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 350px;
  height: 700px;
  padding: 70px 40px;
  box-sizing: border-box;
  background: rgba(0, 0, 0, 0.5);
}

.user {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  overflow: hidden;
  position: absolute;
  top: calc(-100px/2);
  left: calc(50% - 50px);
}

h2 {
  margin: 0;
  padding: 0 0 26px;
  color: #ff8c00;
  text-align: center;
}

.loginBox p {
  margin: 0;
  padding: 0;
  font-weight: bold;
  color: #fff;
}

.loginBox input {
  width: 100%;
  margin-bottom: 40px;
}

.loginBox input[type="email"],
.loginBox input[type="text"],
.loginBox input[type="number"],
.loginBox input[type="password"] {
  border: none;
  border-bottom: 1px solid #fff;
  background: transparent;
  outline: none;
  height: 40px;
  color: #fff;
  font-size: 16px;
}

::placeholder
{
  color: rgba(255, 255, 255, 0.5);
}

.loginBox input[type="submit"] {
  border: none;
  outline: none;
  height: 40px;
  color: #eee;
  font-size: 16px;
  background-color: orange;
  cursor: pointer;
  border-radius: 40px;
  margin: 12px 0 18px;
}

.loginBox input[type="submit"]:hover {
  background-color: #ff9719;
  color: #fff;
}

.loginBox a {
  color: #fff;
  font-size: 14px;
  font-weight: bold;
  text-decoration: none;
}
</style>

</head>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
 <script type="text/javascript">
  
 function validDate(){
	    var today = new Date().toISOString().split('T')[0];
	    var nextWeekDate = new Date(new Date().getTime() + 15 * 24 * 60 * 60 * 1000).toISOString().split('T')[0];
      document.getElementsByName("date")[0].setAttribute('min', today);
      document.getElementsByName("newdate")[0].setAttribute('max', nextWeekDate);
	}
</script>
</head>
<body>
<body onload="validDate()">
<div class="loginBox" >
 
		    	
  <h2>Issue a Book</h2>
  <form action = "issuebook" method ="POST"> <br>
  
  <p>User ID</p>
    <input type="text" name="uid" placeholder="Enter your ID"  title = "Enter the valid ID"  required><br><br>
    
   <label for="type">Type</label>
 <select name="type" id="type">
    <option value="staff">staff</option>
    <option value="student">student</option>
  </select><br><br>
   
  <p>Book ID</p>
    <input type="text" name="bid" placeholder="Enter your Book ID"  title = "Enter the valid ID"  required>
  <br><br>
  
 <label for="bname">Books</label>
 <select name="bname" id="bname">
    <option value="the secret">The Secret -1</option>
    <option value="the alchemist">The Alchemist -2</option>
    <option value="Deep learning">Deep learning-3</option>
    <option value="Pride and Prejudice">Pride and Prejudice-4</option>
    <option value="The Guide">The Guide-5</option>
    
  </select><br>
  
 
   Issue Date <input type="date" name="date" id="date"   required />
 Return Date<input type="date" name="newdate" id="newdate"  required/>
  
    
 <br><br>
     <input type="submit" value="Issue">
   
  </form>
</div>

</body>
</body>
</html>