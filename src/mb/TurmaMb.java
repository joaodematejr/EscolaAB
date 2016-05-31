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


import rn.TurmaRN;
import entity.Cliente;
import entity.Turma;


@ViewScoped
@ManagedBean (name= "turmaMb")
public class TurmaMb {
	private List<Turma> listarTurma;
	private TurmaRN turmaRN;
	private Turma turma;

	private Long editarId;

	private Cliente clienteSelecionado;

	@PostConstruct
	public void init() {
		turmaRN = new TurmaRN();
		turma = new Turma();
		turma.setClienteTurma(new ArrayList<Cliente>());
	}

	public List<Turma> getListaTurma() {
		if (listarTurma == null) {
			listarTurma = turmaRN.listar();
		}
		return listarTurma;
	}

	public void setListaTurma(List<Turma> listaTurma) {
		this.listarTurma = listaTurma;
	}

	

	public List<Turma> getListarTurma() {
		return listarTurma;
	}

	public void setListarTurma(List<Turma> listarTurma) {
		this.listarTurma = listarTurma;
	}

	public TurmaRN getTurmaRN() {
		return turmaRN;
	}

	public void setTurmaRN(TurmaRN turmaRN) {
		this.turmaRN = turmaRN;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public void carregarEdicao() {
		if (editarId != null &&  
				!FacesContext.getCurrentInstance()
				.getPartialViewContext().isAjaxRequest()) {
			turma = turmaRN.buscarPorId(editarId);
		}
	}



	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}
	public void adicionarCliente(AjaxBehaviorEvent event) {
		if(turma.getClienteTurma().contains(clienteSelecionado)){
			return;
		}
		turma.getClienteTurma().add(clienteSelecionado);
		clienteSelecionado = null;
	}

	public void excluirCliente(AjaxBehaviorEvent event) {
		Cliente cliente = (Cliente) event.getComponent().getAttributes()
				.get("idCliente");
		turma.getClienteTurma().remove(cliente);
	}
	
	public String excluir(String idParam){
		Long id = Long.parseLong(idParam);
		turmaRN.excluir(id);
		listarTurma = null;
		
		return "";
	}

	public String salvar() throws Throwable {
		try {
			turmaRN.salvar(turma);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo",
							"Salvo com sucesso."));
			return "/turmas";
		} catch (IllegalArgumentException exception) {
			exception.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
							exception.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e
							.getMessage()));
		}
		return "";
	}


}
