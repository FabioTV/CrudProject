<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <c:url value="/entrada" var="linkEntraServlet"></c:url>  
<!DOCTYPE html>
<html>
<head>	
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="home.css">
	<title>Pagina de cadastro de exames</title>
</head>
<body>

<h1>Bem Vindo a Pagina de Cadastro de Exames ! </h1>

<form action="${linkEntraServlet}" method="post"> 

	Nome do Paciente:<br><input type="text" name="nomePaciente" />
	<br>
	Tipo do Exame:<br><input type="text" name="tipo" />
	<br>
	Nome do Médico:<br><input type="text" name="nomeMedico" />
	<br>
	Tipo do Plano de Saude:<br><input type="text" name="plano" />
	
	<br>
	
	<input type="hidden" name="acao" value="InserirExame"/>
	<input type="submit" value="Adicionar"/>
	
</form>

</body>
</html>