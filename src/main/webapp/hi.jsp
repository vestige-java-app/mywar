<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://gaellalire.fr/jsp/my" prefix = "my" %>
<HTML>
<HEAD>
<TITLE>Test</TITLE>
</HEAD>
<BODY>
	<%!int minimum(int val1, int val2) {
        if (val1 < val2)
            return val1;
        else
            return val2;
    }%>
	<%
	    int min = minimum(Integer.parseInt(request.getParameter("n1")), Integer.parseInt(request.getParameter("n2")));
	%>
	<p>
		The minimum between <c:out value="${param.n1}" /> and <c:out value="${param.n2}" /> is
		<%=min%></p>
	<p> Intern taglib call : <c:out value="${my:hello()}"/> </p>
</BODY>
</HTML>