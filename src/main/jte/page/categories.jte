@import com.github.dergach.demo.data.entitys.ProductCategory
@import java.util.List
@param List<ProductCategory> categories
@param String sortDirection
@param String searchTerm

@template.layout.main(
content = @`
    <div class="container">
        <h2>Product Categories</h2>
        <a href="/categories/add" class="btn-add">Add New Category</a>
        <div class="sort-container">
            <span class="sort-label">Sort by ID:</span>
            <a href="/categories?sort=${sortDirection == "asc" ? "desc" : "asc"}" class="btn-sort">
                ${sortDirection == "asc" ? "▼ Descending" : "▲ Ascending"}
            </a>
        </div>
        <div class="search-container">
            <form action="/categories" method="get">
                <input type="text" name="search" placeholder="Search across all fields..."
                       value="${searchTerm != null ? searchTerm : ""}">
                <button type="submit" class="btn-search">Search</button>
                <a href="/categories" class="btn-clear">Clear</a>
            </form>
        </div>
        <table class="data-table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Notes</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            @for(ProductCategory category : categories)
                <tr>
                    <td>${category.getCategoryId()}</td>
                    <td>${category.getName()}</td>
                    <td>${category.getNotes()}</td>
                    <td>
                        <a href="/categories/edit?categoryId=${category.getCategoryId()}" class="btn-edit">Edit</a>
                        <a href="/categories/delete?categoryId=${category.getCategoryId()}" class="btn-delete" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            @endfor
            </tbody>
        </table>
    </div>
`,
headContent = @`
    <style>
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        .btn-add {
            display: inline-block;
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            margin-bottom: 20px;
            text-decoration: none;
            border-radius: 4px;
        }

        .sort-container {
            margin-bottom: 15px;
            display: flex;
            align-items: center;
        }

        .sort-label {
            margin-right: 10px;
            font-weight: bold;
        }

        .btn-sort {
            display: inline-block;
            background-color: #6c757d;
            color: white;
            padding: 8px 12px;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        .btn-sort:hover {
            background-color: #5a6268;
        }

        .search-container {
            margin-bottom: 20px;
            display: flex;
        }

        .search-container input[type="text"] {
            padding: 8px;
            width: 300px;
            border: 1px solid #ddd;
            border-radius: 4px 0 0 4px;
        }

        .btn-search {
            padding: 8px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 0 4px 4px 0;
            cursor: pointer;
        }

        .btn-clear {
            padding: 8px 15px;
            margin-left: 10px;
            background-color: #f44336;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

        .btn-search:hover {
            background-color: #45a049;
        }

        .btn-clear:hover {
            background-color: #d32f2f;
        }

        .data-table {
            width: 100%;
            border-collapse: collapse;
        }

        .data-table th, .data-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        .data-table th {
            background-color: #f2f2f2;
        }

        .data-table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .btn-edit {
            display: inline-block;
            background-color: #2196F3;
            color: white;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 4px;
        }
        .btn-delete {
            display: inline-block;
            background-color: #f44336;
            color: white;
            padding: 5px 10px;
            margin-left: 5px;
            text-decoration: none;
            border-radius: 4px;
        }

        .btn-delete:hover {
            background-color: #d32f2f;
        }
    </style>
`
)