<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Search</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
<style>
    /* Global Styles */
    body {
        margin: 0;
        padding: 0;
        font-family: 'Montserrat', sans-serif;
        background-color: #000;
        color: #fff;
    }

    /* Search Box Styles */
    .search-container {
        text-align: center;
        margin-top: 50px;
    }

    .search-title {
        font-size: 24px;
        margin-bottom: 20px;
    }

    .search-box {
        padding: 10px;
        border: none;
        border-radius: 5px;
        width: 300px;
        font-size: 16px;
    }

    .search-button {
        padding: 10px 20px;
        background-color: #333;
        color: #fff;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
    }

    .search-button:hover {
        background-color: #555;
    }
</style>

</head>
<body>
<div class="search-container">
    <div class="search-title">Search Movies</div>
    <form action="moviesearch" method="post">
        <input type="text" name="movieName" placeholder="Enter movie name" class="search-box">
        <button type="submit" class="search-button">Search</button>
    </form>
</div>
</body>
</html>