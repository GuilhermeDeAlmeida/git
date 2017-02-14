package to;

public class MercadoriaTO {
	private String nome, tipo;
	private int quantidade, cod;
	private double preco;
	
	public MercadoriaTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MercadoriaTO(String nome, String tipo, int quantidade, int cod, double preco) {
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
	


}
