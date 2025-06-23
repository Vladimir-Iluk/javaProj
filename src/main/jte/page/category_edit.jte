@import com.github.dergach.demo.data.entitys.ProductCategory
@param ProductCategory category

@template.layout.main(
content = @`
    <div class="category-form-container">
        <h2>Edit Category</h2>
        <form action="/categories/edit" method="post" class="category-form">
            <input type="hidden" name="category_id" value="${category.getCategory_id()}">

            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="${category.getName()}" required class="form-control">
            </div>

            <div class="form-group">
                <label for="notes">Notes:</label>
                <textarea id="notes" name="notes" class="form-control">${category.getNotes()}</textarea>
            </div>

            <button type="submit" class="btn-submit">Update Category</button>
        </form>
    </div>
`,
headContent = @`
    <style>
        .category-form-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        .category-form-container h2 {
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

        textarea.form-control {
            min-height: 100px;
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