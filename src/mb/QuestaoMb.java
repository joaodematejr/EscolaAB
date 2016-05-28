package mb;

import java.util.List;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;

import entity.Questao;
import rn.QuestaoRN;

@ViewScoped
@ManagedBean
public class QuestaoMb {
	private	 Questao questao;
	private  QuestaoRN questaoRN;
	private Long editarId;
	private List<Questao> listaQuestoes;
	private List<Questao> listaProfessores;
	public List<Questao> getListaProfessores() {
		return listaProfessores;
	}

	public void setListaProfessores(List<Questao> listaProfessores) {
		this.listaProfessores = listaProfessores;
	}

	public List<Questao> getListaProfessor() {
		return listaProfessores;
	}

	public void setListaProfessor(List<Questao> listaProfessor) {
		this.listaProfessores = listaProfessor;
	}

	@PostConstruct
	public void depoisDeConstruir() {
		questao = new Questao();
		questaoRN = new QuestaoRN();
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public QuestaoRN getQuestaoRN() {
		return questaoRN;
	}

	public void setQuestaoRN(QuestaoRN questaoRN) {
		this.questaoRN = questaoRN;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public List<Questao> getListaQuestoes() {
		return listaQuestoes;
	}

	public void setListaQuestoes(List<Questao> listaQuestoes) {
		this.listaQuestoes = listaQuestoes;
	}

	public void carregarUsuario(ComponentSystemEvent event) {
		if (editarId == null) {
			return;
		}

	questao = questaoRN.buscarPorId(editarId);
	}

	public String excluir(String id) {
		Long idExcluir = Long.parseLong(id);
		questaoRN.excluir(idExcluir);
		listaQuestoes = null;
		return "index.html";
	}

	public String salvar() {
		questaoRN.salvar(questao);
		listaQuestoes = null;
		return "index.html";
	}

	public void carregarEdicao() {
		if (editarId != null
				&& !FacesContext.getCurrentInstance().getPartialViewContext()
						.isAjaxRequest()) {
			questao = questaoRN.buscarPorId(editarId);
		}

	}

}

