package proyecto.entity;

import java.sql.Date;

public class Administrador extends Empleado {
    private int oficina;

    public Administrador() {
    }

    public Administrador(int id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
            String telefono, String correoElectronico, String usuario, String contrasenia, int numeroEmpleado,
            float salario, Date fechaIngreso, int clinica_id, int oficina) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, telefono, correoElectronico, usuario,
                contrasenia, numeroEmpleado, salario, fechaIngreso, clinica_id);
        this.oficina = oficina;
    }

    public int getOficina() {
        return this.oficina;
    }

    public void setOficina(int oficina) {
        this.oficina = oficina;
    }
    
}
