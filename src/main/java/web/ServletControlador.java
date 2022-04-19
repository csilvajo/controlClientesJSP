package web;

import datos.ClienteDAO;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Clase ServletControlador. Contiene metodos para controlar el flujo entre la
 * capa de la vista y la capa de la base de datos 27_08_2020
 *
 * @author Carlos
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    /**
     * Metodo que ejecuta la accion de listar los clientes, enviandolas al JSP
     * clientes
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void accionListar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //se crea una lista de clientes
        List<Cliente> listaClientes = new ClienteDAO().listar();
        //se indica la sesion como alcance, para tener una mayor duracion la informacion que se comparte en la pagina clientes.jsp
        HttpSession sesion = request.getSession();
        //se setean los atributos de la sesion
        sesion.setAttribute("listaClientes", listaClientes);
        sesion.setAttribute("cantidadClientes", listaClientes.size());
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(listaClientes));
        //se envia la respuesta, actualizando el navegador, con la pagina que tiene el mantenedor de clientes (clientes.jsp)
        response.sendRedirect("clientes.jsp");
        //mensaje de control en consola
        System.out.println("Paso por accionListar()");
    }//fin metodo

    /**
     * Metodo que devuelve la suma de los saldos de todos los clientes
     *
     * @param listaClientes
     * @return el saldo total de los clientes
     */
    private double calcularSaldoTotal(List<Cliente> listaClientes) {
        double saldoTotal = 0;
        //se obtiene el valor de saldo de cada Cliente, iterando la lista de Clientes
        for (Cliente objCliente : listaClientes) {
            saldoTotal += objCliente.getSaldo();
        }       
        return saldoTotal;
    }//fin metodo

    /**
     * Metodo que inserta un registro de cliente
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //se recogen los valores entregados por la pagina agregarCliente.jsp
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        /*
           debido a que getParameter no acepta double, se captura en cadena de texto
           luego se asigna a una variable double, despues de validar que no sea un valor nulo
        */
        String saldoTexto = request.getParameter("saldo");
        double saldoDouble = 0;
        if (saldoTexto != null && !"".equals(saldoTexto)) {
            saldoDouble = Double.parseDouble(saldoTexto);            
        }
        //se crea el objeto Cliente
        Cliente objCliente = new Cliente(nombre, apellido, email, telefono, saldoDouble);
        //se registra el objeto Cliente en la tabla Cliente
        int registrosModificados = new ClienteDAO().insertar(objCliente);
        //finalmente se redirige a la accion por defecto (listar los clientes en el mantenedor)
        this.accionListar(request, response);
    }//fin metodo

    /**
     * Metodo que actualiza un registro de cliente
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void actualizarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //se recogen los valores entregados por la pagina editarCliente.jsp
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        //debido a que getParameter no acepta double, se captura en cadena de texto
        //luego se asigna a una variable double, despues de validar que no sea un valor nulo 
        String saldoTexto = request.getParameter("saldo");        
        double saldoDouble = 0;

        if (saldoTexto != null && !"".equals(saldoTexto)) {
            saldoDouble = Double.parseDouble(saldoTexto);           
        }
        //se crea el objeto Cliente
        Cliente objCliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldoDouble);
        //se actuala el objeto Cliente en la BD
        int registrosModificados = new ClienteDAO().actualizar(objCliente);
        //se redirige a la accion por defecto (listar los clientes en el mantenedor)
        this.accionListar(request, response);
    }//fin metodo

    /**
     * Metodo que elimina un registro de cliente
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //se recogen los valores entregados por la pagina editarCliente.jsp
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        //se crea el objeto Cliente
        Cliente objCliente = new Cliente(idCliente);
        //se elimina el objeto Cliente en la BD
        int registrosModificados = new ClienteDAO().eliminar(objCliente);
        //se redirige a la accion por defecto (listar los clientes en el mantenedor)
        this.accionListar(request, response);
    }//fin metodo

    /**
     * Metodo que selecciona un objeto Cliente para luego ser editado
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void seleccionaCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //se recogen los valores entregados por la pagina clientes.jsp
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));       
        //se recupera el objeto Cliente con el id proporcionado        
         Cliente objCliente = new ClienteDAO().seleccionar(new Cliente(idCliente));
        //se agrega el alcance 
        request.setAttribute("cliente", objCliente);
        //se define la pagina JSP para editar el Cliente
        String editarJSP = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        //se envia la informacion a la pagina jsp que actualizara el registro 
        request.getRequestDispatcher(editarJSP).forward(request, response);        
    }//fin metodo

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //se recogen las peticiones enviandas por la vista
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.seleccionaCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.accionListar(request, response);
            }
        } else {
            this.accionListar(request, response);
        }
    }//fin metodo

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //se recogen las peticiones enviandas por la vista
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "actualizar":
                    this.actualizarCliente(request, response);
                    break;
                default:
                    this.accionListar(request, response);
            }
        } else {
            this.accionListar(request, response);
        }       
    }//fin metodo

}//fin clase
