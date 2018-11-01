<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<t:genericpage>
	<jsp:body>
<div class="container">

    <form method="POST" action="${contextPath}/login"
				class="form-signin">
        <h1>Sign in</h1>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" placeholder="Username"
						autofocus="true" class="form-control" />
            <input name="password" type="password" class="form-control"
						placeholder="Password" />
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />

            <button class="btn btn-lg btn-primary btn-block"
						type="submit">Sign In</button>            
        </div>

    </form>

</div>
  </jsp:body>
</t:genericpage>
