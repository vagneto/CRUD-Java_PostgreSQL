<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Veículo Localizado</title>
</head>
<body>

	 <h6><%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %></h6>
	<label>Ano:</label>
	<input type="text" name="tano" disabled value = '<%= request.getAttribute("tano")==null?"":request.getAttribute("tano") %>' /> <br>
	<label>Nome:</label>
	<input type="text" name="tnome" disabled value = '<%= request.getAttribute("tnome")==null?"":request.getAttribute("tnome") %>' /> <br>
	<label>Marca:</label>
	<input type="text" name="tmarca" disabled value = '<%= request.getAttribute("tmarca")==null?"":request.getAttribute("tmarca") %>' /> <br>
	<label>Placa  :</label>
	<input type="text" name="tplaca" disabled value = '<%= request.getAttribute("tplaca")==null?"":request.getAttribute("tplaca") %>' /> <br>
	<br>
	
	<table>
		<tr>
			<td>
	
	<form action="SvExcluirCarro" method="get">
	
	<label>Digite a placa para deletar o carro:</label>
	<input type="text" name="dplaca" value = '<%= request.getParameter("dplaca")==null?"":request.getParameter("dplaca") %>' /> <br>
	<input type="submit" value="EXCLUIR"/>
	<br><br>
	
	<h3><%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %></h3>
				
	</form>
			
			</td>
			<td>
			
	<form action="SvEditarCarro" method="get">
	<label>Digite a placa para alterar o carro:</label>
	<input type="text" name="eplaca" value = '<%= request.getParameter("eplaca")==null?"":request.getParameter("eplaca") %>' /> <br>
	<input type="submit" value="ALTERAR"/>
	<br><br>
	
	<h3><%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %></h3>					
	
	</form>
				
			</td>
		</tr>
	</table>
	
</body>
</html>