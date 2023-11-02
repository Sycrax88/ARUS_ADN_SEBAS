package saludypension;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "personaBean")
@SessionScoped 
public class PersonaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final String SOLO_SE_PERMITEN_LETRAS = "Solo se permiten letras";
	private static final String SOLO_SE_PERMITEN_NUMEROS_Y_MAXIMO_10_CARACTERES = "Solo se permiten numeros y maximo 10 caracteres";
	private static final String SOLO_SE_PERMITEN_NUMEROS_LETRAS_Y_MAXIMO_14_CARACTERES = "Solo se permiten numeros, letras y maximo 14 caracteres";
	private static final String SOLO_SE_PERMITEN_NUMEROS = "Solo se permiten numeros";
	private static final String REGISTRO_EXITOSO = "El registro ha sido exitoso";
	private static final String TIPO_DOCUMENTO_INVALIDO = "Tipo de documento no válido";

	@EJB
	private PersonaServicio personaServicio;
	
	private Persona persona;
	
	private String resultado;

//	@PostConstruct
//	public void init() {
//		this.persona = new Persona();
//	}
	
	public PersonaBean() {
        persona = new Persona();
    }
	
	public Persona getPersona() {
	    return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public void tipoDocumentoSeleccionadoListener(AjaxBehaviorEvent evento) {

	}
	
	public void registrarPersona() {
		this.resultado = "";
		
		try {		
			personaServicio.registrar( this.persona );
			
			agregarMensajeInformativo(REGISTRO_EXITOSO);
		
		} catch (Exception e) {
			mostrarMensajeError(e.getMessage());
		}

	}

    public void validarNombre(String nombre) throws ValidatorException {
        nombre = nombre.replaceAll("\\s", "");
        for (int i = 0; i < nombre.length(); i++) {
            if (!Character.isLetter(nombre.charAt(i))) {
                throw new ValidatorException(new FacesMessage(SOLO_SE_PERMITEN_LETRAS));
            }
        }
    }

    public void validarNumeroDocumento(FacesContext context, UIComponent component, Object valor) throws ValidatorException {
        String numeroDocumento = (String) valor;
        
        if (persona == null || numeroDocumento == null) {
            return;
        }
        
		System.out.println(persona.getTipoDocumento());


        switch (persona.getTipoDocumento()) {
            case CC:
                validarCedulaCiudadania(numeroDocumento);
                break;
            case CE:
                validarCedulaExtranjeria(numeroDocumento);
                break;
            case RC:
                validarRegistroCivilOTarjetaIdentidad(numeroDocumento);
            case TI:
                validarRegistroCivilOTarjetaIdentidad(numeroDocumento);
                break;
            default:
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                		TIPO_DOCUMENTO_INVALIDO, null));
        }
    }

    private void validarCedulaCiudadania(String numeroDocumento) throws ValidatorException {
        if (numeroDocumento.length() > 10 || !numeroDocumento.matches("[0-9]+")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                SOLO_SE_PERMITEN_NUMEROS_Y_MAXIMO_10_CARACTERES, null));
        }
    }

    private void validarCedulaExtranjeria(String numeroDocumento) throws ValidatorException {
        if (numeroDocumento.length() > 14 || !numeroDocumento.matches("[0-9a-zA-Z]+")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                SOLO_SE_PERMITEN_NUMEROS_LETRAS_Y_MAXIMO_14_CARACTERES, null));
        }
    }

    private void validarRegistroCivilOTarjetaIdentidad(String numeroDocumento) throws ValidatorException {
        if (!numeroDocumento.matches("[0-9]+")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                SOLO_SE_PERMITEN_NUMEROS, null));
        }
    }


    public void agregarMensajeError(String mensaje) {
        resultado += mensaje + "\n";
        FacesContext.getCurrentInstance().addMessage(null, createFacesMessage(mensaje, FacesMessage.SEVERITY_ERROR));
    }

    public void agregarMensajeInformativo(String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, createFacesMessage(mensaje, FacesMessage.SEVERITY_INFO));
    }

    public void mostrarMensajeError(String mensajeExcepcion) {
        String[] mensajesExcepcion = mensajeExcepcion.split("\n");
        for (String mensaje : mensajesExcepcion) {
            FacesContext.getCurrentInstance().addMessage(null, createFacesMessage(mensaje, FacesMessage.SEVERITY_ERROR));
        }
    }

    private FacesMessage createFacesMessage(String mensaje, FacesMessage.Severity severity) {
        return new FacesMessage(severity, mensaje, null);
    }

	
}