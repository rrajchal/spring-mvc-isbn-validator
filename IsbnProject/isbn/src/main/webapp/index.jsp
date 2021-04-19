
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>


<html>
	
	<link rel="stylesheet" type="text/css" href="css/myStyle.css">
	<title>ISBN Validation</title>

	<body>
		<form action="validateIsbn"  method="get">
			
			<br>
			<h2 class="center">Enter ISBN Number</h2>
			<div class="center">
				<input class="spacer100" type="text" id="isbnNum" name="isbnNum"
					   placeholder="Enter 10 or 13 digit ISBN Number" pattern=".{10,}" maxlength="20"  
					   title="Must contain 10-20 characters"
					   required="required">
				<br>
				<br>

				<h2 class="center">${result}</h2>
				<input type="submit" value="Check">
			</div>
		</form> 
		
		
	</body>
</html>
