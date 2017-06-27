<%@include file="templates/header.jsp"%>

<h1>Assign task to ${user.userFullName}</h1>

<form
	action="${pageContext.request.contextPath}/admin/userAttachTaskPage${user.id}"
	method="post">
	<input type="text" name="taskTitle" required="required"
		placeholder="Task Title"> <input type="text"
		name="taskDescription" required="required"
		placeholder="Task Description"> <input type="date"
		name="deadlineDate" required="required" placeholder="Deadline Date">
	<input type="submit" value="Attach Task"> <input type="hidden"
		name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</body>
</html>