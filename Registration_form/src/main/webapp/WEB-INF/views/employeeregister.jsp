<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/style.css" type="text/css" />
    <title>Backus Naur Form</title>
</head>

<style>
		body{
			background-image:url("${pageContext.request.contextPath}/images/bg-intro-desktop.png");
			background-repeat: no-repeat;
		}	
	</style>
<body>
    <div class="main">
        <div class="second">
            <h1 id="text-container">
                
            </h1>
        </div>
        <div class="form">
            <div>
                <p class="head">Backus Naur Form Checker</p>
            </div>
           <form action="<%= request.getContextPath() %>/register" method="post" onsubmit="return validator()">
                First Name
                <img class="first" src="<%= request.getContextPath() %>/images/icon-error.svg" alt="error-icon" id="error-icon">
                <input type="text" id="firstname" name="FirstName" />
                <div id="first-error" class="error-message"></div>
                Last Name
                <img class="last" src="<%= request.getContextPath() %>/images/icon-error.svg" alt="error-icon" id="error-icon">
                <input type="text" id="lastname" name="LastName" />
                <div id="last-error" class="error-message"></div>

                Other Name
                <img class="other" src="<%= request.getContextPath() %>/images/icon-error.svg" alt="error-icon" id="error-icon">
                <input type="text" id="othername" name="OtherName" />
                <div id="other-error" class="error-message"></div>

                Email
                <img class "email" src="<%= request.getContextPath() %>/images/icon-error.svg" alt="error-icon" id="error-icon">
                <input type="email" id="email" name="email_address" />
                <div id="email-error" class="error-message"></div>

                Password
                <img class="password" src="<%= request.getContextPath() %>/images/icon-error.svg" alt="error-icon" id="error-icon">
                <input type="password" id="password" name="password" />
                <div id="password-error" class="error-message"></div>

                Address
                <img class="address" src="<%= request.getContextPath() %>/images/icon-error.svg" alt="error-icon" id="error-icon">
                <input type="text" name="address" id="address" />
                <div id="address-error" class="error-message"></div>

                Comment
                <img class="comment" src="<%= request.getContextPath() %>/images/icon-error.svg" alt="error-icon" id="error-icon">
                <input type="text" name="comment" id="liveAlertBtn" />
                <div id="comment-error" class="error-message"></div>

                <input type="submit" class="submit" value="Submit" />
            </form>
        </div>
    </div>
 
    <script src="<%= request.getContextPath() %>/Js/index.js"></script>
</body>
</html>
