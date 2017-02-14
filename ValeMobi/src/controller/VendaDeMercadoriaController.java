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

@WebServlet("/VendaDeMercadoria.do") 
public class VendaDeMercadoriaController extends HttpServlet {
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
		String pNome, pTipo;
		int pCod, pQuantidade;
		double pPreco;
		Mercadoria mercadoria;
		MercadoriaTO to;
		
		pNome 			= request.getParameter("nome");
		pTipo 			= request.getParameter("tipo");
		pCod  			= Integer.parseInt(request.getParameter("codigo"));		
		pQuantidade  	= Integer.parseInt(request.getParameter("quantidade"));
		pPreco 			= Double.parseDouble(request.getParameter("preco")) ;
		
		mercadoria = new Mercadoria(pNome, pTipo, pQuantidade, pCod, pPreco);
		mercadoria.incluirVenda();
		
		
		to = new MercadoriaTO();
		to.setCod(pCod);
		to.setNome(pNome);
		to.setPreco(pPreco);
		to.setQuantidade(pQuantidade);
		to.setTipo(pTipo);	
		
		request.setAttribute("mercadoria", to);
		RequestDispatcher view = request.getRequestDispatcher("Mercadoria.jsp");;
		view.forward(request, response);
	}
}
