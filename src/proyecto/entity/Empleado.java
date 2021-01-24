package proyecto.entity;

import java.sql.Date;

public class Empleado extends Persona {
    private int numeroEmpleado;
    private float salario;
    private Date fechaIngreso;
    private int clinica_id;

    public Empleado() {
    }

    public Empleado(int id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
            String telefono, String correoElectronico, String usuario, String contrasenia, int numeroEmpleado,
            float salario, Date fechaIngreso, int clinica_id) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, telefono, correoElectronico, usuario,
                contrasenia);
        this.numeroEmpleado = numeroEmpleado;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
        this.clinica_id = clinica_id;
    }

    public int getNumeroEmpleado() {
        return this.numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getClinica_id() {
        return this.clinica_id;
    }

    public void setClinica_id(int clinica_id) {
        this.clinica_id = clinica_id;
    }    
}
