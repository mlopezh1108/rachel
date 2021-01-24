package proyecto.entity;

public class Direccion {
    private int id;
    private String calle;
    private String numeroExterior;
    private String NumeroInterior;
    private String colonia;
    private int codigoPostal;
    private String delegacionMunicipio;
    private String estado;
    private int persona_id;

    public Direccion() {
    }

    public Direccion(int id, String calle, String numeroExterior, String NumeroInterior, String colonia, int codigoPostal,
            String delegacionMunicipio, String estado, int persona_id) {
        this.id = id;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.NumeroInterior = NumeroInterior;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.delegacionMunicipio = delegacionMunicipio;
        this.estado = estado;
        this.persona_id = persona_id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public String getCalle() {
        return this.calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return this.numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return this.NumeroInterior;
    }

    public void setNumeroInterior(String NumeroInterior) {
        this.NumeroInterior = NumeroInterior;
    }

    public String getColonia() {
        return this.colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDelegacionMunicipio() {
        return this.delegacionMunicipio;
    }

    public void setDelegacionMunicipio(String delegacionMunicipio) {
        this.delegacionMunicipio = delegacionMunicipio;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPersona_id() {
        return this.persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }
     

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", calle='" + getCalle() + "'" +
            ", numeroExterior='" + getNumeroExterior() + "'" +
            ", NumeroInterior='" + getNumeroInterior() + "'" +
            ", colonia='" + getColonia() + "'" +
            ", codigoPostal='" + getCodigoPostal() + "'" +
            ", delegacionMunicipio='" + getDelegacionMunicipio() + "'" +
            ", estado='" + getEstado() + "'" +
            ", persona_id='" + getPersona_id() + "'" +
            "}";
    }
    
}