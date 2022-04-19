<%-- 
    Document   : agregarCliente
    Created on : 27-08-2020, 18:47:41
    Author     : Carlos
--%>

<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input id="nombre" type="text" class="form-control" name="nombre" required>
                    </div>   
                    <div class="form-group">
                        <label for="apellido">Apellido</label>
                        <input id="apellido" type="text" class="form-control" name="apellido" required>
                    </div> 
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input id="email" type="email" class="form-control" name="email" required>
                    </div> 
                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input id="telefono" type="tel" class="form-control" name="telefono" required>
                    </div> 
                    <div class="form-group">
                        <label for="saldo">Saldo</label>
                        <input id="saldo" type="number" class="form-control" name="saldo" step="any" required>
                    </div> 
                </div>
                <div class="modal-footer">
                    <button class="btn btn-success" type="submit">Guardar</button>
                </div>
            </form>
        </div>        
    </div>
</div>