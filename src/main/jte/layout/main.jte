@param gg.jte.Content content
@param gg.jte.Content headContent = @``
@param gg.jte.Content scripts = @``

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Website</title>
    <style>

        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        .navigation {
            margin-top: 30px;
        }
        .navigation a {
            text-decoration: none;
            color: #0066cc;
            margin: 0 15px;
            font-size: 18px;
            transition: color 0.3s ease;
        }
        .navigation a:hover {
            color: #004080;
        }
    </style>
    ${headContent}
</head>
<body>
<h1>Welcome to My Website</h1>
<div class="navigation">
    <a href="client">Client</a>
    <a href="client/add">Add client</a>
    <a href="pawning">Pawning</a>
    <a href="pawning/add">Add pawning</a>

    <a href="categories">Product category</a>
    <a href="categories/add">Add product category</a>


</div>
${content}
${scripts}
</body>
</html>