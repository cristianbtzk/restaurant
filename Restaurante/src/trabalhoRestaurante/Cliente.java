package trabalhoRestaurante;

public class Cliente {
	private String nome;
	private Cliente proximo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cliente getProximo() {
		return proximo;
	}
	public void setProximo(Cliente proximo) {
		this.proximo = proximo;
	}
	
	
}
