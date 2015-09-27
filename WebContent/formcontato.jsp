<%@ page language="java" contentType="text/html; charset=iso-8859-1"
    pageEncoding="iso-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Novo Contato</title>
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
		<div class="container"></div>
<form action="ContatoController" method="POST" class="navbar-form navbar-left">
 <div class="form-group">
 <input type="hidden" name="acao" value="inserirContato">
Nome: <input type="text" class="form-control" name="txtNome">
Email: <input type="text" class="form-control" name="txtEndereco">
Telefone: <input type="text" class="form-control" name="txtTelefone">
<button type="submit" class="btn btn-default">Cadastrar</button>
</div>
</form>
<div class="container"></div>

</body>
</html>