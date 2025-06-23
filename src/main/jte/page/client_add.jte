@template.layout.main(
content = @`
    <div class="client-form-container">
        <h2>Add New Client</h2>
        <form action="/clients/add" method="post" class="client-form">
            <div class="form-group">
                <label for="last_name">Last Name:</label>
                <input type="text" id="last_name" name="last_name" required class="form-control">
            </div>

            <div class="form-group">
                <label for="first_name">First Name:</label>
                <input type="text" id="first_name" name="first_name" required class="form-control">
            </div>

            <div class="form-group">
                <label for="patronymic">Patronymic:</label>
                <input type="text" id="patronymic" name="patronymic" class="form-control">
            </div>

            <div class="form-group">
                <label for="passport_series">Passport Series:</label>
                <input type="text" id="passport_series" name="passport_series" required class="form-control">
            </div>

            <div class="form-group">
                <label for="passport_number">Passport Number:</label>
                <input type="text" id="passport_number" name="passport_number" required class="form-control">
            </div>

            <div class="form-group">
                <label for="passport_issued_date">Passport Issue Date:</label>
                <input type="date" id="passport_issued_date" name="passport_issued_date" required class="form-control">
            </div>

            <button type="submit" class="btn-submit">Add Client</button>
        </form>
    </div>
`,
headContent = @`
    <style>
        .client-form-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        .client-form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-control {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .btn-submit {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        .btn-submit:hover {
            background-color: #45a049;
        }
    </style>
`
)