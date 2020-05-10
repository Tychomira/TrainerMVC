<%-- 
    Document   : edittrainer
    Created on : 10 Μαϊ 2020, 4:05:56 μμ
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
        <title>Update Trainer</title>
         <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
    
          <% 
            String updateUrlFINAL = request.getContextPath() + "/" + request.getAttribute("updateurl");
            session.setAttribute("updateUrlFINAL", updateUrlFINAL);
        %>
         <div class='container' align='center' >
            <div class="row">
                <div class="col-md-8">
                    <h2 class="text-center">Update trainer! </h2>
                    <hr>


                    <form:form method="POST" action="${updateUrlFINAL}" modelAttribute="trainer">
                        <form:input type="hidden" path="id" id="id"/>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">First Name</label>
                            <div class="col-sm-10">
                                <form:input path="firstName" type="text" class="form-control" id="firstName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Last Name</label>
                            <div class="col-sm-10">
                                <form:input path="lastName" type="text" class="form-control" id="lastName" />
                            </div>
                        </div>      
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Subject</label>
                            <div class="col-sm-10">
                                <form:input path="subject" type="text" class="form-control" id="subject" />
                            </div>
                        </div>
                        <button type="submit" class="btn btn-dark">Update</button>
                    </form:form>
                </div>
            </div>      
            
           
        
        
        
        
    </body>
</html>
