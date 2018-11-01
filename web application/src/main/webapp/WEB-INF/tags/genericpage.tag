<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- All stuff for bootstrap -->
	<!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- Optional theme -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.css">


         	<!--  for ajax requsts -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

		<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
   <script src="	https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js" ></script>
   
    <!--Common style  -->
	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
	<link href='<c:url value="/resources/style.css"/>' rel="stylesheet"> 

	<!-- calendar style -->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   

   
   <!-- Latest compiled and minified JavaScript -->
<!-- f<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
 -->
</head>
  <body>
    <div id="pageheader">
    <nav class="navbar navbar-light bg-light justify-content-between" style="background-color: #000000;">
    <c:choose>
   		<c:when test="${pageContext.request.userPrincipal.name != null}">
			<a class="navbar-brand">You are logged in as ${pageContext.request.userPrincipal.name}</a>
		</c:when> 
   		<c:otherwise><a class="navbar-brand" >You are not logged in</a></c:otherwise>    
		</c:choose>
    
  <ul class="nav justify-content-end">
  <li class="nav-item">
  </li>
    <li class="nav-item"> 
    <a class="nav-link" href="/">Home</a>
  </li>
<li class="nav-item">
  <li class="nav-item"> 
    <a class="nav-link" href="/aboutUs">About Us </a>
  </li>
<li class="nav-item"> 
<c:choose>
   		<c:when test="${pageContext.request.userPrincipal.name != null}">
    <a class="nav-link" href="/NewMatch">Create new event </a>
    </c:when> 
    </c:choose>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/findNewMatch">Find event </a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/MyReservations">My Reservations <c:if test="${reservationsCount!=0 and reservationsCount!=null}">(${reservationsCount})</c:if></a>
  </li>
  <li class="nav-item">
  <button style="margin-right: 10px" type="button" class="btn btn-success" ><a href="/login" style="color:yellow">Sign in</a></button>  </li>
  <li class="nav-item">
<button style="margin-right: 10px" type="button" class="btn btn-info"><a href="/registration" style="color:yellow">Register</a></button>  </li>


	<c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <li class="nav-item">
        <button type="button" class="btn btn-warning" onclick="document.forms['logoutForm'].submit()">Logout</button></li>

    </c:if>
</ul>
</nav>
    </div>
    <div id="body">
      <jsp:doBody/>
    </div>

 </body>
</html>