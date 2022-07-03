<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo Corregimientos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="container">
<header class="col-6 mb-3 ">
    <h1 class="">Nuevo Corregimiento</h1>
    <a class="btn btn-info mb-3" href="${pageContext.request.contextPath}/${urlReturn}">
        <svg style="width:24px;height:24px" viewBox="0 0 24 24">
            <path fill="currentColor" d="M2,12A10,10 0 0,1 12,2A10,10 0 0,1 22,12A10,10 0 0,1 12,22A10,10 0 0,1 2,12M18,11H10L13.5,7.5L12.08,6.08L6.16,12L12.08,17.92L13.5,16.5L10,13H18V11Z" />
        </svg>
    </a>
</header>
<div id="form" class="col-6 ">
    <f:form action="insert?idDist=${idDist}&idProv=${idProv}" modelAttribute="village" method="post">

        <!--ID DE CORREGIMIENTO-->
        <f:hidden path="id" id="id" />

        <!--NOMBRE DE CORREGIMIENTO-->
        <f:label path="name" cssClass="form-label" title="Nombre" />
        <f:input path="name" id="name" cssClass="form-control" /> <br/>

        <!--DISTRITOS DISPONIBLES-->
        <f:label path="idDistrictfk" cssClass="form-label">
            Distritos
        </f:label>

        <f:select path="idDistrictfk.id" id="idProv" cssClass="form-select" items="${districtsMap}" />

        <br/> <br/>

        <!--BOTON-->
        <input type="submit" value="Agregar" class="btn btn-success" />
    </f:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
