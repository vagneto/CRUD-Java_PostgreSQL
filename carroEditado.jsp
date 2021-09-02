<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de carro</title>
</head>
<body>

	<form action="menu.html">
	
	<label>Ano :</label>
	<input type="text" name="tano" required value = '<%= request.getParameter("tano") %>' /> <br>
	<label>Nome:</label>
	<input type="text" name="tnome" required value = '<%= request.getParameter("tnome") %>' /> <br>
	<label>Marca:</label>
	<input type="text" name="tmarca" required value = '<%= request.getParameter("tmarca") %>' /> <br>
	<label>Placa:</label>
	<input type="text" name="tplaca" required value = '<%=request.getParameter("tplaca") %>' /> <br>
	<br><br>
	
	<input type="submit" value="Menu Principal"/><br>
	
	<p>
		<%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %><br>
	</p>
	
	
	</form>
	
</body>
</html>