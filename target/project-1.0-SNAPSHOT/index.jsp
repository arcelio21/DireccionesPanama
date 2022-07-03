<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Inicio</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body class="container">

        <div class="row mb-3 text-center">
            <h1>Bienvenido</h1>
        </div>
        <div class="row">

            <!--CARD DE PROVINCIAS-->
            <div class="col col-sm sm-ml-3">
                <div class="card" style="width:18rem">
                    <img src="${pageContext.request.contextPath}/resources/img/provinces.png" class="card-img-top"  alt="Provincias de Panama"/>
                    <div class="card-body">
                        <h5 class="card-title">Provincias de Panama</h5>
                        <p class="card-text">Puedes ver las diferentes provincias de la republica Panama que se encuentran en nuestra base de datos</p>
                        <a href="provinces/list">Ver</a>
                    </div>
                </div>
            </div>

            <!--CARD DE DISTRITOS-->
            <div class="col col-sm sm-ml-3 ">
                <div class="card" style="width:18rem">
                    <img src="${pageContext.request.contextPath}/resources/img/districts.png" class="card-img-top"  alt="Distritos de Panama"/>
                    <div class="card-body">
                        <h5 class="card-title">Distritos de Panama</h5>
                        <p class="card-text">Puedes ver las diferentes distritos de la republica Panama que se encuentran en nuestra base de datos</p>
                        <a href="districts/list">Ver</a>
                    </div>
                </div>

            </div>

            <!--CARD DE CORREGIMIENTOS-->
            <div class="col col-sm sm-ml-3 ">

                <div class="card" style="width:18rem">
                    <img src="${pageContext.request.contextPath}/resources/img/villages.png" class="card-img-top"  alt="Corregimientos de Panama"/>
                    <div class="card-body">
                        <h5 class="card-title">Corregimientos de Panama</h5>
                        <p class="card-text">Puedes ver las diferentes corregimientos de la republica Panama que se encuentran en nuestra base de datos</p>
                        <a href="village/list">Ver</a>
                    </div>
                </div>

            </div>

        </div>




        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>
