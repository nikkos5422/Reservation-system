<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:genericpage>
    <jsp:body>

<script>
  $( function() {
  $("#divdate_2").hide();
  //$("#divdate_3").hide();
    $( "#datepicker" ).datepicker();

  } );
  </script>
<h1 >Create your match</h1>
<div class="container">

    <form:form method="POST" modelAttribute="matchForm" class="form-signin">
        
        
        <spring:bind path="matchName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="matchName" class="form-control" placeholder="matchName"
                            autofocus="true"></form:input>
                               <form:errors path="matchName"></form:errors>
                </div>
        </spring:bind>
        
        <spring:bind path="capacity">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="capacity" class="form-control" placeholder="Enter size of team"></form:input>
                <form:errors path="capacity"></form:errors>
            </div>
        </spring:bind>
		<spring:bind path="entryFee">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input  type="text" path="entryFee" class="form-control" placeholder="Enter entry fee"></form:input>
                <form:errors path="entryFee"></form:errors>
            </div>
       </spring:bind>
      
      <spring:bind path="skillLevel">
  <p>Select skill level:&nbsp;<select name="skillLevel">
      <option value="BEGINNER"> BEGINNER</option>
      <option value="INTERMEDIATE">INTERMEDIATE</option>
      <option value="ADVANCED"> ADVANCED</option>
  </select></p>
</spring:bind>
        
        
        <p>Select city:&nbsp;&nbsp;<select name="cities" id="selectedCity"  onchange="testing(value);">
    					<c:forEach items="${cities}" var="city" >
        					<option  value="${city.cityName}" ><c:out value="${city.cityName}" /></option>
    					</c:forEach>
				</select></p>

        <div id="feedback_for_Grounds"></div>
        
        <!-- ground id -->
        <spring:bind path='groundNumber'>
        <div id="divdate_2">
        <form:input id="lolkin" type="text" path="groundNumber" ></form:input>
        </div>
        </spring:bind>
        <!-- date -->
        <spring:bind path='date'>
                   <p> Choose date:&nbsp; <form:input  type="text" path="date" id="datepicker"></form:input></p>      
        </spring:bind>
        <!-- Time -->
                <spring:bind path='time'>
        <label for="appt-time">Choose time:&nbsp;&nbsp;<form:input 
        id="appt-time"  value="13:30" type="time" path="time" name="appt-time" ></form:input> </label>
                </spring:bind>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Create match</button>
    </form:form>

</div>


      </jsp:body>
</t:genericpage>
<script type="text/javascript" src="resources/js/getMatches.js"></script>
<script type="text/javascript" src="resources/js/grounds_searching.js"></script>