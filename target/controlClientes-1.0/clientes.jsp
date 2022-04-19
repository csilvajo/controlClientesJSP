<%-- 
    Document   : clientes
    Created on : 27-08-2020, 16:19:18
    Author     : Carlos
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Clientes</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <!-- Se importa CDN Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <!-- Se importan Iconos de Font Awesome -->
        <script src="https://kit.fontawesome.com/a03d9c12dd.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <!-- Se incluye el cabecero -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"></jsp:include>
        <!-- Se incluye barra de navegacion -->
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp"></jsp:include>  
        <!-- Se incluye listado de clientes -->
        <jsp:include page="/WEB-INF/paginas/cliente/listadoClientes.jsp"></jsp:include> 
        <!-- Se incluye pie de pagina -->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"></jsp:include>
        
        <!-- Se importa jQuery,Popper.js y Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
