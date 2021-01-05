package trabalhoRestaurante;

public class Mesa {
	private int numero;
	private Mesa proxima;
	private Cliente cliente;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Mesa getProxima() {
		return proxima;
	}
	public void setProxima(Mesa proxima) {
		this.proxima = proxima;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
