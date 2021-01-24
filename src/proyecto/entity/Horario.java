package proyecto.entity;

import java.sql.Time;

public class Horario {
    private int id;
    private Time horaInicio;
    private Time horaTermino;
    private int doctor_id;

    public Horario() {
    }

    public Horario(int id, Time horaInicio, Time horaTermino, int doctor_id) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.doctor_id = doctor_id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getHoraInicio() {
        return this.horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraTermino() {
        return this.horaTermino;
    }

    public void setHoraTermino(Time horaTermino) {
        this.horaTermino = horaTermino;
    }

    public int getDoctor_id() {
        return this.doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", horaInicio='" + getHoraInicio() + "'" +
            ", horaTermino='" + getHoraTermino() + "'" +
            ", doctor_id='" + getDoctor_id() + "'" +
            "}";
    }

}