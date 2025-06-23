@import com.github.dergach.demo.data.entitys.Pawning
@import com.github.dergach.demo.data.entitys.Client
@import com.github.dergach.demo.data.entitys.ProductCategory
@import java.util.List
@param Pawning pawning
@param List<Client> clients
@param List<ProductCategory> categories

@template.layout.main(
content = @`
    <div class="pawning-form-container">
        <h2>Edit Pawning</h2>
        <form action="/pawning/edit" method="post" class="pawning-form">
            <input type="hidden" name="pawning_id" value="${pawning.getPawning_id()}">

            <div class="form-group">
                <label for="client_id">Select Client:</label>
                <select id="client_id" name="client_id" class="form-control" required>
                    @for(Client client : clients)
                        <option value="${client.getClient_id()}" ${client.getClient_id() == pawning.getClient().getClient_id() ? "selected" : ""}>
                            ${client.getLast_name()} ${client.getFirst_name()}
                        </option>
                    @endfor
                </select>
            </div>

            <div class="form-group">
                <label for="category_id">Select Category:</label>
                <select id="category_id" name="category_id" class="form-control" required>
                    @for(ProductCategory category : categories)
                        <option value="${category.getCategory_id()}" ${category.getCategory_id() == pawning.getCategory().getCategory_id() ? "selected" : ""}>
                            ${category.getName()}
                        </option>
                    @endfor
                </select>
            </div>

            <div class="form-group">
                <label for="product_description">Product Description:</label>
                <textarea id="product_description" name="product_description" required class="form-control">${pawning.getProduct_description()}</textarea>
            </div>

            <div class="form-group">
                <label for="date_received">Date Received:</label>
                <input type="date" id="date_received" name="date_received" value="${pawning.getDate_received().toString()}" required class="form-control">
            </div>

            <div class="form-group">
                <label for="return_deadline">Return Deadline:</label>
                <input type="date" id="return_deadline" name="return_deadline" value="${pawning.getReturn_deadline().toString()}" required class="form-control">
            </div>

            <div class="form-group">
                <label for="amount">Amount:</label>
                <input type="number" step="0.01" id="amount" name="amount" value="${pawning.getAmount()}" required class="form-control">
            </div>

            <div class="form-group">
                <label for="commission">Commission:</label>
                <input type="number" step="0.01" id="commission" name="commission" value="${pawning.getCommission()}" required class="form-control">
            </div>

            <button type="submit" class="btn-submit">Update Pawning</button>
        </form>
    </div>
`,
headContent = @`
    <style>
        .pawning-form-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        .pawning-form-container h2 {
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