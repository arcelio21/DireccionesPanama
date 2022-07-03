
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fomr" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Listar Provincias</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body class="container">
    <h1>Lista de provincias</h1>

    <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-outline-secondary mb-3">Menu Principal</a>
    <a class="btn btn-success mb-3" href="nuevo">Agregar Nuevo</a>

   <div class="table-responsive">
       <table class="table table-bordered">
           <caption>Provincias disponibles</caption>
           <tr class="table-success"> <th scope="col">ID</th> <th scope="col">Nombre</th> <th scope="col">Distritos</th> <th scope="col">Editar</th> <th scope="col">Eliminar</th> </tr>
           <c:forEach var="province" items="${provinces}">
               <tr>
                   <th scope="row">${province.id}</th><td>${province.name}</td>

                   <!--DEFINIENDO URL PARA VER DISTRITOS DE CADA PROVINCIA-->
                   <c:url var="filter" value="/districts/filterProvince" >
                       <c:param name="id" value="${province.id}" />
                   </c:url>
                   <td><a href="${filter}" title="Ver distritos de esta provincia" >
                       <!--ICONO DE VER--------------------------------------------------------------------------------------->
                       <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="GREEN"
                            stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-eye">
                           <path d="M1 12s4-8 11-8 11 8 11 8-4 8-11 8-11-8-11-8z"></path>
                           <circle cx="12" cy="12" r="3"></circle>
                       </svg>
                       <!--ICONO DE VER--------------------------------------------------------------------------------------->
                   </a> </td>
                   <!--DEFINIENDO URL UPDATE-->
                   <c:url var="urlUpdate" value="update">
                        <c:param name="id" value="${province.id}" />
                   </c:url>

                    <td><a href="${urlUpdate}" class="btn btn-primary">Editar</a></td>

                   <!--DEFINIENDO URL DE ELIMINACION-->
                   <c:url var="urlDelete" value="delete">
                       <c:param name="id" value="${province.id}" />
                   </c:url>


                   <th ><a href="${urlDelete}" class="btn btn-danger" onclick="if(!confirm('¿Deseas eliminar este registro?')) return false">Eliminar</a></th>
               </tr>
           </c:forEach>
       </table>
   </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
