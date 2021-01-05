package trabalhoRestaurante;

public class FilaRestaurante {
	private Cliente inicio = null;
	private Cliente fim = null;
	private Cliente aux = null;
	
	public void entrar(String nome) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		
		if(inicio == null) {
			inicio = cliente;
			fim = cliente;
			cliente.setProximo(null);
		}else {
			fim.setProximo(cliente);
			fim = cliente;
			cliente.setProximo(null);
		}
		
		System.out.println(cliente.getNome()+" entrou na fila.");
	}
	
	public void exibirClientesNaFila(){
		if (inicio == null){
			System.out.println("Não há clientes na fila do almoço.");
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
			System.out.println("Não há clientes na fila.");
			return null;
		}else {
			System.out.println(inicio.getNome()+ " saiu da fila e está se servindo.");
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
