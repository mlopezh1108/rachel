package proyecto.entity;

public class Clinica {
    int id;
    private int numeroClinica;
    private String nombre;

    public Clinica() {
    }

    public Clinica(int id, int numeroClinica, String nombre) {
        this.id = id;
        this.numeroClinica = numeroClinica;
        this.nombre = nombre;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroClinica() {
        return this.numeroClinica;
    }

    public void setNumeroClinica(int numeroClinica) {
        this.numeroClinica = numeroClinica;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", numeroClinica='" + getNumeroClinica() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }
}
