<%@ page import="org.example.sportflow.bean.Entraineur" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: amine
  Date: 13/03/2025
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <title>Title</title>
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Trainers List</h2>

    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>NOM</th>
            <th>Specialité</th>
            <th>Role</th>
            <th>Username</th>
            <th>Password</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Entraineur> entraineurList = (List<Entraineur>) request.getAttribute("entraineurlist");

            for (Entraineur entraineur : entraineurList) {
        %>
        <tr>
            <td><%= entraineur.getIdent() %></td>
            <td><%= entraineur.getName() %></td>
            <td><%= entraineur.getSpecialite()%></td>
            <td><%= entraineur.getRoole()%></td>
            <td><%= entraineur.getUsrname() %></td>
            <td><%= entraineur.getPsw()%></td>

            <td>
                <a href="trainer?action=edit&id=<%= entraineur.getIdent()%>" class="btn btn-warning btn-sm">Edit</a>
                <a href="trainer?action=delete&id=<%= entraineur.getIdent() %>" class="btn btn-danger btn-sm">Delete</a>




            </td>
        </tr>
        <%

            }
        %>
        </tbody>
    </table>

    <a href="EntraineurForm.jsp" class="btn btn-success">Add new Trainer</a>
</div>

</body>
</html>
