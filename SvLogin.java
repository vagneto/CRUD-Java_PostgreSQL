package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entidade.Carro;

@WebServlet("/SvLogin")
public class SvLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cpf = request.getParameter("tcpf");
		String senha = request.getParameter("tsenha");
		
		Carro carro = new Carro(cpf, senha);
		
		if(carro.localizarUsuario()) {
			request.getRequestDispatcher("menu.html").forward(request, response);
		}
		else {
			request.setAttribute("msg", carro.getMsg());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
