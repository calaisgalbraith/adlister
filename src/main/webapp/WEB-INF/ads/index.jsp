<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <link rel="stylesheet" href="/main.css">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here are all the ads:</h1>

    <div class="display-cards w3-third w3-container margin-auto" style="width: 100%;">
        <c:forEach var="ad" items="${ads}">
            <div class="card" style="width: 18rem;">
                <div class="card-body">

                    <h5 class="card-title"><a href="/ads/show">${ad.title}</a></h5>
                    <a href="${pageContext.request.contextPath}/ads/show?id=${ad.id}"> <%-- Creates link to show.jsp -CG --%>
                        <h5 class="card-title">${ad.title}</h5></a>
                    <p>${ad.description}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
