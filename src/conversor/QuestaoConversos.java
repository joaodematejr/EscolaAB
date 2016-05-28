package conversor;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import entity.Questao;
import rn.QuestaoRN;

@FacesConverter(forClass = Questao.class)
public class QuestaoConversos implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String value) {
		QuestaoRN questaoRN = new QuestaoRN();
		Long id = Long.parseLong(value);
		return questaoRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object value) {
		Questao questao = (Questao) value;
		return questao.getId().toString();
	}
}
