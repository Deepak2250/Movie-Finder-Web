<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Movie Details</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
	
}

.container {
	max-width: 800px;
	margin: 20px auto;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
	padding: 20px;
}

.movie-image { 
    width:auto;
	max-height: 400px; /* Adjust the max-height as needed */
	border-radius: 8px 8px 0 0;
	object-fit: cover; /* Ensures the image covers the container */
	display: flex;
	justify-content: center;
}

.imageContainer{
width: 100%;
height:auto;
display: flex;
	justify-content: center;
}

}
.movie-details {
	padding: 20px;
}

.movie-details h2 {
	color: #333;
	margin-top: 0;
}

.movie-details p {
	color: #555;
	margin-top: 10px;
}

.movie-details ul {
	list-style-type: none;
	padding: 0;
}

.movie-details ul li {
	margin-bottom: 5px;
}
</style>
</head>
<body>
	<div class="container">
	<div class = imageContainer>
		<img src="${movieDetails.img}" alt="Movie Image" class="movie-image">
		</div>
		<div class="movie-details">
			<h2>${movieDetails.name}(${movieDetails.year})</h2>
			<p>
				<strong>Rated:</strong> ${movieDetails.rated}
			</p>
			<p>
				<strong>Released:</strong> ${movieDetails.released}
			</p>
			<p>
				<strong>Genre:</strong>
				<c:forEach items="${movieDetails.genere}" var="genre">
                    ${genre}<c:if test="${!loop.last}">, </c:if>
				</c:forEach>
			</p>
			<p>
				<strong>Director:</strong> ${movieDetails.director}
			</p>
			<p>
				<strong>Writer:</strong> ${movieDetails.writer}
			</p>
			<p>
				<strong>Actors:</strong>
				<c:forEach items="${movieDetails.actors}" var="actor">
                    ${actor}<c:if test="${!loop.last}">, </c:if>
				</c:forEach>
			</p>
			<p>
				<strong>Plot:</strong> ${movieDetails.plot}
			</p>
			<p>
				<strong>Awards:</strong> ${movieDetails.awards}
			</p>
			<p>
				<strong>IMDb Rating:</strong> ${movieDetails.imdb}
			</p>
		</div>
	</div>
</body>
</html>
