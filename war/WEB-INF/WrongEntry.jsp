<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Please Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="../CSS/bootstrap.min.css">
</head>
<body>    
	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class=" navbar-left navbar-brand">
				<strong>Body Mass Index</strong>
			</div>
			<div id="my-button">
				<button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
			<div id="add-br">
			</div>
			<div class="collapse navbar-collapse navHeaderCollapse" >
				<ul class="nav navbar-nav navbar-right">
						<li><a href="/">HOME</a></li>
						<li><a href="/Index">Calculate BMI</a></li>
						<li><a href="#contact" data-toggle="modal">Contact</a></li>
				</ul>
			</div>
		</div>
	</div>
	<center><p class="text-danger lead"><b>The entered username/ password is not valid. Please enter the right values or sign up!</b></p></center>
	<br>
	<center>
		<a href="../Login.jsp">
			<button class="btn btn-success">Login</button>
		</a>
		<a href="../SignUp.jsp">
			<button class="btn btn-primary">Sign up</button>
		</a>
	</center>
	
	 <div class="modal fade" id="contact">
		<div class="modal-dialog" >
			<div class="modal-content">
				<div class="modal-header" >
					<h4><b>Contact me</b></h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" action="/MailSend" >
						<div class="form-group">
							<label for="usrname" class="control-label col-lg-2">Name</label>
							<div class="col-lg-10">
								<input type="text" class="form-control" id="usrname" placeholder="Full name" name="name" required>
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="control-label col-lg-2">E-mail</label>
							<div class="col-lg-10">
								<input type="email" class="form-control" id="email" placeholder="you@yourdomain.com" name="email" required>
							</div>
						</div>
						<div class="form-group">
							<label for="msg" class="control-label col-lg-2">Message</label>
								<div class="col-lg-10">
									<textarea rows="8" id="msg" name="msg" class="form-control" placeholder="Your Message" required></textarea>
								</div>					
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary pull-right" style="margin-right:5px">Send</button>
							<button type="button" class="btn btn-default pull-right"  style="margin-right:5px" data-dismiss="modal">Cancel</button>
						</div>
					</form>
				</div>
			</div>				
		</div>
	</div>
	

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/AddBr.js"></script>
	
</body>
</html>