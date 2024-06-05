<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">


<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"> 

<head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f3f4f6;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .container {
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        padding: 30px;
        width: 400px;
    }

    .container h1 {
        text-align: center;
        margin-bottom: 30px;
    }

    .form-group {
        position: relative; /* Add this line to make the parent container position relative */
        margin-bottom: 20px;
    }

    .form-group label {
        font-weight: bold;
    }

    .form-group input {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
        font-size: 16px;
    }

    .form-group .error {
        color: red;
        font-size: 14px;
        position: absolute;
        bottom: -20px; /* Adjust this value to move the error message below the input field */
        left: 0;
    }

    .form-group .icon {
        position: absolute;
        right: 10px;
        top: 50%; /* Adjust this value to vertically center the icon */
        transform: translateY(-50%); /* Adjust this value to vertically center the icon */
        color: #ccc;
    }

    .form-group input:focus {
        outline: none;
        border-color: #1a75ff;
    }

    .form-group button {
        background-color: #1a75ff;
        color: #fff;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        cursor: pointer;
        font-size: 16px;
    }

    .form-group button:hover {
        background-color: #004080;
    }

    .signup-link {
        text-align: center;
        margin-top: 20px;
    }

    .signup-link a {
        color: #1a75ff;
        text-decoration: none;
    }

    .signup-link a:hover {
        text-decoration: underline;
    }
 .error-message {


    color: #ff0000;
    font-size: 12px;
    padding: 5px 10px;
    margin-top: 5px;
}

.error-message i {
    margin-right: 5px; /* Adjust as needed */
}

    
</style>

</head>   

  <body>
  
  <div class="container">
    <h1>Sign Up</h1>
    <form:form modelAttribute = "finderUserPojo" id="registrationForm" action="registration" method="post">
        <div class="form-group">
            <form:label path = "name" for="name">Full Name</label></form:label>
            <form:input path = "name" type="text" id="name" name="name" placeholder="Enter your full name"></form:input>
            <form:errors path = "name" cssClass="error-message">
            
            </form:errors>
            <span class="icon"><i class="fas fa-user"></i></span>
        </div>
        <div class="form-group">
            <form:label path = "email" for="email">Email</label></form:label>
            <form:input path = "email" type="email" id="email" name="email" placeholder="Enter your email"></form:input>
            <form:errors path = "email" cssClass="error-message">
           
            </form:errors>
            <span class="icon"><i class="fas fa-envelope"></i></span>
        </div>
        <div class="form-group">
            <form:label path = "password" for="password">Password</label></form:label>
            <form:input path = "password" type="password" id="password" name="password" placeholder="Enter your password" ></form:input>
            <form:errors path = "password" cssClass="error-message">
           
            </form:errors>
            <span class="icon"><i class="fas fa-lock"></i></span>
        </div>
        <div class="form-group">
            <button type="submit">Sign Up</button>
        </div>
    </form:form>
    <div class="signup-link">
        Already have an account? <a href="/login">Log In</a>
    </div>
</div>

</body>
</html>
