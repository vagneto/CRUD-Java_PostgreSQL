<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action = "SvEditarCarro" method="get">
	
		<h1>Atualizar Carro</h1>
		
		<label>Ano: </label>
		<input type="text" name="tano" required value = '<%= request.getAttribute("tano") %>' />
		<br>
		<label>Nome: </label>
		<input type="text" name="tnome" required value = '<%= request.getAttribute("tnome") %>' />
		<br>
		<label>Marca: </label>
		<input type="text" name="tmarca" required value = '<%= request.getAttribute("tmarca") %>' />
		<br>
		<label>Placa: </label>
		<input type="text" name="tplaca" required value = '<%= request.getAttribute("tplaca") %>' />
		<br><br>
		
		<input type="submit" value="SALVAR"/>
		
	
	</form>

</body>
</html>