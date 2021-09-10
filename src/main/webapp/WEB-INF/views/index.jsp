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
  height: 420px;
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
  margin-bottom: 20px;
}

.loginBox input[type="email"],
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
  border-radius: 20px;
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
<body>
<h1 style="color:ORANGE">LIBRARY MANAGEMENT SYSTEM</h1>
<div class="loginBox">

  <h2>Log In Here</h2>
  <form action ="validateuser" method = "POST">
    <p>Email</p>
    <input type="email" name="email" placeholder="Enter Email" required style="color:green">${msg}
    
    <p>Password</p>
    <input type="password" name="password" placeholder="Enter Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required style="color:green">${msg}
    <input type="submit" name="login" value="Sign In"><br>
     Register Here <a href="register" >   Register</a>
  </form>
</div>


</body>
</html>