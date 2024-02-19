<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url('/assets/background.jpg');
            background-size: cover;
            background-position: center;
        }
        .card {
            margin-top: 100px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card ">
                    <div class="card-body">
                        <div class="text-center mb-4">
                            <img src="https://tse4.mm.bing.net/th/id/OIP.qjpzwhnL7VNaTPKORk71mQHaHa?rs=1&pid=ImgDetMain" alt="Logo" style="max-height: 100px;">
                        </div>
                        <form action="/doLogin" method="post">
                            <div class="mb-3">
                                <label for="email" class="form-label">Email address</label>
                                <input type="email" class="form-control" id="email" name="username" required>
                                <div class="invalid-feedback">
                                    Please enter a valid email address.
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password" required minlength="8">
                                <!-- <div class="invalid-feedback">
                                    Password must be at least 8 characters long.
                                </div> -->
                            </div>
                            <div class="mb-3 text-center">
                                <button type="submit" class="btn btn-primary btn-block ">Login</button>
                            </div>
                        </form>
                        <p class="text-center mt-3">Register as restaurant <a href="/register">Create One</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

