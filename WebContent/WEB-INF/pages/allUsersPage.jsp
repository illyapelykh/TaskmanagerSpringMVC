<%@include file="templates/header.jsp"%>
<table>
	<tr>
		<td class="userTable">ID</td>
		<td class="userTable">Full Name</td>
		<td class="userTable">Email</td>
		<td class="userTable">Status</td>
		<td class="userTable">Info</td>
		<td class="userTable">Task</td>
	</tr>
	<c:forEach items="${allUsers}" var="user">
		<tr class="userTable">
			<td class="userTable">${user.id}</td>
			<td class="userTable">${user.userFullName}</td>
			<td class="userTable">${user.userEmail}</td>
			<td class="userTable">${user.userStatus}</td>
			<td class="userTable"><a
				href="${pageContext.request.contextPath}/userDetails${user.id}">details</a></td>
			<td class="userTable"><a
				href="${pageContext.request.contextPath}/admin/attachTask${user.id}">attach</a></td>
		</tr>
	</c:forEach>

</table>

</body>
</html>