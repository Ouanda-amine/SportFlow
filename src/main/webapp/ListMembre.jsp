<%@ page import="org.example.sportflow.bean.Membre" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: amine
  Date: 13/03/2025
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Members List</h2>

    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>NOM</th>
            <th>date de nissance</th>
            <th>Sport Pratiqué</th>
            <th>Role</th>
            <th>Username</th>
            <th>Password</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Membre> membreList = (List<Membre>) request.getAttribute("membrelist");

            for (Membre membre : membreList) {
        %>
        <tr>
            <td><%= membre.getId() %></td>
            <td><%= membre.getNom() %></td>
            <td><%= membre.getDatenaissance()%></td>
            <td><%= membre.getSportpratique()%></td>
            <td><%= membre.getRole()%></td>
            <td><%= membre.getUsername() %></td>
            <td><%= membre.getPassword()%></td>

            <td>
                <a href="membre?action=edit&id=<%= membre.getId()%>" class="btn btn-warning btn-sm">Edit</a>
                <a href="membre?action=delete&id=<%= membre.getId() %>" class="btn btn-danger btn-sm">Delete</a>




            </td>
        </tr>
        <%

            }
        %>
        </tbody>
    </table>

    <a href="membreForm.jsp" class="btn btn-success">Add new Member</a>
</div>

</body>
</html>
