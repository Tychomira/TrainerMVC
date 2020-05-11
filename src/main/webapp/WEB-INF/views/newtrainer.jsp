<%-- 
    Document   : newtrainer
    Created on : 10 Μαϊ 2020, 2:25:06 μμ
    Author     : ticho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Trainer</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
       <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    </head>
    <body>
        <div class='container' align='center' >
            <div class="row">
                <div class="col-md-8">
                    <h2 class="text-center">Register a trainer </h2>
                    <hr>


                    <form:form class="form-horizontal" method="POST" action="new" modelAttribute="trainer">
                        <form:input type="hidden" path="id" id="id"/>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">First Name</label>
                            <div class="col-sm-10">
                                <form:input path="firstName" type="text" class="form-control" id="firstName" placeholder="First Name" />
                                <form:errors path="firstName" cssStyle="color: #ff0000;"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Last Name</label>
                            <div class="col-sm-10">
                                <form:input path="lastName" type="text" class="form-control" id="lastName" placeholder="Last Name" />
                                 <form:errors path="lastName" cssStyle="color: #ff0000;"/>
                            </div>
                        </div>      
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Subject</label>
                            <div class="col-sm-10">
                                <form:input path="subject" type="text" class="form-control" id="subject" placeholder="Subject" />
                                 <form:errors path="subject" cssStyle="color: #ff0000;"/>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-dark">Register</button>
                    </form:form>
                        
                </div>
            </div>      

             <div id="msg">${message}</div>
            <div id="list"><a href="<c:url value='/${listurl}' />">Back to the list of Trainers</a></div>
    </body>
</html>





