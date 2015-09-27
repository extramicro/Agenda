package br.com.agenda.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.dao.ContatoDao;
import br.com.agenda.dao.ContatoDaoImpl;
import br.com.agenda.model.Contato;

/**
 * Servlet implementation class ServletContato
 */
@WebServlet(name = "/ServletContato", urlPatterns = { "/ContatoController" }, description = "servlet Contatos")
public class ServletContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContatoDao contatodao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletContato() {
		super();
		contatodao = new ContatoDaoImpl();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("acao");

		String page = null;

		if (action.equalsIgnoreCase("updateContato")) {

			page = "/updatecontato.jsp";

		} else if (action.equalsIgnoreCase("deleteContato")) {

			String id = request.getParameter("id");
			int idDelete = Integer.parseInt(id);
			contatodao.excluirContato(idDelete);

			request.setAttribute("contatos", contatodao.ListarContatos());
			page = "/contato.jsp";
		} else if (action.equalsIgnoreCase("listarContatos")) {

			request.setAttribute("contatos", contatodao.ListarContatos());
			page = "/contato.jsp";
		} else {

			page = "/contato.jsp";

		}

		request.getRequestDispatcher(page).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("contatos", contatodao.ListarContatos());

		String action = request.getParameter("acao");

		String nome = request.getParameter("txtNome");
		String endereco = request.getParameter("txtEndereco");
		String telefone = request.getParameter("txtTelefone");
		String page = null;
		String id = request.getParameter("id");
		int idd;  

		Contato contato = new Contato();

		if (action.equalsIgnoreCase("inserirContato")) {

			contato.setNome(nome);
			contato.setEndereco(endereco);
			contato.setTelefone(telefone);

			contatodao.inserirContato(contato);

			request.setAttribute("contatos", contatodao.ListarContatos());

			page = "/contato.jsp";

		} else if (action.equalsIgnoreCase("alterarcontato")) {
			
			contato.setId(Integer.parseInt(id));
			contato.setNome(nome);
			contato.setEndereco(endereco);
			contato.setTelefone(telefone);
			contatodao.alterarContato(contato);
			
			request.setAttribute("contatos", contatodao.ListarContatos());
			
			page = "/contato.jsp";

		}

		else {

			page = "/errocontato.jsp";

		}

		request.getRequestDispatcher(page).forward(request, response);
	}

}
