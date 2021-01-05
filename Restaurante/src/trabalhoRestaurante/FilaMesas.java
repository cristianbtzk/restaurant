package trabalhoRestaurante;

public class FilaMesas {
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
		
		System.out.println(cliente.getNome()+" entrou na fila para escolher sua mesa.");
	}
	
	public void exibirClientesNaFila(){
		if (inicio == null){
			System.out.println("Não há clientes na fila para as mesas.");
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
	
	public Cliente remover() {
		if(inicio == null) {
			System.out.println("Não há clientes na fila para escolher a mesa.");
			return null;
		}else {
			System.out.println(inicio.getNome()+ " saiu da fila e sentou-se para almoçar.");
			aux = inicio;
			inicio = inicio.getProximo();
			return (Cliente) aux;
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
