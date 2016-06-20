package conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import entity.Cliente;
import entity.Contato;
import rn.ClienteRN;
import rn.ContatoRN;
@FacesConverter(forClass = Contato.class)
public class ContatoConversor implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		ContatoRN contatoRN = new ContatoRN();
		Long id = Long.parseLong(value);
		return contatoRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		Contato contato = (Contato) value;
		return contato.getNome().toString();
	}

}
