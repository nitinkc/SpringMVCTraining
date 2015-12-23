<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="pre"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Details of all the Persons</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!--  border style Example css -->
<style type="text/css">
.bs-example {
	margin: 20px;
}
</style>

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-default navbar-inverse" role="navigation">
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">

						</ul>
						<form class="navbar-form navbar-left" role="search"
							action="searchDb.do" method="post">
							<div class="form-group">
								<select name="column">
									<option value="UID">UID</option>
									<option value="email">email</option>
									<option value="country">country</option>
								</select> <input type="text" class="form-control" name="searchString" />
							</div>
							<button type="submit" class="btn btn-default">Submit</button>


						</form>
					</div>

				</nav>
			</div>
		</div>
	</div>

	<div class="content-section text-center" id="introduction">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<img src="img/flags_medium/India.png" />
				</div>
			</div>
		</div>
	</div>

	<div class="bs-example">
		<table class="table table-bordered" style="width: 80%">
			<thead>
				<tr>
					<!-- 					<th>SNo</th>
 -->
					<th>UID</th>
					<th>Email</th>
					<th>password</th>
					<th>DOB</th>
					<th>TOB</th>
					<th>Country</th>
					<th>Ethinicity</th>
					<th>isHappy?</th>
					<!-- <th>Entry Date</th> -->
					<th>Image</th>
				</tr>
			</thead>
			<tbody>

				<pre:forEach items="${personForms}" var="item" varStatus="sno">
					<tr>
						<%-- 						<td>${sno.count}</td>
 --%>
						<td>${item.UID}</td>
						<td>${item.email}</td>
						<td>${item.password}</td>
						<td>${item.dob}</td>
						<td>${item.tob}</td>
						<td>${item.country}</td>
						<td>${item.ethinicity}</td>
						<td>${item.isHappy}</td>
						<%--  <td>${item.entryDate}</td> --%>
						<td><img src="findImageByUID.do?uId=${sno.count}"
							style="width: 60px;" class="img-circle"></td>

						<td><a href="editPersonByUID.do?uId=${item.UID}"> <img
								src="img/edit.png" style="height: 30px; width: 30px" />
						</a> &nbsp;&nbsp; <a href="deletePersonByUID.do?uId=${item.UID}"><img
								src="img/delete.png" style="height: 30px; width: 30px" /></a></td>
					</tr>
				</pre:forEach>
			</tbody>
		</table>

		<%--For displaying Previous link except for the 1st page --%>
		<pre:if test="${currentPage != 1}">
			<td><a href="personsPagination.do?page=${currentPage - 1}">Previous</a></td>
		</pre:if>

		<%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
		<table class="table table-bordered" border="1" cellpadding="5" cellspacing="5">
			<tr>
				<pre:forEach begin="1" end="${noOfPages}" var="i">
					<pre:choose>
						<pre:when test="${currentPage eq i}">
							<td>${i}</td>
						</pre:when>
						<pre:otherwise>
							<td><a href="personsPagination.do?page=${i}">${i}</a></td>
						</pre:otherwise>
					</pre:choose>
				</pre:forEach>
			</tr>
		</table>

		<%--For displaying Next link --%>
		<c:if test="${currentPage lt noOfPages}">
			<td><a href="personsPagination.do?page=${currentPage + 1}">Next</a></td>
		</c:if>
	</div>
</body>
</html>
