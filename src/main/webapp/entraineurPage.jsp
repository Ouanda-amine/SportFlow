<%@ page import="org.example.sportflow.bean.Entraineur" %><%--
  Created by IntelliJ IDEA.
  User: amine
  Date: 14/03/2025
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%
    Entraineur entraineur = (Entraineur) request.getAttribute("entr");
    if (entraineur == null) {
%>
<h2>Erreur : Les informations du entraineur ne sont pas disponibles.</h2>
<%
} else {
%>
<h2>Bienvenue </h2>
<%
    }
%>

<div class="container mt-5">
    <div class="text-center mb-4">
        <h1 class="fw-bold" style="color: #0d77d5"> <%= entraineur.getName()%></h1>
        <h2 class="text-muted"></h2>
    </div>


    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow-sm">
                <div class="card-body text-center">
                    <h2 class="card-title"> mes  Seances</h2>
                    <img src="coach.jpg" style="width: 400px; height: 200px;" class="rounded mx-auto d-block">
                    <a   href="#" class="btn btn-primary mt-3" >VOIR</a>                </div>
            </div>
        </div>

        <div class="col-md-5">
            <div class="card shadow-sm">
                <div class="card-body text-center">
                    <h2 class="card-title">Créer Une SeanCe</h2>
                    <img src="memberrs.jpg" style="width:400px;height:200px;">


                    <a   href="#" class="btn btn-primary mt-3" >Create</a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
