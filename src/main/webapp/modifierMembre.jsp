<%@ page import="org.example.sportflow.bean.Membre" %><%--
  Created by IntelliJ IDEA.
  User: amine
  Date: 13/03/2025
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Update Trainer</h2>

    <%
        Membre membre = (Membre) request.getAttribute("membre");
    %>

    <form action="membre" method="post">
        <input type="hidden" name="id" value="<%= membre.getId() %>"/>
        <input type="hidden" name="action" value="update"/>

        <div class="form-group">
            <input type="text" class="form-control" name="nom" value="<%=membre.getNom() %>" required />
        </div>

        <div class="form-group">
            <input type="text" class="form-control" name="date" value="<%=membre.getDatenaissance() %>" required />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="sportt" value="<%=membre.getSportpratique() %>" required />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="role" value="<%=membre.getRole()%>" required />
        </div>

        <div class="form-group">
            <input type="text" class="form-control" name="username" value="<%=membre.getUsername()%>" required />
        </div>

        <div class="form-group">
            <input type="text" class="form-control" name="password" value="<%=membre.getPassword()%>" required />
        </div>

        <button type="submit" class="btn btn-primary btn-block">Update</button>
    </form>


    <br>
    <a href="CoursServlet" class="btn btn-secondary"> <- list </a>
</div>

</body>
</html>
