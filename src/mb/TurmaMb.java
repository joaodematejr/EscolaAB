package mb;

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

import rn.TurmaRN;
import entity.Turma;


@ViewScoped
@ManagedBean
public class TurmaMb {
	private Turma turma;
	private TurmaRN turmaRN;
	private Long editarId;
	private List<Turma> listaTurmas;
	@PostConstruct
	public void depoisDeConstruir() {
		turma = new Turma();
		turmaRN = new TurmaRN();
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public TurmaRN getTurmaRN() {
		return turmaRN;
	}

	public void setTurmaRN(TurmaRN turmaRN) {
		this.turmaRN = turmaRN;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public List<Turma> getListaTurmas() {
		if (listaTurmas == null) {
			listaTurmas = turmaRN.listarTurmas();
		}
		return listaTurmas;
	}

	public void setListaTurma(List<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}

	public void carregarUsuario(ComponentSystemEvent event) {
		if (editarId == null) {
			return;
		}

		turma = turmaRN.buscarPorId(editarId);
	}

	public String excluir(String id) {
		Long idExcluir = Long.parseLong(id);
		turmaRN.excluir(idExcluir);
		listaTurmas = null;
		return "index.html";
	}

	public String salvar() {
		turmaRN.salvar(turma);
		listaTurmas = null;
		return "index.html";
	}

	public void carregarEdicao() {
		if (editarId != null
				&& !FacesContext.getCurrentInstance().getPartialViewContext()
						.isAjaxRequest()) {
			turma = turmaRN.buscarPorId(editarId);
		}

	}

}
