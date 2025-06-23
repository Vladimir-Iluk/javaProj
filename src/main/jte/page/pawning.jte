@import com.github.dergach.demo.data.entitys.Pawning
@import java.util.List
@param List<Pawning> pawnings

@template.layout.main(
content = @`
    <div class="container">
        <h2>Pawnings List</h2>
        <a href="/pawning/add" class="btn-add">Add New Pawning</a>
        <table class="data-table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Client</th>
                <th>Category</th>
                <th>Description</th>
                <th>Amount</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            @for(Pawning pawning : pawnings)
                <tr>
                    <td>${pawning.getPawning_id()}</td>
                    <td>${pawning.getClient().getLast_name()} ${pawning.getClient().getFirst_name()}</td>
                    <td>${pawning.getCategory().getName()}</td>
                    <td>${pawning.getProduct_description()}</td>
                    <td>${pawning.getAmount()}</td>
                    <td>
                        <a href="/pawning/edit?pawning_id=${pawning.getPawning_id()}" class="btn-edit">Edit</a>
                        <a href="/pawning/delete?pawning_id=${pawning.getPawning_id()}" class="btn-delete" onclick="return confirm('Are you sure?')">Delete</a>
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