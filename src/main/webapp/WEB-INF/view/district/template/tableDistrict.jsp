

<table class="table table-bordered">

    <thead>
    <tr class="table-success">   <th scope="col">ID</th> <th scope="col" > Distrito</th> <th scope="col">Provincia</th> <th scope="col">Corregimientos</th> <th scope="col">Editar</th> <th scope="col" >Eliminar</th> </tr>
    </thead>

    <tbody>
    <c:forEach var="distrito" items="${districts}">
        <tr>
            <th scope="row">${distrito.id}</th> <td>${distrito.name}</td> <td>${distrito.idProvincefk.name}</td>

            <td><a href="${pageContext.request.contextPath}/village/filterDistrict?idDist=${distrito.id}&idProv=${idProv}" title="Ver Corregimientos de este distrito" >
                <!--ICONO DE VER--------------------------------------------------------------------------------------->
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="GREEN"
                     stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-eye">
                    <path d="M1 12s4-8 11-8 11 8 11 8-4 8-11 8-11-8-11-8z"></path>
                    <circle cx="12" cy="12" r="3"></circle>
                </svg>
                <!--ICONO DE VER--------------------------------------------------------------------------------------->
            </a> </td>

            <td><a href="edit?idDistric=${distrito.id}&idProv=${idProv}" class="btn btn-primary">Editar</a></td>

            <td ><a href="delete?idDistric=${distrito.id}&idProv=${idProv}" class="btn btn-danger" onclick="if(!confirm('¿Deseas eliminar este registro?')) return false">Eliminar</a></td>

        </tr>
    </c:forEach>
    </tbody>


</table>

