package dominio;

/**
 * Clase Cliente, mapea la tabla Cliente. 27_08_2020
 *
 * @author Carlos
 */
public class Cliente {

    private int idCliente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private double saldo;

    /**
     * Constructor sin parametros
     */
    public Cliente() {
    }

    /**
     * Constructor para seleccionar el objeto Cliente segun el idCliente
     *
     * @param idCliente
     */
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Constructor para insertar un registro de un objeto Cliente en la tabla
     * Cliente
     *
     * @param nombre
     * @param apellido
     * @param email
     * @param telefono
     * @param saldo
     */
    public Cliente(String nombre, String apellido, String email, String telefono, double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    /**
     * Constructor para actualizar un registro de un objeto Cliente en la tabla
     * Cliente
     *
     * @param idCliente
     * @param nombre
     * @param apellido
     * @param email
     * @param telefono
     * @param saldo
     */
    public Cliente(int idCliente, String nombre, String apellido, String email, String telefono, double saldo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[idCliente=").append(idCliente);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", email=").append(email);
        sb.append(", telefono=").append(telefono);
        sb.append(", saldo=").append(saldo);
        sb.append(']');
        return sb.toString();
    }
}//fin clase
