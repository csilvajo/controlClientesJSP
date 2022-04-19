<%-- 
    Document   : botonesNavegacionEdicion
    Created on : 28-08-2020, 11:09:07
    Author     : Carlos
--%>

<section id="actions" class="py-4 mb-4 bg bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3 mb-2">
                <a href="index.jsp" class="btn btn-info btn-block">
                    <i class="fas fa-arrow-left"></i> Volver al Inicio 
                </a>
            </div> 
            
            <div class="col-md-3 mb-2">
                <button type="submit" class="btn btn-success btn-block">
                   <i class="fas fa-check"></i> Actualizar Cliente 
                </button>
            </div> 
            
            <div class="col-md-3 mb-2">
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}"
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i> Eliminar Cliente 
                </a>
            </div> 
            
        </div>
    </div>
</section>