<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:genericpage>
    <jsp:body>
<h1>Your reservations</h1>



        
   <div  id="todays-table">
   <table class="table table-dark" >
  <thead>
    <tr>
      <th ></th>
      <th style="width: 35%">Match name</th>
      <th style="width: 25%" >Date</th>
      <th  style="width: 20%">Entry fee</th>
      <th style="width: 20%">Match info</th>
    </tr>
  </thead>
  <tbody>
   
     <c:forEach items="${matches}" var="match" varStatus="loop" >
      <tr>
    <th scope="row">${loop.index+1}</th>
      <td>${match.matchName}</td>
      <td>${match.date}</td>
      <td>${match.entryFee}&nbsp;&nbsp;CZK</td>
      <td ><a href="http://localhost:8080/api/showMatchInfo?id=${match.id}"> Go to</a></td>
         </tr>
      </c:forEach>

  </tbody>
</table>
</div> 




  </jsp:body>
</t:genericpage>