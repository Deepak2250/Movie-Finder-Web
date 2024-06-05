<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
 <style>
        /* Global Styles */
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #000;
            color: #fff;
            height: 100%;
        }
        
        /* Hero Section Styles */
        .hero-section {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        
        .hero-text {
            font-size: 3rem;
            text-align: center;
        }
        
        .hero-text p {
            font-size: 1.4rem;
            font-family: "Montserrat", sans-serif;
  font-weight: normal;
  font-style: normal;
        }
        
        .hero-text h1{
         font-family: "Open Sans", sans-serif;
  font-weight: bold;
  font-style: normal;
        
        }
        
        /* Navbar Styles */
        .navbar {
            background-color: black;
            color: black;
            padding: 10px;
            position: fixed;
            top: 0;
            width: 100%;
            text-align: center;
            z-index: 1000;
        }
        
        .navbar a {
            color: white;
            text-decoration: none;
            margin: 0 20px;
            font-family: "Montserrat", sans-serif;
            
  font-weight: normal;
  font-style: normal;
        }
        
        .navbar a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<div class="hero-section">
        <div class="hero-text">
            <h1>MOVIE FINDER</h1>
            <p>Find your favorite movies and explore new ones!</p>
        </div>
    </div>

    <div class="navbar" id="navbar">
        <a href="home">Home</a>
        <a href="about">About</a>
        <a href="moviepage">Movies</a>
        
       <%-- Show the login link only if the user is not logged in --%>
    <c:if test="${!isLoggedIn}">
        <a href="login">Login</a>
    </c:if>
    <%-- Show the profile link only if the user is logged in --%>
    <c:if test="${isLoggedIn}">
        <a href="profile">Profile</a>
    </c:if>
    </div>

</body>
 
</html>