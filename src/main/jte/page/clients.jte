@import com.github.dergach.demo.data.entitys.Client
@import java.util.List
@param List<Client> clients

@template.layout.main(
content = @`
    <div class="container">
        <h2>Clients List</h2>
        <a href="/clients/add" class="btn-add">Add New Client</a>
        <table class="data-table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Last Name</th>
                <th>First Name</th>
                <th>Patronymic</th>
                <th>Passport</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            @for(Client client : clients)
                <tr>
                    <td>${client.getClient_id()}</td>
                    <td>${client.getLast_name()}</td>
                    <td>${client.getFirst_name()}</td>
                    <td>${client.getPatronymic()}</td>
                    <td>${client.getPassport_series()} ${client.getPassport_number()}</td>
                    <td>
                        <a href="/clients/edit?client_id=${client.getClient_id()}" class="btn-edit">Edit</a>
                        <a href="/clients/delete?client_id=${client.getClient_id()}" class="btn-delete" onclick="return confirm('Are you sure?')">Delete</a>
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