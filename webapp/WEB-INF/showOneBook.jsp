<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Show Book</title>
</head>
<body>
	<div class="container mt-5">
		<h1>Show Book</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Description</th>
					<th>Language</th>
					<th>Number of Pages</th>
				</tr>
			</thead>
			<tbody>
				
					<tr>
						<td>${books.id }</td>
						<td>${books.title }</td>
						<td>${books.description }</td>
						<td>${books.language }</td>
						<td>${books.numberOfPages }</td>
					</tr>
	

			</tbody>
		</table>
	</div>
</body>
</html>