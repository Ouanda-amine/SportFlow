<%--
  Created by IntelliJ IDEA.
  User: amine
  Date: 12/03/2025
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />

</head>
<body>
<div class="container my-5">
    <div class="card-body">
        <h2 class="card-title text-center mb-4">ajouter Etudiant</h2>
        <form action="membre" method="post">
            <div class="mb-3">
                <label for="nom" class="form-label">Nom</label>
                <input type="text" class="form-control" id="nom" name="nom">
            </div>

            <div class="mb-3">
                <label for="date" class="form-label">Date de Naissance</label>
                <input type="date" class="form-control" id="date" name="date">
            </div>

            <div class="mb-3">
                <label for="sportpra" class="form-label">Sport Pratiqué</label>
                <input type="text" class="form-control" id="sportpra" name="sport">
            </div>


            <div class="mb-3">
                <label for="role" class="form-label">role</label>
                <input type="text" class="form-control" id="role" name="role">
            </div>

            <div class="mb-3">
                <label for="adresse" class="form-label">username</label>
                <input type="text" class="form-control" id="adresse" name="username">
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">password</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <div class="mb-3">

                <button type="submit" class="btn btn-primary" >Ajouter</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
