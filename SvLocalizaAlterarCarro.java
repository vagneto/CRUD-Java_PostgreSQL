package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entidade.Carro;

@WebServlet("/SvLocalizaAlterarCarro")
public class SvLocalizaAlterarCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String placa = request.getParameter("tplaca");
		
		Carro carro = new Carro(placa);
		
		if(carro.localizarCarro()) {
			request.setAttribute("tano", carro.getAno());
			request.setAttribute("tnome", carro.getNome());
			request.setAttribute("tmarca", carro.getMarca());
			request.setAttribute("tplaca", carro.getPlaca());
			request.setAttribute("msg", carro.getMsg());
			request.getRequestDispatcher("editarCarro.jsp").forward(request, response);
		}
		else {
			request.setAttribute("msg", carro.getMsg());
			request.getRequestDispatcher("localizarAlterarCarro.jsp").forward(request, response);
		}
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
