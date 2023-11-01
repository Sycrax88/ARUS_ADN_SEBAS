package saludypension;

import java.util.Date;

public class Persona {
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String administradoraSalud;
    private Date fechaAfiliacionSalud;
    private String administradoraPension;
    private Date fechaAfiliacionPension;

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getAdministradoraSalud() {
        return administradoraSalud;
    }

    public void setAdministradoraSalud(String administradoraSalud) {
        this.administradoraSalud = administradoraSalud;
    }

    public Date getFechaAfiliacionSalud() {
        return fechaAfiliacionSalud;
    }

    public void setFechaAfiliacionSalud(Date fechaAfiliacionSalud) {
        this.fechaAfiliacionSalud = fechaAfiliacionSalud;
    }

    public String getAdministradoraPension() {
        return administradoraPension;
    }

    public void setAdministradoraPension(String administradoraPension) {
        this.administradoraPension = administradoraPension;
    }

    public Date getFechaAfiliacionPension() {
        return fechaAfiliacionPension;
    }

    public void setFechaAfiliacionPension(Date fechaAfiliacionPension) {
        this.fechaAfiliacionPension = fechaAfiliacionPension;
    }
}