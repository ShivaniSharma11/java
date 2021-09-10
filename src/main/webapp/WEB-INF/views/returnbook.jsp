<!DOCTYPE html>
<html lang="en">
<head>
<style>

body {
  margin: 0;
  padding: 0;
  background: url(https://picsum.photos/2500/1500?image=976);
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
  background-color: #FF8C00;
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

<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
  <script type="text/javascript">
  $(function(start,end){
	    var dtToday = new Date(start);
	    
	    var month = dtToday.getMonth() + 1;
	    var day = dtToday.getDate();
	    var year = dtToday.getFullYear();
	    if(month < 15)
	        month = '0' + month.toString();
	    if(day < 15)
	        day = '0' + day.toString();
	    
	    var maxDate = year + '-' + month + '-' + day;
	    $('#end').attr('min', maxDate);
	});
</script>
</head>
<body>
<div class="loginBox" >

  <h2>Return a Book</h2>
  <form action = "returnbook" method ="POST">${msg} <br>
  
  <p>User ID</p>
    <input type="number" name="uid" placeholder="Enter your ID"  title = "Enter the valid ID"  required>${msg}<br><br>

  
 <label for="bname">Books</label>
 <select name="bname" id="bname">
   <option value="the secret">The Secret</option>
    <option value="the alchemist">The Alchemist</option>
    <option value="Pride and Prejudice">Deep learning</option>
    <option value="The Book Thief">Pride and Prejudice</option>
    <option value="The Guide">The Guide</option>
  </select><br>


     <input type="submit" value="Return">
   
  </form>
</div>


</body>
</html>