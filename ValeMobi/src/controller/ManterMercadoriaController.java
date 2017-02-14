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

@WebServlet("/ManterMercadoria.do") 
public class ManterMercadoriaController extends HttpServlet {
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
		String pNome, pTipo, pAcao;
		int pCod,pCodOperacao, pQuantidade;
		double pPreco;
		Mercadoria mercadoria;
		MercadoriaTO to;
		
		pAcao 			= request.getParameter("acao");
		pNome 			= request.getParameter("nome");
		pTipo 			= request.getParameter("tipo");
		pCod  			= Integer.parseInt(request.getParameter("codigo"));
		pCodOperacao	= Integer.parseInt(request.getParameter("codigoOperacao"));		
		pQuantidade  	= Integer.parseInt(request.getParameter("quantidade"));
		pPreco 			= Double.parseDouble(request.getParameter("preco")) ;
		
		mercadoria = new Mercadoria(pNome, pTipo, pQuantidade, pCod, pPreco);
		mercadoria.atualizar(pCodOperacao);
		if(pAcao.equals("Inserir Compra")){
			mercadoria.incluirCompra();
			System.out.println("COMPRA");
			
		}else if(pAcao.equals("Inserir Venda")){
			mercadoria.incluirVenda();
			System.out.println("VENDA");
		}
		else if(pAcao.equals("Consultar")){
			mercadoria.carregarOperacao(pCodOperacao);
			
		}else if(pAcao.equals("Atualizar")){
			mercadoria.atualizar(pCodOperacao);
			
		}else if(pAcao.equals("Excluir")){
			mercadoria.excluir(pCodOperacao);
		}
		
		to = new MercadoriaTO();
		to.setCod(pCod);
		to.setNome(pNome);
		to.setPreco(pPreco);
		to.setQuantidade(pQuantidade);
		to.setTipo(pTipo);	
		
		request.setAttribute("mercadoria", to);
		RequestDispatcher view = request.getRequestDispatcher("Mercadoria.jsp");;
		view.forward(request, response);
		
		
		
//		PrintWriter out = response.getWriter();
//		out.println("<html>"
//				+ 		"<head>"
//				+ 			"<title>Mercadoria Resposta</title>"
//				+		"</head>"
//				+		"<body>"
//				+			"Nome: " + mercadoria.getNome()+"<br>"
//				+			"id:" + mercadoria.getCod()+ "<br>"
//				+			"Tipo: " + mercadoria.getTipo()+"<br>"
//				+			"Quantidade: " + mercadoria.getQuantidade()+"<br>"
//				+			"Preço: " + mercadoria.getPreco() +"<br>"
//				+		"</body>"
//				+	"</html>");
	}
	
}
