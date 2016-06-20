package rn;

import java.util.List;

import dao.ContatoDAO;
import entity.Cliente;
import entity.Contato;

public class ContatoRN {
	private ContatoDAO dao;
	public ContatoRN(){
		dao = new ContatoDAO();
	}
	public void salvar(Contato contato){
		dao.salvar(contato);
	}
	public Contato buscarPorId(Long id){
		return dao.buscarPorId (id);
	}
	public void excluir (Long id){
		dao.excluir(id);
	}
	public List<Contato> listarContatos() {
		return dao.listarContatos();
	}

}
