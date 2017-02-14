<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import = "to.MercadoriaTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Resultado da Mercadoria</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">		
	</head>
	<body>
		<%MercadoriaTO to = (MercadoriaTO)request.getAttribute("mercadoria"); %>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html">Plataforma de Mercadorias</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-rigth">
						<li><a href="view_compra.html">Comprar</a></li>
						<li><a href="view_venda.html">Vender</a></li>
						<li><a href="view_deletar.html">Deletar Operação</a></li>
						<li><a href="view_consultar.html">Consultar Operação</a></li>
						<li><a href="view_atualizar.html">Atualizar Operação</a></li>
					</ul>			
				</div>
			</div>
		
		</nav>	
	
		<h1>A MERCADORIA MAIS LEGAL QUE VOCÊ CONHECE E RESPEITA!</h1><br>
		Cod:<%=to.getCod()%><br>
		Nome:<%=to.getNome() %><br>
		Tipo:<%=to.getTipo() %><br>
		Quantidade:<%= to.getQuantidade()%><br>
		Preço:<%=to.getPreco() %><br>	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>