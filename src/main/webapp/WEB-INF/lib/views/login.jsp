<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;400;700&family=Open+Sans:wght@300;400;600;800&display=swap" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Open Sans', sans-serif;
            background-color: #141414;
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        
        .container {
            background-color: #1c1c1c;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            max-width: 400px;
            width: 100%;
        }
        
        .container h1 {
            font-family: 'Montserrat', sans-serif;
            font-weight: 700;
            margin-bottom: 20px;
            text-align: center;
        }
        
        .form-group {
            margin-bottom: 20px;
        }
        
        .form-group label {
            display: block;
            font-weight: 600;
            margin-bottom: 5px;
        }
        
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #333;
            border-radius: 5px;
            background-color: #333;
            color: #fff;
        }
        
        .form-group input:focus {
            outline: none;
            border-color: #555;
        }
        
        .form-group button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #e50914;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            font-weight: 700;
            text-transform: uppercase;
        }
        
        .form-group button:hover {
            background-color: #d40813;
        }
        
        .signup-link {
            text-align: center;
            margin-top: 20px;
        }
        
        .signup-link a {
            color: #e50914;
            text-decoration: none;
        }
        
        .signup-link a:hover {
            text-decoration: underline;
        }
        
        .error {
            color: red;
            font-size: 14px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form:form modelAttribute="movieFinderLoginUserPojo" action="loggedIn" method="post">
            <div class="form-group">
                <form:label path="email">Email</form:label>
                <form:input path="email" type="email" placeholder="Enter your email" />
                <form:errors path="email" cssClass="error" />
            </div>
            <div class="form-group">
                <form:label path="password">Password</form:label>
                <form:input path="password" type="password" placeholder="Enter your password" />
                <form:errors path="password" cssClass="error" />
            </div>
            <div class="form-group">
                <button type="submit">Login</button>
            </div>
            
        </form:form>
         <c:if test="${registerFirst }">
           <h1 class="error">Invalid User</h1>
        </c:if>
        <div class="signup-link">
            Don't have an account? <a href="register">Sign Up</a>
        </div>
    </div>
</body>
</html>
