<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Successful</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Montserrat', sans-serif;
            background: linear-gradient(135deg, #ff4b2b, #ff416c);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            overflow: hidden;
        }

        .container {
            text-align: center;
            background-color: rgba(255, 255, 255, 0.9);
            padding: 50px;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
            width: 400px;
            position: relative;
        }

        .container h2 {
            color: #ff416c;
            margin-bottom: 20px;
            font-size: 32px;
            font-weight: 700;
        }

        .container p {
            color: #333;
            font-size: 18px;
            margin: 10px 0;
        }

        .success-message {
            font-size: 20px;
            color: #008000;
            font-weight: bold;
        }

        .container a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #ff416c;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .container a:hover {
            background-color: #ff4b2b;
        }

        .animated-background {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: radial-gradient(circle, rgba(255, 255, 255, 0.2) 20%, transparent 20%);
            background-size: 10px 10px;
            animation: moveBackground 2s linear infinite;
            z-index: -1;
        }

        @keyframes moveBackground {
            from {background-position: 0 0;}
            to {background-position: 10px 10px;}
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Registration Successful!</h2>
    <p class="success-message">${User.getName() } has been successfully registered.</p>
    <p>Thank you for registering with Movie Finder.</p>
    <a href="home">Go to Home</a>
</div>
<div class="animated-background"></div>

</body>
</html>
