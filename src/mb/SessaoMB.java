package mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entity.Cliente;
import entity.Perfil;
import rn.ClienteRN;

@SessionScoped
@ManagedBean
public class SessaoMB {

	private String emailForm;
	private String senhaForm;
	private Cliente clienteLogado;
	private String redirecionamento;
	
	public String getSenhaForm() {
		return senhaForm;
	}

	public void setSenhaForm(String senhaForm) {
		this.senhaForm = senhaForm;
	}

	public String getEmailForm() {
		return emailForm;
	}

	public void setEmailForm(String emailForm) {
		this.emailForm = emailForm;
	}

	public boolean estaLogado() {
		return clienteLogado != null;
	}

	public boolean ehAdmin() {
		return clienteLogado != null
				&& clienteLogado.getPerfil().equals(Perfil.ADMIN);
	}

	public String getNomeClienteLogado() {
		return clienteLogado == null ? "" : clienteLogado.getNome();
	}

	public String sair() {
		clienteLogado = null;
		return "/index?faces-redirect=true";
	}

	public String entrar() {
		ClienteRN clienteRN = new ClienteRN();
		
		if (emailForm != null && !emailForm.isEmpty() 
				&& senhaForm != null && !senhaForm.isEmpty()) {
			
			Cliente cliente = clienteRN.buscarPorEmail(emailForm);

			if (cliente != null
					&& cliente.getEmail().equalsIgnoreCase(emailForm)
					&& cliente.getSenha().equals(senhaForm)) {
				clienteLogado = cliente;

				if(cliente.getPerfil().equals(Perfil.ADMIN)){
					redirecionamento = "/admin/admListagem?faces-redirect=true";
				}else if(cliente.getPerfil().equals(Perfil.PROFESSOR)){
						redirecionamento = "/professor/professor?faces-redirect=true";
				}else{
						redirecionamento = "/aluno/aluno?faces-redirect=true";
					}
			}
		
			
			return redirecionamento;
			
			
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("E-mail ou senha não confere."));
		return "";
	}

	public Cliente getClienteLogado() {
		return clienteLogado;
	}

	public void setClienteLogado(Cliente clienteLogado) {
		this.clienteLogado = clienteLogado;
	}

	public String getRedirecionamento() {
		return redirecionamento;
	}

	public void setRedirecionamento(String redirecionamento) {
		this.redirecionamento = redirecionamento;
	}
}