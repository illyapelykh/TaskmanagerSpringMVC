<%@include file="templates/header.jsp"%>


<sf:form action="${pageContext.request.contextPath}/createUser"
	method="post" modelAttribute="newUser">
	<table>
		<tr>
			<td>User role:</td>
			<td><select name="userStatus">
					<c:forEach items="${status}" var="status">
						<option value="${status}">${status}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>User name:</td>
			<td><input type="text" name="username" required="required"></td>
			<td><sf:errors path="username"></sf:errors></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="text" name="password" required="required"></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="userEmail" required="required"></td>
			<td><sf:errors path="userEmail"></sf:errors></td>
		</tr>
		<tr>
			<td>User full name:</td>
			<td><input type="text" name="userFullName" required="required"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="save user"></td>
		</tr>
		<tr>
			<td><input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}"></td>
		</tr>
	</table>
</sf:form>

</body>
</html>