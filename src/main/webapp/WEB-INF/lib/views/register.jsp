<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f3f4f6;
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.container {
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    padding: 30px;
    width: 400px;
}

h1 {
    text-align: center;
    margin-bottom: 20px;
}

.form-group {
    margin-bottom: 20px;
}

label {
    font-weight: bold;
    display: block;
    margin-bottom: 8px;
}

input[type="text"],
input[type="email"],
input[type="password"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-size: 16px;
}

button {
    background-color: #1a75ff;
    color: #fff;
    border: none;
    border-radius: 5px;
    padding: 10px 20px;
    cursor: pointer;
    font-size: 16px;
    width: 100%;
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
    color: red;
    font-size: 14px;
    margin-top: 5px;
}
</style>
</head>
<body>
    <div class="container">
        <h1>Sign Up</h1>
        <form:form modelAttribute="finderUserPojo" id="registrationForm" action="registration" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Full Name</label>
                <form:input path="name" type="text" id="name" name="name" placeholder="Enter your full name" />
                <form:errors path="name" cssClass="error-message"></form:errors>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <form:input path="email" type="email" id="email" name="email" placeholder="Enter your email" />
                <form:errors path="email" cssClass="error-message"></form:errors>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <form:input path="password" type="password" id="password" name="password" placeholder="Enter your password" />
                <form:errors path="password" cssClass="error-message"></form:errors>
            </div>
            <div class="form-group">
                <label for="favouriteMovie">Favorite Movie</label>
                <form:input path="favouriteMovie" type="text" id="favouriteMovie" name="favouriteMovie" placeholder="Enter your favorite movie" />
                <form:errors path="favouriteMovie" cssClass="error-message"></form:errors>
            </div>
            <div class="form-group">
                <label for="favouriteGenre">Favorite Genre</label>
                <form:input path="favouriteGenre" type="text" id="favouriteGenre" name="favouriteGenre" placeholder="Enter your favorite genre" />
                <form:errors path="favouriteGenre" cssClass="error-message"></form:errors>
            </div>
            
            <div class="form-group">
            <label for="file">Upload File</label>
            <input type="file" name="file"/>
            </div>
            
            <div class="form-group">
                <button type="submit">Sign Up</button>
            </div>
        </form:form>
        <div class="signup-link">
            Already have an account? <a href="login">Log In</a>
        </div>
    </div>
</body>
</html>
