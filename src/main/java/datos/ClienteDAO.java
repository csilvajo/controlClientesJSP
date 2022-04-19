package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;

/**
 * Clase ClienteDAO, interactua con la BD. Ejecuta metodos con sentencias SQL en
 * la tabla Cliente. 27_08_2020
 *
 * @author Carlos
 */
public class ClienteDAO {

    private static final String SQL_SELECT = "SELECT id_cliente,nombre,apellido,email,telefono,saldo FROM cliente";
    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente,nombre,apellido,email,telefono,saldo FROM cliente WHERE id_cliente=?";
    private static final String SQL_INSERT = "INSERT INTO cliente (nombre,apellido,email,telefono,saldo)VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre=?,apellido=?,email=?,telefono=?,saldo=? WHERE id_cliente=?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente=?";

    /**
     * Metodo que retorna una lista de objetos Cliente
     *
     * @return listaClientes
     */
    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Cliente objCliente = null;
        List<Cliente> listaClientes = new ArrayList<>();

        try {
            //se establece la conexion con la BD y se ejecuta la entencia SQL
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                //se iteran los registros contenidos en la tabla Cliente, recuperando los valores 
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");
                //se crea un objeto Cliente, con los registros obtenidos
                objCliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
                //se agrega el objeto Cliente a la Lista 
                listaClientes.add(objCliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //se cierran las conexiones a la BD
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return listaClientes;
    }//fin metodo

    /**
     * Metodo retorna un objeto Cliente seleccionado por id
     *
     * @param objCliente
     * @return el objCliente recuperado
     */
    public Cliente seleccionar(Cliente objCliente) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            //se establece la conexion con la BD y se ejecuta la entencia SQL
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, objCliente.getIdCliente());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                //se iteran los registros contenidos en la tabla Cliente, recuperando los valores 
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");
                //se crea un objeto Cliente, con los registros obtenidos
                objCliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);            
        } finally {
            //se cierran las conexiones a la BD
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return objCliente;
    }

    /**
     * Metodo que inserta un objeto Cliente como un registro en la tabla Cliente
     *
     * @param objCliente
     * @return cantidad de filas afectadas
     */
    public int insertar(Cliente objCliente) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int rows = 0;//cantidad de filas afectadas

        try {
            //se establece la conexion con la BD y se ejecuta la entencia SQL, con los valores de cada variable del objeto
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, objCliente.getNombre());
            pstmt.setString(2, objCliente.getApellido());
            pstmt.setString(3, objCliente.getEmail());
            pstmt.setString(4, objCliente.getTelefono());
            pstmt.setDouble(5, objCliente.getSaldo());
            rows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //se cierran las conexiones a la BD
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }//fin metodo

    /**
     * Metodo que actualiza un registro de la tabla Cliente
     *
     * @param objCliente
     * @return cantidad de filas afectadas
     */
    public int actualizar(Cliente objCliente) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int rows = 0;//cantidad de filas afectadas

        try {
            //se establece la conexion con la BD y se ejecuta la entencia SQL, con los valores de cada variable del objeto
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, objCliente.getNombre());
            pstmt.setString(2, objCliente.getApellido());
            pstmt.setString(3, objCliente.getEmail());
            pstmt.setString(4, objCliente.getTelefono());
            pstmt.setDouble(5, objCliente.getSaldo());
            pstmt.setInt(6, objCliente.getIdCliente());
            rows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //se cierran las conexiones a la BD
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }//fin metodo

    /**
     * Metodo que elimina un registro de la tabla Cliente
     *
     * @param objCliente
     * @return cantidad de filas afectadas
     */
    public int eliminar(Cliente objCliente) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int rows = 0;//cantidad de filas afectadas

        try {
            //se establece la conexion con la BD y se ejecuta la entencia SQL, segun la variable idCliente del objeto
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, objCliente.getIdCliente());
            rows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //se cierran las conexiones a la BD
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }//fin metodo

}//fin clase
