<%@ page import="org.example.sportflow.bean.Membre" %><%--
  Created by IntelliJ IDEA.
  User: amine
  Date: 14/03/2025
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<h1>Welcom to SportFlow </h1>

<%
    Membre membre = (Membre) request.getAttribute("membre");
    if (membre == null) {
%>
<h2>Erreur : Les informations du membre ne sont pas disponibles.</h2>
<%
} else {
%>
<h2>Bienvenue, <%= membre.getNom() %></h2>
<%
    }
%>
<div class="row ">
    <div class="col md-4">
        <div class="card shadow-sm">
            <div class="card-body text-center">
                <h2 class="card-title">Inscrir a Une Seance</h2>
                <img src="inscrir.jpg" style="width: 250px; height: 200px;" class="rounded mx-auto d-block">
                <a   href="#" class="btn btn-primary mt-3" >inscription -></a>
            </div>
        </div>
    </div>

    <div class="col md-4">
        <div class="card shadow-sm">
            <div class="card-body text-center">
                <h2 class="card-title">List des Seances</h2>
                <img src="list.jpg" style="width:300px;height:200px;">
                <a   href="#" class="btn btn-primary mt-3" >voir la list</a>
            </div>
        </div>
    </div>
    <div class="col md-4">
        <div class="card shadow-sm">
            <div class="card-body text-center">
                <h2 class="card-title">Zone de Reclamation</h2>
                <img src="colleagues-working-together-call-center-office.jpg" style="width:300px;height:200px;">
                <a   href="#" class="btn btn-primary mt-3" >rediger une reclamation</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
