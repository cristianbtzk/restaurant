package trabalhoRestaurante;

public class FilaCaixa {
	private Cliente inicio = null;
	private Cliente fim = null;
	private Cliente aux = null;
	
	public void entrar(Cliente cliente) {
		if(inicio == null) {
			inicio = cliente;
			fim = cliente;
			cliente.setProximo(null);
		}else {
			fim.setProximo(cliente);
			fim = cliente;
			cliente.setProximo(null);
		}
		
		System.out.println(cliente.getNome()+" terminou seu almoço e entrou na fila do caixa.");
	}
	
	public void exibirClientesNaFila(){
		if (inicio == null){
			System.out.println("Não há clientes na fila do caixa.");
		}
		else
		{
			System.out.println("Clientes na fila: ");
			aux = inicio;
			while(aux != null){
				System.out.print(aux.getNome()+" ");
				aux = aux.getProximo();
			}
		}
	}
	
	public void efetuarPagamento() {
		if(inicio == null) {
			System.out.println("Não há clientes na fila.");
		}else {
			System.out.println(inicio.getNome()+ " efetuou o pagamento e está deixando o estabelecimento.");
			aux = inicio;
			inicio = inicio.getProximo();
		}
	}
	
	public int contarClientes() {
		aux = inicio;
		int cont = 0;
		
		while(aux != null) {
			cont++;
			aux = aux.getProximo();
		}
		
		return cont;
	}
}
