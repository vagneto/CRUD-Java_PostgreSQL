<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<form action="SvLogin" method="post">
	
	<label>Digite o cpf:</label>
	<input type="text" name="tcpf" value = '<%= request.getParameter("tcpf")==null?"":request.getParameter("tcpf") %>' /> <br>
	<label>Digite a senha:</label>
	<input type="text" name="tsenha" value = '<%= request.getParameter("tsenha")==null?"":request.getParameter("tsenha") %>' /> <br>
	<br>	
	<input type="submit" value="Entrar"/><br>
	<a href="index.html"><button>Página inicial</button></a> <!-- Esta porra de botão não está funcionando -->
	
	<p>
		<%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %>
	</p>
	
	
	</form>
	
</body>
</html>