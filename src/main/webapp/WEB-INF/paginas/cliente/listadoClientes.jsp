<%-- 
    Document   : listadoClientes
    Created on : 27-08-2020, 17:45:01
    Author     : Carlos
--%>
<!-- Se configura el la directiva para importar los tags JSTL-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"></fmt:setLocale>

<section id="clientes">
    <div class="container">
        <div class="row">
            <!-- Tabla con listado de clientes -->
            <div class="col-md-9 mb-3">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Clientes</h4> 
                    </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-sm">
                            <thead class="thead-dark">
                                <tr>
                                    <th>#</th>
                                    <th>Nombre</th>
                                    <th>Email</th>
                                    <th>Tel&eacute;fono</th>
                                    <th>Saldo</th>                                
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>                                
                                <!-- Se iteran los elementos de la lista de clientes-->
                                <c:forEach var="cliente" items="${listaClientes}" varStatus="id">                                    
                                    <tr>
                                        <td>${id.count}</td><!-- valor autoincrementable que reemplaza el idCliente -->
                                        <td>${cliente.nombre} ${cliente.apellido}</td>
                                        <td>${cliente.email}</td>
                                        <td>${cliente.telefono}</td>
                                        <td><fmt:formatNumber value="${cliente.saldo}" type="currency"/></td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.idCliente}"
                                               class="btn btn-warning btn-sm">
                                               <i class="fa fa-pencil"></i> Editar
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>                           
                            </tbody>
                        </table>                        
                    </div>
                </div>
            </div> 
            <!-- Fin Tabla con listado de clientes-->
            <!-- Tarjetas para los totales -->
            <div class="col-md-3">
                <div class="card text-center bg bg-success text-white mb-3">
                    <div class="card-body">
                        <h5>Saldo Total</h5>
                        <h4 class="diplay-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency"></fmt:formatNumber>
                        </h4>
                    </div>
                </div> 

                <div class="card text-center bg bg-primary text-white mb-3">
                    <div class="card-body">
                        <h5>Cantidad de Clientes</h5>
                        <h4 class="diplay-4">
                            <i class="fas fa-users"></i> ${cantidadClientes}
                        </h4>
                    </div>
                </div> 
            </div>
            <!-- Fin Tarjetas para los totales -->
        </div> 
    </div>
</section>
<!-- Agregar cliente MODAL (ventana emergente)-->
<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"/>

