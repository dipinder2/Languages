<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>languages JSP</title>
    </head>
<body>
	<table class="table">
	<tr>
		<c:forEach var="language" items="${languages}">
			<td>${language.name}</td>
			<td>${language.creator}</td>
			<td>${language.version}</td>
			<td>
				<form action="/languages/${language.id}" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <input type="submit" class="btn btn-danger" value="Delete">
				</form>
	
			<a href="/languages/${language.id}/edit" class="btn btn-link" >Edit</a>
			</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<form:form action="/languages" method="post" modelAttribute="languages1">
		  <p>
		        <form:label path="Creator">creator</form:label>
		        <form:errors path="Creator"/>
		        <form:input path="Creator"/>
		    </p>
		     <p>
		        <form:label path="name">name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="version">version</form:label>
		        <form:errors path="version"/>
		        <form:input path="version"/>
		    </p>
	    <input type="submit" value="Submit"/>
	</form:form>   
</body>
</html>



