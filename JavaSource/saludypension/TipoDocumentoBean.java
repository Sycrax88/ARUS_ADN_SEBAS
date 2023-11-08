package saludypension;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="tipoDocumentoBean")
@RequestScoped
public class TipoDocumentoBean {
	
	private List<TipoDocumento> tiposDocumentos;
	
	
	public TipoDocumentoBean() {
		tiposDocumentos = Arrays.asList(TipoDocumento.values());
		System.out.println(tiposDocumentos);	}


	public List<TipoDocumento> getTiposDocumentos() {
		return tiposDocumentos;
	}

	public void setTiposDocumentos(List<TipoDocumento> tiposDocumentos) {
		this.tiposDocumentos = tiposDocumentos;
	}


}
