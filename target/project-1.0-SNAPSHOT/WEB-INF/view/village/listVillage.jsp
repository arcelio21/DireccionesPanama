<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Corregimientos disponibles</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="container">

    <div id="headBtn" class="col-10 mb-3">
        <h1>Lista de Corregimientos</h1>
        <a class="btn btn-outline-secondary mb-3" href="${pageContext.request.contextPath}/index.jsp">Menu Principal</a>
        <a href="new"  class="btn btn-success mb-3">Agregar nuevo</a>
    </div>

    <div id="table" class="table-responsive col-10">
        <%@include file="template/tableVillage.jsp"%>
    </div>
</body>
</html>
