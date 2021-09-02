<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alteração de Veículo</title>
</head>
<body>

	 <h3><%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %></h3>
	
	<form action="SvEditarCarro" method="get">
	
	<label>Ano:</label>
	<input type="text" name="tano" value = '<%= request.getAttribute("tano")==null?"":request.getAttribute("tano") %>' /> <br>
	<label>Nome:</label>
	<input type="text" name="tnome" value = '<%= request.getAttribute("tnome")==null?"":request.getAttribute("tnome") %>' /> <br>
	<label>Marca:</label>
	<input type="text" name="tmarca" value = '<%= request.getAttribute("tmarca")==null?"":request.getAttribute("tmarca") %>' /> <br>
	<label>Placa  :</label>
	<input type="text" name="tplaca" value = '<%= request.getAttribute("tplaca")==null?"":request.getAttribute("tplaca") %>' /> <br>
	<br>
	
	<input type="submit" value="SALVAR"/>
	<br>
						
	</form>
	

</body>
</html>