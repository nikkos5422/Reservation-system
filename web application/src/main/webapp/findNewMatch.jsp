<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:genericpage>
	<jsp:body>
    <div class="container">
 <script>
		$(function() {
			$("#divdate").hide();
			$("#datepicker").datepicker();
		});
	</script>
  <h1>Football Match finding</h1>
   <form class="form-horizontal" id="search-form">
    		<h2>Select your city</h2>
			
			 
				<select name="cities" id="selectedCity">
    					<c:forEach items="${cities}" var="city">
        					<option><c:out value="${city}" /></option>
    					</c:forEach>
				</select>
				<button type="submit" id="bth-search" class="btn btn-primary btn-sm">
					Searching!
             	</button>
   </form>

<div class="container">
	<div class="row">
		<div class="col-sm-6">
			<div class="row" id="feedback_for_Grounds"></div>
  		</div>
  		<div class="col-sm-6">
    			<div id="divdate">Date: 
    				<input type='text' id='datepicker' />
             	<input type="button" Value="Sort" onclick="SortByDate()" />
             </div>
             <div id="feedback_for_Matches"></div>
  		</div>
  
	</div> 
</div>


</div>
  </jsp:body>
</t:genericpage>

<script type="text/javascript" src="resources/js/getMatches.js"></script>
<script type="text/javascript" src="resources/js/grounds_searching.js"></script>

