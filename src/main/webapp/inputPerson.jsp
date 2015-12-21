<!DOCTYPE html>
<!-- Author : Nitin Kumar Chaurasia
Date : Dec 17 2015
Project : Done as a part of the Training given at SynergisticIT
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<%-- For Spring Form--%>
<%@taglib prefix="nitin" uri="http://www.springframework.org/tags/form" %>

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

<!--Using Spy Scroll for in the body element (CSS Customised in myCustomCSS)-->
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
        <nitin:form class="form-horizontal" action="uploadPersonData.do" method="post" commandName="cform">
            <fieldset>
                <!-- Form Name -->

                <legend class="text-primary"> Enter Persons Details </legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Login
                        Name</label>
                    <div class="col-md-4">
                        <input id="textinput" name="email" type="text"
                               placeholder="email id" class="form-control input-md" required="">
                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="passwordinput">Password</label>
                    <div class="col-md-4">
                        <input id="passwordinput" name="password" type="text"
                               placeholder="Enter Password" class="form-control input-md"
                               required="">
                    </div>
                </div>

                <!-- Date input-->
                <div class="form-group">
                    <label class="col-md-4 control-label">Date Of Birth</label>
                    <div class="col-md-4">
                        <input
                                name="dob"
                                type="date" class="form-control"
                                placeholder="MM/DD/YYYY">
                    </div>
                </div>

                <!-- Time input-->
                <div class="form-group">
                    <label class="col-md-4 control-label">
                        Time Of Birth</label>
                    <div class="col-md-4">
                        <input id="reserveTime" name="tob" type="time"
                               placeholder="HH:MM" class="form-control input-md" required="">
                    </div>
                </div>


                <!--  Multiple Box -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="selectmultiple">Select Country</label>
                    <div class="col-md-4">
                        <select id="selectmultiple" name="country"
                                class="form-control" multiple="multiple">
                            <option value="1">India</option>
                            <option value="2">USA</option>
                            <option value="6">Japan</option>
                            <option value="4">China</option>
                            <option value="5">Austria</option>
                            <option value="3">Iran</option>
                        </select>
                    </div>
                </div>

                <!-- File Button Not for this project -->

                <!-- Select Basic -->
                <div class="form-group">
                    <label class="col-md-4 control-label">
                        Select Ethnicity
                    </label>
                    <div class="col-md-4">
                        <select id="selectbasic" name="ethnicity" class="form-control">
                            <option value="1">American Indian or Alaska Native</option>
                            <option value="2">Asian</option>
                            <option value="3">Black or African American</option>
                            <option value="4">Native Hawaiian or Other Pacific Islander</option>
                            <option value="5">White </option>
                        </select>
                    </div>
                </div>

                <!-- Multiple Radios -->
                <div class="form-group">
                    <label class="col-md-4 control-label"> Happy to be Here? </label>
                    <div class="col-md-4">
                        <div class="radio">
                            <label for="radios-0">
                                <input type="radio" name="isHappy"
                                       id="radios-0" value="1" checked="checked"> YES
                            </label>
                        </div>
                        <div class="radio">
                            <label for="radios-1"> <input type="radio" name="isHappy"
                                                          id="radios-1" value="2"> NO
                            </label>
                        </div>
                    </div>
                </div>

                <!-- Button (Double) -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="button1id">Double
                        Button</label>
                    <div class="col-md-8">
                        <button id="button1id" name="button1id" class="btn btn-success"> Submit </button>
                        <button id="button2id" name="button2id" class="btn btn-danger"> Cancel</button>
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
                    Spring MVC Training Learning Project, <br>Project Developed as a part of
                    Training
                </p>
            </div>
            <div class="col-sm-6">
                <h1>Footer</h1>
                <p>
                    Icon made by <a href="http://www.freepik.com" title="Freepik">Freepik</a> from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed under <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0">CC BY 3.0</a>
                </p>
            </div>
        </div>
    </div>
</footer>
</body>
</html>