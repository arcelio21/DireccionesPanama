<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Distritos</title>
        <meta name="viewport" content="width-device-width, initial-scale-1.0" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body >

        <div class="container">

            <div class="row">
                <div class="col col-xs-12 col-sm-12">
                    <h1>Lista de distritos</h1>
                    <a class="btn btn-outline-secondary mb-3" href="${pageContext.request.contextPath}/index.jsp">Menu Principal</a>
                    <a href="new"  class="btn btn-success mb-3">Agregar nuevo</a>
                </div>


            </div>

            <div class="row">
                <div class="col col-xs-12 col-sm-12">
                    <div class="table-responsive">
                        <%@include file="template/tableDistrict.jsp"%>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>
