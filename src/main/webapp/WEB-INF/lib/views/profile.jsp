<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f4f6;
            margin: 0;
            padding: 20px;
        }

        .container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            padding: 30px;
            max-width: 600px;
            margin: 0 auto;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .profile-info {
            margin-bottom: 20px;
        }

        .profile-info label {
            font-weight: bold;
            display: inline-block;
            width: 120px;
            margin-bottom: 10px;
        }

        .profile-info span {
            display: inline-block;
            width: 200px;
            margin-bottom: 10px;
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
        }

        .btn {
            background-color: #1a75ff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            margin-top: 20px;
            display: inline-block;
        }

        .btn:hover {
            background-color: #004080;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>User Profile</h1>
        <div class="profile-info">
            <label>Name:</label>
            <span>${userInfo.getName() }</span>
        </div>
        <div class="profile-info">
            <label>Email:</label>
            <span>${userInfo.getEmail()}</span>
        </div>
        
        <div class="profile-info">
            <label>Favorite Movie:</label>
            <span>${userInfo.getFavouriteMovie() }</span>
        </div>
        <div class="profile-info">
            <label>Favorite Genre:</label>
            <span>${userInfo.getFavouriteGenre() }</span>
        </div>
        <div class="btn-container">
            <a href="#" class="btn">Update Profile</a>
            <a href="#" class="btn">Delete Account</a>
            <a href="#" class="btn">Logout</a>
        </div>
    </div>
</body>
</html>
