<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
	<!--  Step 1:   My First JSP!!! 
				hello ${name}  -->

	<!--  if you do not metion the method to be posr in form then it takes the parameteres as
	 query params in the url and serves as again a get request -->
	  <p><font color="red">${errorMessage}</font></p>
	<form action="/signIn" method="POST">
		Name : <input name="name" type="text" /> 
		Password : <input name="password" type="password" /> 
		<input type="submit" />
	</form>

</body>
</html>
