<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Distritos</title>
        <meta name="viewport" content="width-device-width, initial-scale-1.0" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>

    <body class="container">

        <div class="headBtn">
            <h1>Lista de distritos</h1>
            <a class="btn btn-warning mb-3" href="${pageContext.request.contextPath}/provinces/list">
                <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                    <path fill="currentColor" d="M2,12A10,10 0 0,1 12,2A10,10 0 0,1 22,12A10,10 0 0,1 12,22A10,10 0 0,1 2,12M18,11H10L13.5,7.5L12.08,6.08L6.16,12L12.08,17.92L13.5,16.5L10,13H18V11Z" />
                </svg>
            </a>
            <a class="btn btn-outline-secondary mb-3" href="${pageContext.request.contextPath}/index.jsp">Menu Principal</a>
            <a href="new?idProv=${idProv}"  class="btn btn-success mb-3">Agregar nuevo</a>
        </div>

        <div class="table-responsive">

            <%@include file="template/tableDistrict.jsp"%>

        </div>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>
