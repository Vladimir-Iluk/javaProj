@template.layout.main(
content = @`
    <div class="login-container">
        <div class="login-header">
            <div class="logo">Login</div>
            <p>Please enter your credentials</p>
        </div>
        <form class="login-form" id="loginForm" action="/login" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" placeholder="Enter your username" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required>
            </div>
            <button type="submit" class="login-button">Login</button>
            <div class="create-account">
                <p>Don't have an account? <a href="/siqnup">Create Account</a></p>
            </div>
        </form>
    </div>
`,
headContent = @`
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px;
        }

        .login-container {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            overflow: hidden;
        }

        .login-header {
            background-color: #4a6cf7;
            color: white;
            padding: 20px;
            text-align: center;
        }

        .logo {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .login-form {
            padding: 30px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 8px;
            color: #333;
            font-weight: 500;
        }

        .form-group input {
            width: 100%;
            padding: 12px 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
            transition: border-color 0.3s;
        }

        .form-group input:focus {
            border-color: #4a6cf7;
            outline: none;
        }

        .login-button {
            background-color: #4a6cf7;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 12px;
            font-size: 16px;
            font-weight: 500;
            width: 100%;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-bottom: 20px;
        }

        .login-button:hover {
            background-color: #3a5ce5;
        }

        .create-account {
            text-align: center;
            font-size: 14px;
            color: #666;
        }

        .create-account a {
            color: #4a6cf7;
            text-decoration: none;
            font-weight: 500;
        }

        .create-account a:hover {
            text-decoration: underline;
        }

        @media (max-width: 480px) {
            .login-container {
                border-radius: 0;
                box-shadow: none;
            }

            .login-form {
                padding: 20px;
            }
        }
    </style>
`,
scripts = @`
    <script>
        document.getElementById('loginForm').addEventListener('submit', function(e) {
            console.log('Login submitted');
        });
    </script>
`
)
