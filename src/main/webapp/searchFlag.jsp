<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!-- isELIgnored="false" Need not be included. But in some cases, we have to explicitly mention it -->
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to the Flag Search Engine</title>
</head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12" class="well">
				<div class="jumbotron">
					<h2>Search Flag!!</h2>
					<p>
						This is an Informational Website for Displaying the Flags of all
						the Nations in the World.<br> Type in Search "India" to see
						the Map. (First letter of the nation is upperCase)
					</p>
				</div>
				<!-- action is set to .do to club it with other do methods adn method is post -->
				<form class="form-horizontal" role="form" action="searchFlag.do"
					method="post">
					<div class="form-group">

						<label for="country" class="col-sm-2 control-label">
							Country </label>
						<div class="col-sm-10">
							<!-- Should be name="country" not id!! -->
							<input type="text" class="form-control" name="country" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">

							<button type="submit" class="btn btn-default">Search</button>
						</div>
					</div>
				</form>

				Default Country Flag ............ <br />
				<div class="row">
					<div class="col-md-6">
						<img alt="MIC TESTING 1..2...3...."
							src="img/flags_medium/India.png">

						<!-- Coming from model.addAttribute -->
						<img src="${flag}" />
					</div>
					<div class="col-md-6">
						Put Some data from Wikipedia (Wikipedia API)
						<h2>${revCountryName}</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container" style="padding-top:5%">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <a href="index.jsp" class="btn btn-block active btn-lg btn-success" type="button">Go Back</a>
        </div>
    </div>
</div>

</body>
</html>