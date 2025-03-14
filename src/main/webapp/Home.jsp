<%--
  Created by IntelliJ IDEA.
  User: amine
  Date: 13/03/2025
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <title>Title</title>
</head>
<body style="background-color:black">

<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
    <div class="container">
        <h1 style="font-family: 'Arial Rounded MT Bold' ; color: black"> SPORT_FLOW </h1>
        <form action="logout" > <button  class="btn btn-primary">logout</button> </form>
    </div>
</nav>


<div class="container mt-5">
    <div class="text-center mb-4">
        <h1 class="fw-bold" style="color: aliceblue">ADMIN ZONE</h1>
        <h2 class="text-muted"></h2>
    </div>


    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow-sm">
                <div class="card-body text-center">
                    <h2 class="card-title">TRAINERS Area</h2>
                    <img src="coach.jpg" style="width: 400px; height: 200px;" class="rounded mx-auto d-block">
                    <a   href="trainer" class="btn btn-primary mt-3" >TRAINERS MANAGEMENT</a>                </div>
            </div>
        </div>

        <div class="col-md-5">
            <div class="card shadow-sm">
                <div class="card-body text-center">
                    <h2 class="card-title">MEMBERS Area</h2>
                    <img src="memberrs.jpg" style="width:400px;height:200px;">


                    <a   href="membre" class="btn btn-primary mt-3" >MEMBERS MANAGEMENT</a>
                </div>
            </div>
        </div>
    </div>
</div>



</body>
</html>
