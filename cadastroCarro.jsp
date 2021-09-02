<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de carro</title>
</head>
<body>

	<form action="SvCadastrarCarro" method="get">
	
	<label>Ano :</label>
	<input type="text" name="tano" value = '<%= request.getParameter("tano")==null?"":request.getParameter("tano") %>' /> <br>
	<label>Nome:</label>
	<input type="text" name="tnome" value = '<%= request.getParameter("tnome")==null?"":request.getParameter("tnome") %>' /> <br>
	<label>Marca:</label>
	<input type="text" name="tmarca" value = '<%= request.getParameter("tmarca")==null?"":request.getParameter("tmarca") %>' /> <br>
	<label>Placa:</label>
	<input type="text" name="tplaca" placeholder="Números. Ex:1980" value = '<%=request.getParameter("tplaca")==null?"":request.getParameter("tplaca") %>' /> <br>
	<br>
	
	<p>
		<%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
	</p>
	
	<input type="submit" value="Salvar"/>
	
	</form>
	
</body>
</html>