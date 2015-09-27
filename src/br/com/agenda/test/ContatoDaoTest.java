package br.com.agenda.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.agenda.dao.ContatoDao;
import br.com.agenda.dao.ContatoDaoImpl;
import br.com.agenda.model.Contato;

public class ContatoDaoTest {

	static ContatoDao contatodao;

	static Contato c1;


	@Ignore @Test
	public void insereContato() {

		contatodao = new ContatoDaoImpl();
		c1 = new Contato();

		

		for (int i = 0; i <= 20000; i++) {
			
			c1.setNome("Davi Silva" + i);
			c1.setEndereco("extramicro@hotmail.com");
			c1.setTelefone(i + "77777777");
			
			contatodao.inserirContato(c1);
		}

	}

	@Ignore
	@Test
	public void alterarContato() {

		contatodao = new ContatoDaoImpl();
		c1 = new Contato();

		c1.setNome("Hiwdyanne Souza");
		c1.setEndereco("hiwdyanne@hotmail.com");
		c1.setTelefone("88888888");

		for (int i = 0; i <= 20100; i++) {
			c1.setId(i);
			contatodao.alterarContato(c1);
		}

	}

	
	@Test
	public void apagarContato() {

		contatodao = new ContatoDaoImpl();

		for (int i = 0; i <= 40000; i++) {
			contatodao.excluirContato(i);
		}

	}

	@Ignore @Test
	public void ListarContatos() {
		
		contatodao = new ContatoDaoImpl();
		
		for (Contato contato : contatodao.ListarContatos()) {

			System.out.println("ID: " + contato.getId());
			System.out.println("NOME: " + contato.getNome());
			System.out.println("EMAIL: " + contato.getEndereco());
			System.out.println("TELEFONE: " + contato.getTelefone());

		}

	}

}
