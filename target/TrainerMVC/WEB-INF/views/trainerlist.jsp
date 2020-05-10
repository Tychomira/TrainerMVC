<%-- 
    Document   : trainerlist
    Created on : 10 Μαϊ 2020, 9:34:59 πμ
    Author     : ticho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainer List</title>
        <link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
        <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
        <script src="webjars/jquery/3.0.0/jquery.min.js" ></script>
    </head>
    <body>
        <div class="container" >
            <h1>Trainer's List :</h1>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Subject</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <c:forEach items="${trainers}" var="trainer">
                    <tr>
                       
                        <td>${trainer.id}</td>
                        <td>${trainer.firstName}</td>
                        <td>${trainer.lastName}</td>
                        <td>${trainer.subject}</td>

                    </tr>
               
                <spring:url value="${newurl}" var="new" />   
                <spring:url value="${deleteurl}/${trainer.id}" var="delete" />
                <spring:url value="${editurl}/${trainer.id}" var="edit" />
                
                <button class="btn btn-success"
                        onclick="location.href = '${newurl}'">Add Trainer</button>
                <button class="btn btn-primary"
                        onclick="location.href = '${editurl}'">Edit</button>
                <button class="btn btn-danger"
                        onclick="this.disabled = true;post('${deleteurl}')">Delete</button>
                </td>
                </tr>
            </c:forEach>







    </div>
</body>
</html>
