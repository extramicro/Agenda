<%@ page language="java" contentType="text/html; charset=iso-8859-1"
	pageEncoding="iso-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="br.com.agenda.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Contatos</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
</head>
<body>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<div class="container">
	<div class="panel panel-default">

		 <div class="panel-heading"><h2>Lista de Contatos</h2>  
		 <h4><a href="formcontato.jsp"> + Adicionar Contato</a></h4></div>

			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr >
						<th># Id </th>
						<th>Nome</th>
						<th>Email</th>
						<th>Telefone</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th># Id</th>
						<th>Nome</th>
						<th>Email</th>
						<th>Telefone</th>
					</tr>
				</tfoot>


				<%
					List<Contato> contatos = (List<Contato>) request.getAttribute("contatos");

					for (Contato c : contatos) {
				%>
				<tbody>
					<tr>
						<td ><%=c.getId()%></td>
						<td><%=c.getNome()%></td>
						<td><%=c.getEndereco()%></td>
						<td><%=c.getTelefone()%></td>
						<td><a href="/Agenda/ContatoController?acao=updateContato&id=<%=c.getId()%>">Alterar</a></td>
						<td><a href="/Agenda/ContatoController?acao=deleteContato&id=<%=c.getId()%>">Excluir</a></td>
					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
	</div>
	</div>

</body>
</html>