package proyecto.entity;

import java.sql.Date;

public class Doctor extends Empleado {
    private int cedula;
    private String especialidad;

    public Doctor() {
    }

    public Doctor(int id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
            String telefono, String correoElectronico, String usuario, String contrasenia, int numeroEmpleado,
            float salario, Date fechaIngreso, int clinica_id, int cedula, String especialidad) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, telefono, correoElectronico, usuario,
                contrasenia, numeroEmpleado, salario, fechaIngreso, clinica_id);
        this.cedula = cedula;
        this.especialidad = especialidad;
    }

    public int getCedula() {
        return this.cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getEspecialidad() {
        return this.especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    @Override
    public String toString() {
        return "{" +
            " usuario=" + super.toString() +
            " cedula='" + getCedula() + "'" +
            ", especialidad='" + getEspecialidad() + "'" +
            "}";
    }


}
