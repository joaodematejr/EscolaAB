package conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import entity.Documento;
import rn.ArquivoRN;

@FacesConverter(forClass = Documento.class)
public class DocumentoConversor implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		try {
			Long id = Long.parseLong(valor);
			ArquivoRN arquivoRN = new ArquivoRN();
			Documento documento = arquivoRN.buscarDocumentoPorID(id);
			return documento;
		} catch (NumberFormatException e) {
			return new Documento();
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {
		Documento documento = (Documento) valor;
		return documento.getId() == null ? "" : documento.getId().toString();
	}

}
