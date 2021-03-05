<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<form:form action="save" modelAttribute="todo" method="POST">
	
	<form:hidden path="id" />
		
			<table>
				<tbody>
					<tr>
						<td><label>Description</label></td>
						<td><form:input  path="description" /></td>
					</tr>
					
				
					<tr>
						<td><label>Date:</label></td>
						<td><form:input  path="date" /></td>
					</tr>
					
					<tr>
						<td><label>Add</label></td>
						<td><input type="submit" class="btn btn-success"></td>
					</tr>
		
				</tbody>
			</table>

		
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>

<