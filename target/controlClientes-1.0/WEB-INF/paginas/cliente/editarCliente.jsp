<%-- 
    Document   : editarCliente
    Created on : 28-08-2020, 11:01:35
    Author     : Carlos
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Cliente</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <!-- Iconos de Font Awesome -->
        <script src="https://kit.fontawesome.com/a03d9c12dd.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <!-- Se incluye el cabecero -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"></jsp:include>

            <!-- Formulario de actualizacion -->
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=actualizar&idCliente=${cliente.idCliente}"
              method="POST" class="was-validated">
            <!-- Se incluye barra de navegacion -->
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"></jsp:include> 

                <section id="details">
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="card">
                                    <div class="card-header">
                                        <h5>Editar Cliente</h5> 
                                    </div>
                                    
                                    <div class="card-body">
                                        <div class="form-group">
                                            <label for="nombre">Nombre</label>
                                            <input id="nombre" type="text" class="form-control" name="nombre" value="${cliente.nombre}" required>
                                        </div>   
                                        <div class="form-group">
                                            <label for="apellido">Apellido</label>
                                            <input id="apellido" type="text" class="form-control" name="apellido" value="${cliente.apellido}" required>
                                        </div> 
                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <input id="email" type="email" class="form-control" name="email" value="${cliente.email}" required>
                                        </div> 
                                        <div class="form-group">
                                            <label for="telefono">Telefono</label>
                                            <input id="telefono" type="tel" class="form-control" name="telefono" value="${cliente.telefono}" required>
                                        </div> 
                                        <div class="form-group">
                                            <label for="saldo">Saldo</label>
                                            <input id="saldo" type="number" class="form-control" name="saldo" value="${cliente.saldo}" step="any" required>
                                        </div> 
                                    </div>
                                </div>                             
                            </div>
                        </div>
                    </div>
                </section>
            </form>

        <!-- Se incluye pie de pagina -->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"></jsp:include>
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>

