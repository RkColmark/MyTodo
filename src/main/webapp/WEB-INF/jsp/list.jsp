<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>Your todos are</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td><fmt:formatDate value="${todo.date}" pattern="dd/MM/yyyy"/></td>
						
						<td><a type="button" class="btn btn-success"
							href="/showUpdate?id=${todo.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete?id=${todo.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add">Add a Todo</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>