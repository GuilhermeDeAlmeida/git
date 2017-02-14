package model;

import dao.MercadoriaDAO;
import to.MercadoriaTO;

public class Mercadoria {
	private String nome, tipo;
	private int quantidade, cod;
	private double preco;
	public Mercadoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mercadoria(String nome, String tipo, int quantidade, int cod, double preco) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.cod = cod;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public void atualizar(int codOp){
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = new MercadoriaTO();
		to.setCod(cod);
		to.setNome(nome);
		to.setQuantidade(quantidade);
		to.setPreco(preco);
		to.setTipo(tipo);
		dao.atualizar(to, codOp);
	}
	 
	public void excluir(int codOperacao){
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = new MercadoriaTO();
		to.setCod(cod);
		to.setNome(nome);
		to.setPreco(preco);
		to.setQuantidade(quantidade);
		to.setTipo(tipo);
		dao.excluir(codOperacao);	
	}
	public void carregarOperacao(int codOperacao){
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = dao.carregar(codOperacao);
		this.setNome(to.getNome());
		this.setTipo(to.getTipo());
		this.setPreco(to.getPreco());
		this.setQuantidade(to.getQuantidade());
		this.setCod(to.getCod());
	}
	public void incluirCompra(){
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = new MercadoriaTO();
		to.setCod(cod);
		to.setNome(nome);
		to.setQuantidade(quantidade);
		to.setTipo(tipo);
		to.setPreco(preco);
		dao.incluir(to);
	}
	public void incluirVenda(){
		MercadoriaDAO dao = new MercadoriaDAO();
		MercadoriaTO to = new MercadoriaTO();
		to.setCod(cod);
		to.setNome(nome);
		to.setQuantidade(quantidade);
		to.setTipo(tipo);
		to.setPreco(preco);
		dao.incluirVenda(to);
	}
	
	

}
