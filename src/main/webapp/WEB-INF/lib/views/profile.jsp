<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.js"></script>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #eef2f7;
            margin: 0;
            padding: 20px;
        }

        .container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            padding: 30px;
            max-width: 600px;
            margin: 20px auto;
            text-align: center;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
            font-size: 2.5em;
        }

        .profile-picture-container {
            position: relative;
            width: 150px;
            height: 150px;
            margin: 0 auto 20px;
            border-radius: 50%;
            overflow: hidden;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
            border: 5px solid #1a75ff; /* Add border */
        }

        .profile-picture {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .profile-info {
            margin-bottom: 20px;
            text-align: left;
        }

        .profile-info label {
            font-weight: bold;
            display: inline-block;
            width: 150px;
            margin-bottom: 10px;
            color: #555;
        }

        .profile-info span {
            display: inline-block;
            width: calc(100% - 160px);
            margin-bottom: 10px;
            color: #333;
        }

        .profile-info a {
            color: #1a75ff;
            text-decoration: none;
            margin-left: 10px;
        }

        .profile-info a:hover {
            text-decoration: underline;
        }

        .btn-container {
            text-align: center;
            margin-top: 30px;
        }

        .btn {
            background-color: #1a75ff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 12px 25px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            margin: 10px;
            display: inline-block;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #004080;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>User Profile</h1>
        
        <div class="profile-picture-container">
            <c:if test="${not empty image}">
                <img class="profile-picture" src="data:image/jpeg;base64,${image}" alt="User Image" />
            </c:if>
        </div>
        
        <div class="profile-info">
            <label>Name:</label>
            <span>${userInfo.getName()}</span>
        </div>
        <div class="profile-info">
            <label>Email:</label>
            <span>${userInfo.getEmail()}</span>
        </div>
        <div class="profile-info">
            <label>Favorite Movie:</label>
            <span>${userInfo.getFavouriteMovie()}</span>
        </div>
        <div class="profile-info">
            <label>Favorite Genre:</label>
            <span>${userInfo.getFavouriteGenre()}</span>
        </div>
        <div class="btn-container">
            <a href="updateProfilePage/${userInfo.getId()}" class="btn">Update Profile</a>
            <a href="deleteUser" class="btn">Delete Account</a>
            <a href="logout" class="btn">Logout</a>
        </div>
    </div>
</body>
</html>
