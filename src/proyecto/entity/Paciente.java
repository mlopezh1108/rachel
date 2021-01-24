package proyecto.entity;

import java.sql.Date;

public class Paciente extends Persona {
    private int numeroPaciente;

    public Paciente() {
    }

    public Paciente(int id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
            String telefono, String correoElectronico, String usuario, String contrasenia, int numeroPaciente) {
        super(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, telefono, correoElectronico, usuario,
                contrasenia);
        this.numeroPaciente = numeroPaciente;
    }

    public int getNumeroPaciente() {
        return this.numeroPaciente;
    }

    public void setNumeroPaciente(int numeroPaciente) {
        this.numeroPaciente = numeroPaciente;
    }


    @Override
    public String toString() {
        return "{" +
            "usuario='" + super.toString() + "'" +
            " numeroPaciente='" + getNumeroPaciente() + "'" +
            "}";
    }    
}
