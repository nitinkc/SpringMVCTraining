<!DOCTYPE html>
<!-- Author : Nitin Kumar Chaurasia
Date : Dec 17 2015
Project : Done as a part of the Training given at SynergisticIT
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%-- For Spring Form--%>
<%@taglib prefix="nitin" uri="http://www.springframework.org/tags/form"%>

<html>
<head lang="en">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<!-- Title on top of the Web Browser-->
<title>User Details Form</title>

<!--Icon to be displayed on the Address Bar and on top of The Web Browser-->
<%-- --%>
<link rel="shortcut icon" href="img/circuit-logo.png">
<link rel="icon" type="img/png" href="img/circuit-logo.png">

</head>

<!--Using Spy Scroll for in the body element (CSS should be Customized in myCustomCSS)-->
<body>
	<!-------------  Square Image with Brainy Quote Daily ------------->
	<div class="content-section text-center" id="introduction">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1 class="text-primary">Get Motivated</h1>
					<!--Brainy Quote insertion (Javascript from brainy Quotes.com)-->
					<p class="bg-info">
						<script type="text/javascript"
							src="http://www.brainyquote.com/link/quotebr.js"></script>
						<small><i><a
								href="http://www.brainyquote.com/quotes_of_the_day.html"
								target="_blank">more Quotes</a></i></small>
					</p>
				</div>
				<div class="col-md-6"></div>
			</div>
		</div>
	</div>

	<!-------------------------- Various Inputs ------------------------>

	<div class="content-section" id="feedback">
		<div class="container">
			<nitin:form class="form-horizontal" action="uploadPersonData.do"
				method="post" commandName="cform" enctype="multipart/form-data">
				<fieldset>
					<!-- Form Name -->
					<legend class="text-primary"> Enter Persons Details</legend>
					<!-- Text input-->
					<div class="form-group">
						<nitin:input type="hidden" path="UID" />

						<label class="col-md-4 control-label" for="textinput">Login
							Name</label>
						<div class="col-md-4">
							<nitin:input type="text" id="textinput" path="email"
								placeholder="email id" class="form-control input-md" required="" />
						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="passwordinput">Password</label>
						<div class="col-md-4">
							<nitin:input type="password" id="passwordinput" path="password"
								placeholder="Enter Password" class="form-control input-md"
								required="" />
						</div>
					</div>

					<!-- Date input-->
					<div class="form-group">
						<label class="col-md-4 control-label">Date Of Birth</label>
						<div class="col-md-4">
							<nitin:input type="date" path="dob" class="form-control"
								placeholder="MM/DD/YYYY" />
						</div>
					</div>

					<!-- Time input-->
					<div class="form-group">
						<label class="col-md-4 control-label"> Time Of Birth</label>
						<div class="col-md-4">
							<nitin:input type="time" id="reserveTime" path="tob"
								placeholder="HH:MM" class="form-control input-md" required="" />
						</div>
					</div>

					<!--  Multiple Box -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="selectmultiple">Select
							Country</label>
						<div class="col-md-4">
							<nitin:select id="selectmultiple" path="country"
								class="form-control" multiple="multiple">
								<option value="India">India</option>
								<option value="USA">USA</option>
								<option value="Japan">Japan</option>
								<option value="China">China</option>
								<option value="Austria">Austria</option>
								<option value="Iran">Iran</option>
							</nitin:select>
						</div>
					</div>

					<!-- File Button Not for this project -->

					<!-- Select Basic -->
					<div class="form-group">
						<label class="col-md-4 control-label"> Select Ethnicity </label>
						<div class="col-md-4">
							<select id="selectbasic" path="ethnicity"
								class="form-control">
								<option value="American Indian or Alaska Native">American
									Indian or Alaska Native</option>
								<option value="Asian">Asian</option>
								<option value="Black or African American">Black or
									African American</option>
								<option value="Native Hawaiian or Other Pacific Islander">Native
									Hawaiian or Other Pacific Islander</option>
								<option value="White">White</option>
							</nitin:select>
						</div>
					</div>

					<!-- Multiple Radios -->
					<div class="form-group">
						<label class="col-md-4 control-label"> Happy to be Here? </label>
						<div class="col-md-4">
							<div class="radio">
								<label for="radios-0"> <input type="radio"
										name="isHappy" id="radios-0" value="Yes" checked="checked"> YES
                                </input>
								</label>
							</div>
							<div class="radio">
								<label for="radios-1"> <input type="radio"
										name="isHappy" id="radios-1" value="No"> NO
                                                          </input>
								</label>
							</div>
						</div>
					</div>
					<!-- Upload image -->
					<div class="form-group">
						<label class="col-md-4 control-label"> Upload Image </label>
						<div class="col-md-8">
							<span class="btn btn-default btn-file"> <input type="file"
								name="image">
							</span>
						</div>
					</div>

					<!-- Button (Double) -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="button1id">Double
							Button</label>
						<div class="col-md-8">
							<!-- Type should be submit else the image is not uploading-->
							<button type="sumbit" id="button1id" name="button1id"
								class="btn btn-success">Submit</button>
							<button id="button2id" name="button2id" class="btn btn-danger">
								Cancel</button>
						</div>
					</div>

				</fieldset>
			</nitin:form>
		</div>
	</div>
	<br>
	<!--------------------- Footer  ----------------->
	<footer class="section section-primary" id="footer">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<h1>Footer</h1>
					<p>
						Spring MVC Training Learning Project, <br>Project Developed
						as a part of Training
					</p>
				</div>
				<div class="col-sm-6">
					<h1>Footer</h1>
					<p>
						Icon made by <a href="http://www.freepik.com" title="Freepik">Freepik</a>
						from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a>
						is licensed under <a
							href="http://creativecommons.org/licenses/by/3.0/"
							title="Creative Commons BY 3.0">CC BY 3.0</a>
					</p>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>