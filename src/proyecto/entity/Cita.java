package proyecto.entity;

import java.sql.Date;
import java.sql.Time;

public class Cita {
    private int id;
    private Date fecha;
    private Time hora;


    public Cita() {
    }


    public Cita(int id, Date fecha, Time hora) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return this.hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

}
