<%--
  Created by IntelliJ IDEA.
  User: amine
  Date: 13/03/2025
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />

  <title>Title</title>
</head>
<body class="container w-50 mt-50">
<form action="trainer" method="post">
  <div class="form-group mb-3">
    <label for="nom" class="form-label">Nom </label>
    <input
            type="text"
            class="form-control"
            id="nom"
            name="name"
    />
  </div>
  <div class="form-group mb-3">
    <label for="spe" class="form-label">specialité</label>
    <input
            type="text"
            class="form-control"
            id="spe"

            name="spe"
    />
  </div>
  <div class="form-group mb-3">
    <label for="role" class="form-label">le role</label>
    <input
            type="text"
            class="form-control"
            id="role"
            placeholder="Entez le role"
            name="role"
    />
  </div>

  <div class="form-group mb-3">
    <label for="user" class="form-label">l'username</label>
    <input
            type="text"
            class="form-control"
            id="user"
            placeholder="Entez l'username"
            name="usernamee"
    />
  </div>

  <div class="form-group mb-3">
    <label for="password" class="form-label">Mot de Passe</label>
    <input
            type="password"
            class="form-control"
            id="password"
            placeholder="Entez un mot de passe"
            name="passwordd"
    />
  </div>



  <button type="submit" class="btn btn-success">Submit</button>
</form>

</body>
</html>
