package mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import entity.Documento;
import entity.Cliente;
import rn.DocumentoRN;

@ViewScoped
@ManagedBean(name = "documentoMb")
public class DocumentoMb {
	private List<Documento> listaDocumento;
	private DocumentoRN documentoRN;
	private Documento documento;
	private Long editarId;
	private Cliente clienteSelecionado;

	@PostConstruct
	public void init() {
		documentoRN = new DocumentoRN();
		documento = new Documento();
		documento.setClienteDocumento(new ArrayList<Cliente>());

	}

	public List<Documento> getListaDocumento() {
		if (listaDocumento == null) {
			listaDocumento = documentoRN.listar();
		}
		return listaDocumento;

	}

	public void setListaEscursao(List<Documento> listaDocumento) {
		this.listaDocumento = listaDocumento;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
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

	public String carregarEdicao() {
		if (editarId != null && !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
			documento = documentoRN.buscarPorId(editarId);
		}
		return null;
	}

	public String excluir(String idParam) {
		Long id = Long.parseLong(idParam);
		documentoRN.excluir(id);
		listaDocumento = null;

		return "";
	}

	public String salvar() throws Throwable {
		try {
			documentoRN.salvar(documento);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Salvo com sucesso."));
			return "/documento";
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
