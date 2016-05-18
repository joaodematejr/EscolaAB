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
import rn.ClienteRN;

@ViewScoped
@ManagedBean
public class ClienteMb {
	private Cliente cliente;
	private ClienteRN clienteRN;
	private Long editarId;
	private List<Cliente> listaClientes;

	@PostConstruct
	public void depoisDeConstruir() {
		cliente = new Cliente();
		clienteRN = new ClienteRN();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteRN getClienteRN() {
		return clienteRN;
	}

	public void setClienteRN(ClienteRN clienteRN) {
		this.clienteRN = clienteRN;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public List<Cliente> getListaClientes() {
		if (listaClientes == null) {
			listaClientes = clienteRN.listarClientes();
		}
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void carregarUsuario(ComponentSystemEvent event) {
		if (editarId == null) {
			return;
		}

		cliente = clienteRN.buscarPorId(editarId);
	}

	public String excluir(String id) {
		Long idExcluir = Long.parseLong(id);
		clienteRN.excluir(idExcluir);
		listaClientes = null;
		return "";
	}

	public String salvar() {
		clienteRN.salvar(cliente);
		listaClientes = null;
		return "";
	}

	public void carregarEdicao() {
		if (editarId != null && !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
			cliente = clienteRN.buscarPorId(editarId);
		}

	}

}
