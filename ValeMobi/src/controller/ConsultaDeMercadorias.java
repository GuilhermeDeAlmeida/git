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

@WebServlet("/ConsultaDeMercadoria.do") 
public class ConsultaDeMercadorias extends HttpServlet {
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
		mercadoria.carregarOperacao(pCodOperacao);
	
		to = new MercadoriaTO();
		to.setCod(mercadoria.getCod());
		to.setNome(mercadoria.getNome());
		to.setPreco(mercadoria.getPreco());
		to.setQuantidade(mercadoria.getQuantidade());
		to.setTipo(mercadoria.getTipo());	
		
		request.setAttribute("mercadoria", to);
		RequestDispatcher view = request.getRequestDispatcher("Mercadoria.jsp");;
		view.forward(request, response);
		

	}
	
}
