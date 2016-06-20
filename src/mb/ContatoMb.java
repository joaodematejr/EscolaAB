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

import entity.Cliente;
import entity.Contato;
import rn.ClienteRN;
import rn.ContatoRN;

@ViewScoped
@ManagedBean
public class ContatoMb {
	private Contato contato;
	private ContatoRN contatoRN;
	private Long editarId;
	private List<Contato> listaContatos;

	@PostConstruct
	public void depoisDeConstruir() {
		contato = new Contato();
		contatoRN = new ContatoRN();
	}

	public Contato getContato() {
		return contato;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public void carregarContato(ComponentSystemEvent event) {
		if (editarId == null) {
			return;
		}

		contato = contatoRN.buscarPorId(editarId);
	}

	public List<Contato> getListaContatos() {
		if (listaContatos == null) {
			listaContatos = contatoRN.listarContatos();
		}
		return listaContatos;
	}

	public void setListaContatos(List<Contato> listaContatos) {
		this.listaContatos = listaContatos;
	}

	public String excluir(String id) {
		Long idExcluir = Long.parseLong(id);
		contatoRN.excluir(idExcluir);
		return "listaDeContatos.xhtml";
	}

	public String salvar() {
		contatoRN.salvar(contato);
		return "contato.xhtml";
	}

}
