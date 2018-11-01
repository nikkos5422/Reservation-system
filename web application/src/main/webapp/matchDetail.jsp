<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:genericpage>
	<jsp:body>

<div class="container">
  		<div class="row">
  		<div class="col">
<h1 align="center">Basic info about match</h1>
<ul align="center" style="list-style-type: none;">
<li> Match name:${mName} </li>
<li> Entry fee is: ${entryFee} </li>
<li> date of match is:${date} </li>
       <h6>
							<font color="red">${error}</font>
						</h6>
</ul>
</div>
		</div>
		
  <div class="row">
    <div class="col">
<h2>First team players</h2>
<c:forEach items="${team1}" var="item">
    <tr>
      <td><c:out value="${item.username}" /></td>
							<br />
    </tr>
  </c:forEach>
             <div class="form-group ${error != null ? 'has-error' : ''}">
       <button type="submit">
							<a href="addPlayer?id=${id}&team=team_A" style="color: black">Participate for the first team </a>
						</button>
						</br>
       <span><font color="red">${errorA}</font></span>

       </div>
       
    </div>

    <div class="col">
    <h2>Second team players</h2>
    
<c:forEach items="${team2}" var="item">
    <tr>
      <td><c:out value="${item.username}" /></td>
							<br />
    </tr>
  </c:forEach>
  
       <button type="submit"> <a
							href="addPlayer?id=${id}&team=team_B" style="color: black">Participate for the second team  </a> </button>
					</br>  
</div>
   </div>
</div>

  </jsp:body>
</t:genericpage>