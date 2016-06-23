package mb;

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

import rn.ProvaRN;
import entity.Pergunta;
import entity.Prova;

@ViewScoped
@ManagedBean
public class ProvaMb {
	private List<Prova> listarProva;
	private ProvaRN provaRN;
	private Prova prova;

	private Long editarId;

	private Pergunta perguntaSelecionado;

	@PostConstruct
	public void init() {
		provaRN = new ProvaRN();
		prova = new Prova();
		prova.setPerguntaProva(new ArrayList<Pergunta>());
	}

	public List<Prova> getListaProva() {
		if (listarProva == null) {
			listarProva = provaRN.listar();
		}
		return listarProva;
	}

	public void setListaProva(List<Prova> listaProva) {
		this.listarProva = listaProva;
	}

	public List<Prova> getListarProva() {
		return listarProva;
	}

	public void setListarProva(List<Prova> listarProva) {
		this.listarProva = listarProva;
	}

	public ProvaRN getProvaRN() {
		return provaRN;
	}

	public void setTurmaRN(ProvaRN provaRN) {
		this.provaRN = provaRN;
	}

	public Prova getProva() {
		return prova;
	}

	public void setTurma(Prova prova) {
		this.prova = prova;
	}

	public void setPerguntaSelecionado(Pergunta perguntaSelecionado) {
		this.perguntaSelecionado = perguntaSelecionado;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public void carregarEdicao() {
		if (editarId != null && !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
			prova = provaRN.buscarPorId(editarId);
		}
	}

	public Pergunta getPerguntaSelecionado() {
		return perguntaSelecionado;
	}

	public void adicionarPergunta(AjaxBehaviorEvent event) {
		if (prova.getPerguntaProva().contains(perguntaSelecionado)) {
			return;
		}
		prova.getPerguntaProva().add(perguntaSelecionado);
		perguntaSelecionado = null;
	}

	public void excluirPergunta(AjaxBehaviorEvent event) {
		Pergunta pergunta = (Pergunta) event.getComponent().getAttributes().get("idPergunta");
		prova.getPerguntaProva().remove(pergunta);
	}

	public String excluir(String idParam) {
		Long id = Long.parseLong(idParam);
		provaRN.excluir(id);
		listarProva = null;

		return "";
	}

	public String salvar() throws Throwable {
		try {
			provaRN.salvar(prova);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Salvo com sucesso."));
			return "/prova";
		} catch (IllegalArgumentException exception) {
			exception.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", exception.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		}
		return "";
	}

}
