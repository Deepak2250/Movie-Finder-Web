<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About me</title>
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

    /* About Section Styles */
    .about-section {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .about-box {
        background-color: #333;
        border-radius: 10px;
        padding: 40px;
        text-align: center;
    }

    .about-title {
        font-size: 36px;
        font-weight: 700;
        margin-bottom: 20px;
    }

    .about-text {
        font-size: 18px;
        line-height: 1.6;
    }
</style>

</head>
<body>
<div class="about-section">
    <div class="about-box">
        <div class="about-title">About Us</div>
        <div class="about-text">
            <p>Hi there! My name is [Your Name], and I'm a Java backend programmer.</p>
            <p>I specialize in developing robust and scalable backend systems using Java and related technologies such as Spring Boot, Hibernate, and Maven. With several years of experience in software development, I have a deep understanding of object-oriented programming principles and design patterns.</p>
            <p>My passion for problem-solving and love for coding drive me to continually learn and improve my skills. I enjoy tackling complex challenges and crafting elegant solutions that meet the needs of users and businesses alike.</p>
            <p>Outside of coding, you can find me exploring new technologies, contributing to open-source projects, or enjoying outdoor adventures.</p>
            <p>I'm excited about the opportunity to collaborate on innovative projects and contribute to the success of your team or organization. Let's connect and build something amazing together!</p>
        </div>
    </div>
    <a href="home">Go to Home</a>
</div>
</body>
</html>