package proyecto.entity;

import java.sql.Date;

public class Persona {
    protected int id;
    protected String nombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected Date fechaNacimiento;
    protected String telefono;
    protected String correoElectronico;
    protected String usuario;
    protected String contrasenia;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
            String telefono, String correoElectronico, String usuario, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellidoPaterno='" + getApellidoPaterno() + "'" +
            ", apellidoMaterno='" + getApellidoMaterno() + "'" +
            ", fechaNacimiento='" + getFechaNacimiento() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", correoElectronico='" + getCorreoElectronico() + "'" +
            ", usuario='" + getUsuario() + "'" +
            ", contrasenia='" + getContrasenia() + "'" +
            "}";
    }
}
