<%--
  Created by IntelliJ IDEA.
  User: Nitin C
  Date: 1/4/2016
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="pre" %>

<html>
<head>
    <title> Pagination </title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <!-- Custom styles for this Project -->
    <link href="css/myStyle.css" rel="stylesheet" type="text/css">

</head>
<body>


<div class="loading-div"><img src="img/edit.png"></div>
<div id="results"><!-- content will be loaded here -->
    $(document).ready(function() {
    $("#results" ).load( "fetch_pages.php"); //load initial records

    //executes code below when user click on pagination links
    $("#results").on( "click", ".pagination a", function (e){
    e.preventDefault();
    $(".loading-div").show(); //show loading element
    var page = $(this).attr("data-page"); //get page number from link
    $("#results").load("fetch_pages.php",{"page":page}, function(){ //get content from PHP page
    $(".loading-div").hide(); //once done, hide loading element
    });

    });
    });

</div>

<%--
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">

            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Person Services</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/persons.do">See All Persons</a></li>
                        <li><a href="${pageContext.request.contextPath}/uploadPersonData.do">Input Persons Data</a></li>
                    </ul>
                </div>
            </nav>
            <div class="bs-example" align="center">
                <table class="table table-striped" class="table-responsive" style="width: 80%">
                    <thead>
                    <tr>
                        <th>SNo</th>
                        <th>UID</th>
                        <th>Email</th>
                        <th>password</th>
                        <th>DOB</th>
                        <th>TOB</th>
                        <th>Country</th>
                        <th>Ethinicity</th>
                        <th>isHappy?</th>
                        <th>Image</th>
                    </tr>
                    </thead>
                    <tbody>

                    <pre:forEach items="${personDataPaginationForm.personsFormDataList}" var="item" varStatus="sno">
                        <tr>
                            <td>${sno.count}</td>
                            <td>${item.UID}</td>
                            <td>${item.email}</td>
                            <td>${item.password}</td>
                            <td>${item.dob}</td>
                            <td>${item.tob}</td>
                            <td>${item.country}</td>
                            <td>${item.ethinicity}</td>
                            <td>${item.isHappy}</td>
                            <td><img src="findImageByUID.do?uId=${item.UID}"
                                     style="width: 60px;" class="img-circle"></td>
                            <!-- Provide item.UID for properly matching the image -->
                            <!-- EDIT AND DELETE BUTTONS  -->
                            <td><a href="editPersonByUID.do?uId=${item.UID}"> <img
                                    src="img/edit.png" style="height: 30px; width: 30px"/>
                            </a> &nbsp;&nbsp; <a href="deletePersonByUID.do?uId=${item.UID}"><img
                                    src="img/delete.png" style="height: 30px; width: 30px"/></a></td>
                        </tr>
                    </pre:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-md-12">
            <div class=well align="center">
                <!-- Printing the Records information -->
                <p style="font-weight: bolder">
                    ${personDataPaginationForm.currentPage} Of ${personDataPaginationForm.noOfPages} Pages,
                    Showing ${personDataPaginationForm.noOfRecords} Records
                </p>
                &lt;%&ndash;Page ${currentPage} Of ${noOfPages} Pages with Total Of ${noOfRecords} Records <br>&ndash;%&gt;
            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-md-12">
            <div class=class="pagination" align="center">
                &lt;%&ndash;For displaying Previous link except for the 1st page &ndash;%&gt;
                <pre:if test="${personDataPaginationForm.currentPage != 1}">
                    <td>
                        <a href="${pageContext.request.contextPath}/personsPagination.do?page=${personDataPaginationForm.currentPage - 1}">Previous</a>
                    </td>
                </pre:if>
                &nbsp;&nbsp; | &nbsp;&nbsp;
                <pre:if test="${personDataPaginationForm.currentPage lt personDataPaginationForm.noOfPages}">
                    <td>
                        <a href="${pageContext.request.contextPath}/personsPagination.do?page=${personDataPaginationForm.currentPage + 1}">Next</a>
                    </td>
                </pre:if>
            </div>
        </div>
    </div>
--%>

<hr>
</div>
</body>
</html>
