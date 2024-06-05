<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Already Registered</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
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
            text-align: center;
        }

        .container h1 {
            margin-bottom: 20px;
            color: #1a75ff;
        }

        .container p {
            margin-bottom: 30px;
        }

        .container .login-link {
            text-decoration: none;
            color: #1a75ff;
            font-weight: bold;
        }

        .container .login-link:hover {
            text-decoration: underline;
        }

        .icon {
            font-size: 48px;
            color: #1a75ff;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <i class="fas fa-check-circle icon"></i>
        <h1>Congratulations! You are already registered.</h1>
        <p>If you want to login, click <a href="/login" class="login-link">here</a>.</p>
         <a href="home">Go to Home</a>
    </div>
</body>
</html>
