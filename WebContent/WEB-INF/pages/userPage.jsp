<%@include file="templates/header.jsp"%>

<h1>${user.userFullName}</h1>
<h2>Current tasks:</h2>
<ul>
	<c:forEach items="${user.currentTasks}" var="task">
		<li>${task.deadlineDate}${task.taskTitle} <a
			href="${pageContext.request.contextPath}/taskDetails${task.id}">details</a>
		</li>
	</c:forEach>
</ul>
<form
	action="${pageContext.request.contextPath}/admin/userAttachTask${user.id}"
	method="post">
	<input type="text" name="taskTitle" required="required"
		placeholder="Task Title"> <input type="text"
		name="taskDescription" required="required"
		placeholder="Task Description"> <input type="date"
		name="deadlineDate" required="required" placeholder="Deadline Date">
	<input type="submit" value="Attach Task"> <input type="hidden"
		name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<%--
<p>
	<a href="${pageContext.request.contextPath}/admin/editUser${user.id}">
		<button>edit user data</button>
	</a>
</p>

--%>


</body>
</html>