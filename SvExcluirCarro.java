package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entidade.Carro;

@WebServlet("/SvExcluirCarro")
public class SvExcluirCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String placa = request.getParameter("dplaca");
		
		Carro carro = new Carro();
		
		if(carro.deleteRegistro(placa)) {
			request.setAttribute("msg", carro.getMsg());
			request.getRequestDispatcher("carroLocalizado.jsp").forward(request, response);
		}
		else {
			request.setAttribute("msg", carro.getMsg());
			request.getRequestDispatcher("carroLocalizado.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
