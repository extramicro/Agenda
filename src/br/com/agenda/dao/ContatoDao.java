package br.com.agenda.dao;

import java.util.List;

import br.com.agenda.model.Contato;

public interface ContatoDao {
	
	public void inserirContato(Contato c);
	public void alterarContato(Contato c);
	public void excluirContato(int id);
	public List<Contato> ListarContatos();
	

}
