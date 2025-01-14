<%--
  Created by IntelliJ IDEA.
  User: Nitin C
  Date: 1/4/2016
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="pre"%>

<html>
<head>
<title>Pagination Using AJAX</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
</script>

<!-- Custom styles for this Project -->
<link href="css/myStyle.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
        
        $(document).ready(function () {
            console.log(contextPath);
            
            $.getJSON(contextPath+"/restapp/personsPaginationWithAJAX", {}, function (jsonResponse) {
            	console.log(jsonResponse);
            });

            /* Setting up the previous button */
            $("#previous").click(function () {
                /* Picking up the page number */
                var page = $("#previous").attr("pageNo");
                /* TO FIX THE PREVIOUS LINK */
            });//End Previous Click

            /* Setting up the next button */
            $("#next").click(function () {
                /* Picking up the page number */
                var nPage = $("#next").attr("pageNo");

                /* Now the AJAX call is made and the response is taken as JSON */
                $.getJSON(contextPath+"/restapp/personsPaginationWithAJAX", {page: nPage}, function (jsonResponse) {
                    var tableContent = "";
                    var count = 0;

                    if (!jQuery.isEmptyObject(jsonResponse)) {
                        var itemResponse = jsonResponse["personsFormDataList"];
                        console.log(itemResponse);
                        jQuery.each(itemResponse, function (i, item) {
                            //alert(item);
                            tableContent = tableContent + "<tr><td>" + (i + 1) + 
                            "</td><td>" + item["uid"] + "</td><td>" + 
                            item["email"] + "</td><td>" + item["password"] + 
                            "</td><td>" + item["dob"] + "</td><td>" + 
                            item["tob"] + "</td><td>" + item["country"] + 
                            "</td><td>" + item["ethinicity"] + "</td><td>" + item["isHappy"] +
                            "</td><td> <img src=\"findImageByUID.do?uId=" + 
                            		item["uid"] + "\" height=\"60px;\" class=\"img-circle\"></td>"
                            tableContent = tableContent + "<td><a href=\"editPersonByUID.do?uId=" + item["uid"] + "\"><img src=\"img/edit.png\ style=\"height: 30px; width: 30p" + " /></a> &nbsp;&nbsp;<a href=\"deletePersonByUID.do?uId=" + item["uid"] + "\"><img src=\"img/delete.png\" style=\"height: 30px; width: 30px\"/></a></td></tr>";
                        });
                        //${fruitPaginationForm.currentPage lt fruitPaginationForm.noOfPages}
                        var currentPage = jsonResponse["currentPage"];
                        var noOfPages = jsonResponse["noOfPages"];
                        var recordsPerPage = jsonResponse["recordsPerPage"];
                        if (currentPage < noOfPages) {
                            $("#next").attr("pageNo", currentPage + 1);
                        } else {
                            $("#next").hide();
                        }
                        var startItem = (currentPage - 1) * recordsPerPage + 1;
                        var totalNoRecordsof = "of " + jsonResponse["noOfRecords"];
                        var endRecord = 0;
                        //
                        if (((currentPage - 1) * recordsPerPage + recordsPerPage) > totalNoRecordsof) {
                            endRecord = jsonResponse["noOfRecords"];
                        } else {
                            endRecord = (currentPage - 1) * recordsPerPage + recordsPerPage;
                        }
                        var paginationHeader = startItem + " - " + endRecord + " " + totalNoRecordsof;
                        $("#paginationHeader").html(paginationHeader);

                    } else {
                        alert("Sorry data could not be rerieved!!!!!!!");
                    }
                    $("#table-body-content").html(tableContent);
                });// End of Get JSON
            });// End of Click Next
        });//End Document Ready
    </script>
</head>

<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">

				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand"
								href="${pageContext.request.contextPath}/index.jsp">Person
								Services</a>
						</div>
						<ul class="nav navbar-nav">
							<li class="active"><a
								href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
							<li><a href="${pageContext.request.contextPath}/persons.do">See
									All Persons</a></li>
							<li><a
								href="${pageContext.request.contextPath}/uploadPersonData.do">Input
									Persons Data</a></li>
						</ul>
					</div>
				</nav>

				<div class="bs-example" align="center">
					<table class="table table-striped" class="table-responsive"
						style="width: 80%">
						<thead>
							<tr>
								<th>SNo</th>
								<th>UID</th>
								<th>Email</th>
								<th>password</th>
								<th>DOB</th>
								<th>TOB</th>
								<th>Country</th>
								<th>Ethnicity</th>
								<th>isHappy?</th>
								<th>Image</th>
							</tr>
						</thead>

						<tbody id="table-body-content">
							<pre:forEach
								items="${personDataPaginationForm.personsFormDataList}"
								var="item" varStatus="sno">
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
											src="img/edit.png" style="height: 30px; width: 30px" />
									</a> &nbsp;&nbsp; <a href="deletePersonByUID.do?uId=${item.UID}"><img
											src="img/delete.png" style="height: 30px; width: 30px" /></a></td>
								</tr>
							</pre:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>


		<%-- Printing the Data of the Total number of Records--%>
		<div class="row">
			<div class="col-md-12">
				<div class=well align="center">
					<!-- Printing the Records information -->
					<p style="font-weight: bolder">
						${personDataPaginationForm.currentPage} Of
						${personDataPaginationForm.noOfPages} Pages, Showing
						${personDataPaginationForm.noOfRecords} Records</p>
					<%--Page ${currentPage} Of ${noOfPages} Pages with Total Of ${noOfRecords} Records <br>--%>
				</div>
			</div>
		</div>

		<%-- Showing the two buttons for navigating next or Previous--%>
		<div class="row">
			<div class="col-md-12">
				<div class=class= "pagination" align="center">
					<%--For displaying Previous link except for the 1st page--%>
					<pre:if test="${personDataPaginationForm.currentPage != 1}">
						<td><a href="#" id="previous" 
						pageNo="${personDataPaginationForm.currentPage - 1}"> Previous</a>
						</td>
					</pre:if>
					&nbsp;&nbsp; | &nbsp;&nbsp;
					<pre:if
						test="${personDataPaginationForm.currentPage lt personDataPaginationForm.noOfPages}">
						<td><a href="#" id="next"
							pageNo="${personDataPaginationForm.currentPage + 1}">Next</a></td>
					</pre:if>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
