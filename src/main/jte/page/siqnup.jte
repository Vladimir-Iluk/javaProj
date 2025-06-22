@template.layout.main(
content = @`
    <div class="signup-container">
        <div class="signup-header">
            <div class="logo">Sign Up</div>
            <p>Create your account</p>
        </div>
        <form class="signup-form" id="signupForm">
            <div class="form-group" id="usernameGroup">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" placeholder="Choose a username" required>
                <p class="error-message">Username must be at least 4 characters</p>
            </div>
            <div class="form-group" id="passwordGroup">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Create a password" required>
                <p class="error-message">Password must be at least 8 characters</p>
            </div>
            <div class="form-group">
                <label for="role">Role</label>
                <select id="role" name="role" required>
                    <option value="ADMIN">ADMIN</option>
                    <option value="STUDENT">STUDENT</option>
                </select>
            </div>
            <button type="submit" class="signup-button">Sign Up</button>
            <div class="login-link">
                <p>Already have an account? <a href="/login">Log In</a></p>
            </div>
        </form>
    </div>
`,
scripts = @`
    <script>
        document.getElementById('signupForm').addEventListener('submit', function(e) {
            e.preventDefault();
            let isValid = true;

            const username = document.getElementById('username');
            const password = document.getElementById('password');
            const role = document.getElementById('role');

            if (username.value.length < 4) {
                document.getElementById('usernameGroup').classList.add('error');
                isValid = false;
            } else {
                document.getElementById('usernameGroup').classList.remove('error');
            }

            if (password.value.length < 8) {
                document.getElementById('passwordGroup').classList.add('error');
                isValid = false;
            } else {
                document.getElementById('passwordGroup').classList.remove('error');
            }

            if (isValid) {
                const formData = {
                    username: username.value.trim(),
                    password: password.value,
                    role: role.value
                };

                const apiUrl = 'http://localhost:8080/siqnup';

                fetch(apiUrl, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(formData)
                })
                    .then(response => {
                        if (!response.ok) throw new Error('Registration failed');
                        return response.json();
                    })
                    .then(() => {
                        window.location.href = '/login';
                    })
                    .catch(error => {
                        alert('Error: ' + error.message);
                    });
            }
        });
    </script>
`
)
