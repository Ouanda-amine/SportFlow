<%@ page import="org.example.sportflow.bean.Entraineur" %><%--
  Created by IntelliJ IDEA.
  User: amine
  Date: 13/03/2025
  Time: 11:44
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
    <h2 class="text-center mb-4">Update Trainer</h2>

    <%
        Entraineur entraineur = (Entraineur) request.getAttribute("entraineur");
    %>

    <form action="trainer" method="post">
        <input type="hidden" name="id" value="<%= entraineur.getIdent() %>"/>
        <input type="hidden" name="action" value="update"/>

        <div class="form-group">
            <input type="text" class="form-control" name="name" value="<%=entraineur.getName() %>" required />
        </div>

        <div class="form-group">
            <input type="text" class="form-control" name="spe" value="<%=entraineur.getSpecialite() %>" required />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="role" value="<%=entraineur.getRoole() %>" required />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="username" value="<%=entraineur.getUsrname()%>" required />
        </div>

        <div class="form-group">
            <input type="text" class="form-control" name="password" value="<%=entraineur.getPsw()%>" required />
        </div>

        <button type="submit" class="btn btn-primary btn-block">Update</button>
    </form>


    <br>
    <a href="CoursServlet" class="btn btn-secondary"> <- list </a>
</div>

</body>
</html>
