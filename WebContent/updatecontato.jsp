<%@page import="br.com.agenda.dao.ContatoDaoImpl"%>
<%@page import="br.com.agenda.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="br.com.agenda.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Contato</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
</head>
<body>
<%
		String id = request.getParameter("id");
		//int idd = Integer.parseInt(id);
		String nome = null;
		String endereco = null;
		String telefone = null;
		ContatoDao contatodao = new ContatoDaoImpl();

		for (Contato c : contatodao.ListarContatos()) {
			if (c.getId() == Integer.parseInt(id)) {
				nome = c.getNome();
				endereco = c.getEndereco();
				telefone = c.getTelefone();
			}
		}
	%>
	
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<div class="container"></div>
	<form action="ContatoController" method="POST"
		class="navbar-form navbar-left">
		<div class="form-group">
			<input type="hidden" name="acao" value="alterarcontato">
			<input type="hidden" name="id" value="<%=id%>">
			Nome: <input type="text" class="form-control" name="txtNome" value="<%=nome%>">
			Email: <input type="text" class="form-control" name="txtEndereco" value="<%=endereco%>">
			Telefone: <input type="text" class="form-control" name="txtTelefone" value = "<%=telefone%>">
			<button type="submit" class="btn btn-default">Alterar</button>
		</div>
	</form>
	<div class="container"></div>

</body>
</html>