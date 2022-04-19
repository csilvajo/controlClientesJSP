package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Clase Conexion. 27_08_2020. Establece la conexion a la BD con un pool de 50
 * conexiones.
 *
 * @author Carlos
 */
public class Conexion {
       
    //variables de conexion a la BD
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    //private static final String JDBC_URL = "jdbc:mysql://node5062-control-clientes.sp.skdrive.net:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "admin";
    //private static final String JDBC_PASS = "P2PzG7RRcF";
    private static BasicDataSource ds;

    /**
     * Metodo que establece la conexion a la BD
     *
     * @return
     */
    public static DataSource getDataSource() {
        if (ds == null) {
            ds = new BasicDataSource();
            ds.setUrl(JDBC_URL);
            ds.setUsername(JDBC_USER);
            ds.setPassword(JDBC_PASS);
            ds.setInitialSize(50);//pool de conexiones, 50 conexiones
        }
        return ds;
    }//fin metodo

    /**
     * Metodo para obtener una conexion a la BD a partir del metodo
     * getDataSource
     *
     * @return
     * @throws java.sql.SQLException
     */
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }//fin metodo

    /**
     * Metodo que cierra el ResultSet
     *
     * @param rs
     */
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }//fin metodo

    /**
     * Metodo que cierra el PreparedStatement
     *
     * @param psmt
     */
    public static void close(PreparedStatement psmt) {
        try {
            psmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }//fin metodo

    /**
     * Metodo que cierra la conexion a la BD
     *
     * @param conn
     */
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }//fin metodo
}//fin clase
