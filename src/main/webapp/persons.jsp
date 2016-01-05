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

				<pre:forEach items="${personForms}" var="item" varStatus="sno">
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
</body>
</html>
