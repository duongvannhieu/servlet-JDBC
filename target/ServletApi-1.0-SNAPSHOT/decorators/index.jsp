<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 20/10/2021
  Time: 10:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Shop Homepage</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="<c:url value="/template/web/assets/favicon.ico"/>" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="<c:url value="/template/web/css/styles.css"/>" rel="stylesheet" />
</head>
    <body>
        <%--Navigation--%>
        <%@ include file="/common/web/header.jsp"%>


        <dec:body/>

        <%--Footer--%>
        <%@ include file="/common/web/footer.jsp"%>

    </body>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="<c:url value="/template/web/js/scripts.js"/> "></script>
</html>
