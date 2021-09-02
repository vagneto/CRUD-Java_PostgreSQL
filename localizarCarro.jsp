<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Busca de carro</title>
</head>
<body>

	<form action="SvLocalizarCarro" method="get">
	
	<label>Localizar pela placa:</label>
	<input type="text" name="tplaca" value = '<%= request.getParameter("tplaca")==null?"":request.getParameter("tplaca") %>' /> <br>
	<input type="submit" value="Localizar"/>
	<br><br>
	
		
	<%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
		
	</form>
	
</body>
</html>