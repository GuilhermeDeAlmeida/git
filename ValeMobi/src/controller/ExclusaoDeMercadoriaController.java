package controller;

import java.io.IOException; 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import model.Mercadoria;
import to.MercadoriaTO;
//import to.MercadoriaTO;

/**  
*Servlet implementation class ManterClienteController 	
*/

@WebServlet("/ExclusaoDeMercadoria.do") 
public class ExclusaoDeMercadoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**   
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)   
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {   
		doPost(request, response);  
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)   
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{

		int pCodOperacao;
		Mercadoria mercadoria;
		MercadoriaTO to;
		
		pCodOperacao	= Integer.parseInt(request.getParameter("codigoOperacao"));		
		
		mercadoria = new Mercadoria();
		mercadoria.excluir(pCodOperacao);
		
		to = new MercadoriaTO();
		
		request.setAttribute("mercadoria", to);
		RequestDispatcher view = request.getRequestDispatcher("Mercadoria.jsp");;
		view.forward(request, response);
	}
}

