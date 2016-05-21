package conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import entity.Turma;
import rn.TurmaRN;

@FacesConverter(forClass = Turma.class)
public class TurmaConversos implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		TurmaRN turmaRN = new TurmaRN();
		Long id = Long.parseLong(value);
		return turmaRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		Turma turma = (Turma) value;
		return turma.getId().toString();
	}
}

