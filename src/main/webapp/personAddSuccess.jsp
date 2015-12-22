<%--
  Created by IntelliJ IDEA.
  User: Nitin C
  Date: 12/17/2015
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SUCCESS (Nitin)!!</title>
    <link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<h2>
    ${success}
</h2>

<div class="container" style="padding-top: 10%">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <a href="persons.do" class="btn btn-block active btn-lg btn-danger" type="button">Check all Persons</a>
        </div>
    </div>
</div>
</body>
</html>
