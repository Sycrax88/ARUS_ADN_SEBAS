package saludypension;

import javax.ejb.Stateless;

@Stateless
public class PersonaServicio {

	public void registrar(Persona persona) {
		System.out.println("Sebas");
		System.out.println(persona.getNumeroDocumento());
		System.out.println(persona.getTipoDocumento());
		
		if (persona.getTipoDocumento().equals(TipoDocumento.CC)) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
	}
}
