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
@ManagedBean
public class TurmaMb {
	private List<Turma> ListarTurma;
	private TurmaRN TurmaRN;
	private Turma Turma;

	private Long editarId;

	private Cliente clienteSelecionado;

	@PostConstruct
	public void init() {
		TurmaRN = new TurmaRN();
		Turma = new Turma();
		Turma.setClientesTurma(new ArrayList<Cliente>());
	}

	public List<Turma> getListaTurma() {
		if (ListarTurma == null) {
			ListarTurma = TurmaRN.listar();
		}
		return ListarTurma;
	}

	public void setListaTurma(List<Turma> listaTurma) {
		this.ListarTurma = listaTurma;
	}

	public Turma getEscursao() {
		return Turma;
	}

	public List<Turma> getListarTurma() {
		return ListarTurma;
	}

	public void setListarTurma(List<Turma> listarTurma) {
		ListarTurma = listarTurma;
	}

	public TurmaRN getTurmaRN() {
		return TurmaRN;
	}

	public void setTurmaRN(TurmaRN turmaRN) {
		TurmaRN = turmaRN;
	}

	public Turma getTurma() {
		return Turma;
	}

	public void setTurma(Turma turma) {
		Turma = turma;
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
			Turma = TurmaRN.buscarPorId(editarId);
		}
	}

	public void adicionarCliente(AjaxBehaviorEvent event) {
		if(Turma.getClienteTurma().contains(clienteSelecionado)){
			return;
		}
	//	Turma.getClienteTurma().add(clienteSelecionado);
		clienteSelecionado = null;
	}

	public void excluirCliente(AjaxBehaviorEvent event) {
		Cliente cliente = (Cliente) event.getComponent().getAttributes()
				.get("idCliente");
		Turma.getClienteTurma().remove(cliente);
	}
	
	public String excluir(String idParam){
		Long id = Long.parseLong(idParam);
		TurmaRN.excluir(id);
		ListarTurma = null;
		
		return "";
	}

	public String salvar() throws Throwable {
		try {
			TurmaRN.salvar(Turma);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo",
							"Salvo com sucesso."));
			return "/Turmas";
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
