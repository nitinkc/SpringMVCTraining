<%-- The below Line sets the MIME Type of the page as plane rendering --%>
<%--<%@page contentType="text/plain; charset=ISO-8859-1" %>--%>

<%@ page contentType="text/html; charset=ISO-8859-1" %>

<html>
<head>
    <link rel="stylesheet"
          href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script
            src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="content-section text-center" id="introduction">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h2>Welcome!</h2>
            </div>
        </div>
    </div>
</div>


<div class="content-section text-center">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p>
                    <a href="searchFlag.jsp"> Search Flag </a>
                </p>

                <p>
                    <a href="uploadPersonData.do"> Input Information of a Person </a>
                </p>

                <p>
                    <a href="persons.do"> See Details (and Search) of all the Persons </a>
                </p>
                <hr>
                <p>
                    <a href="personsPagination.do"> See Details with Pagination (JSP + Servlets) </a>
                </p>
                <p> <!-- restapp/personsPaginationWithAJAX -->
                    <!-- <a href="personsWithPaginationAJAX.jsp"> See Details with Pagination (Using AJAX with jQuery) </a> -->
                    <a href="paginationAjaxFirstPage.do"> See Details with Pagination (Using AJAX with jQuery) </a>
                </p>
                <hr>
            </div>
        </div>
    </div>
</div>


<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <h2 align="center">RESTful Web Services Implemented</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <h2>
                Basics
            </h2>
            <p>
                Making a Basic Rest Call.
                <a class="btn" href="restapp/testMessage">See message from Rest Service �</a>
            </p>
            <p>
                Persons All From Resource URI
                <a class="btn" href="restapp/persons/all">persons/all �</a>
            </p>
        </div>
        <div class="col-md-4">
            <h2>
                Remaining Rest...
            </h2>
            <p>

            </p>
            <p>
                <a class="btn" href="#">View details �</a>
            </p>
        </div>
        <div class="col-md-4">
            <h2>
                SOAP
            </h2>
            <p>
            	<a class="btn" href="#">View details �</a>
            </p>
            <p>
                
            </p>
        </div>
    </div>
</body>
</html>
