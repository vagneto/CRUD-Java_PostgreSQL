package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entidade.Carro;

@WebServlet("/SvCadastrarCarro")
public class SvCadastrarCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ano = request.getParameter("tano");
		String nome = request.getParameter("tnome");
		String marca = request.getParameter("tmarca");
		String placa = request.getParameter("tplaca");

		Carro carro = new Carro(ano, nome, marca, placa);
		
		if(carro.salvar()) {
  			request.setAttribute("msg", carro.getMsg());
  			request.getRequestDispatcher("cadastroCarro.jsp").forward(request, response);
  		} else {
  			request.setAttribute("msg", carro.getMsg());
  			request.getRequestDispatcher("cadastroCarro.jsp").forward(request, response);
  		}
		
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
