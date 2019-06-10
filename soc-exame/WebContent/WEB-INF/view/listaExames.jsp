<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.fabio.servlet.modelo.Exame"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="home.css">

<title>Exames Cadastrados</title>
</head>
<body>

<h1>Lista de Exames e Pacientes:</h1><br>

<ul>
		<c:forEach items="${exames}" var="exame">
		
		<li>
		${exame.nomePaciente}
		${exame.tipoExame}
		<button onclick="window.location.href = '/soc-exame/entrada?acao=EditaExame&id=${exame.id}';">Editar</button>
		<button onclick="window.location.href = '/soc-exame/entrada?acao=RemoveExames&id=${exame.id}';">Remover</button>
		</li>
		</c:forEach>
		<br>	
		<button onclick="window.location.href = '/soc-exame/entrada?acao=FormularioInserirExame';">Cadastrar Exame</button>
		
</ul>
</body>
</html>