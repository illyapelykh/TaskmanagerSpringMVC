<%@include file="templates/header.jsp"%>

<h1>${task.user.userFullName}'s:</h1>
<h2>${task.taskTitle}</h2>
<p>${task.taskDescription}</p>
<p>Finish till: ${task.deadlineDate}</p>
Current Status: ${task.taskStatus}
<form
	action="${pageContext.request.contextPath}/admin/changeTaskStatus${task.id}"
	method="post">
	<select name="status"><c:forEach items="${status}"
			var="status">
			<option value="${status}">${status}</option>
		</c:forEach></select><input type="submit" value="change status"> <input
		type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>



</body>
</html>