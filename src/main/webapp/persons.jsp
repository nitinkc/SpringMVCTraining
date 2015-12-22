<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="pre"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Details of all the Persons</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!--  border style Example css -->
<style type="text/css">
    .bs-example{
    	margin: 20px;
    }
</style>

</head>
<body>

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
                <td>${sno.count}</td>
                <td>${item.email}</td>
                <td>${item.password}</td>
                <td>${item.dob}</td>
                <td>${item.tob}</td>
                <td>${item.country}</td>
                <td>${item.ethinicity}</td>
                <td>${item.isHappy}</td>
               <%--  <td>${item.entryDate}</td> --%>
                <td><img src="findImageByUID.do?uId=${sno.count}" style="width: 60px;" class="img-circle"></td>
                <td>NA</td>
            </tr>
          </pre:forEach>
            
            
        </tbody>
    </table>
</div>
</body>
</html>                                		
