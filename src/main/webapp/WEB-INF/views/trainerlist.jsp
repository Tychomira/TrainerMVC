<%-- 
    Document   : trainerlist
    Created on : 10 Μαϊ 2020, 9:34:59 πμ
    Author     : ticho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainer List</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    </head>
    <body>
        <div class="container"  align='center'>
            <h1>Trainer's List </h1>

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

                   
                    <td>
                        
                        <spring:url value="${deleteurl}/${trainer.id}" var="delete" />
                        <spring:url value="editurl/${trainer.id}" var="edit" />

                      
                        <button class="btn btn-primary"
                                onclick="location.href = '${editurl}/${trainer.id}'">Edit</button>
                        <button class="btn btn-danger"
                                onclick="location.href='${deleteurl}/${trainer.id}'">Delete</button>
                    </td>
                   </tr>
                  
                </c:forEach>

                      <td>
                      <spring:url value="${newurl}" var="new" /> 
                        <button class="btn btn-success "
                                onclick="location.href = '${newurl}'">Add </button>
                    </td>



	 

        </div>
    </body>
</html>
