<table class="table table-bordered">

    <thead>
    <tr class="table-success">   <th scope="col">ID</th> <th scope="col" >Corregimiento</th> <th scope="col">Distrito</th> <th scope="col">Editar</th> <th scope="col" >Eliminar</th> </tr>
    </thead>

    <tbody>
    <c:forEach var="village" items="${villages}">
        <tr>
            <th scope="row">${village.id}</th> <td>${village.name}</td> <td>${village.idDistrictfk.name}</td>

            <td><a href="edit?idVillage=${village.id}&idDist=${idDist}&idProv=${idProv}" class="btn btn-primary">Editar</a></td>

            <td ><a href="delete?idVillage=${village.id}&idDist=${idDist}&idProv=${idProv}" class="btn btn-danger" onclick="if(!confirm('¿Deseas eliminar este registro?')) return false">Eliminar</a></td>

        </tr>
    </c:forEach>
    </tbody>


</table>
