package trabalhoRestaurante;

public class ListaMesas {
	private Mesa inicio;
	private Mesa fim;
	private Mesa aux;
	
	public void inserir() {
		Mesa mesa = new Mesa();
		
		if(inicio == null) {
			mesa.setNumero(1);
			inicio = mesa;
			fim = mesa;
			mesa.setProxima(null);
		}else {
			mesa.setNumero(fim.getNumero() + 1);
			fim.setProxima(mesa);
			fim = mesa;
			mesa.setProxima(null);
		}
	}
	
	public int quantidadeMesasLivres() {
		aux = inicio;
		int cont = 0;
		while(aux != null) {
			if(aux.getCliente() == null) {
				cont++;
			}
			aux = aux.getProxima();;
		}
		
		return cont;
	}
	
	public int quantidadeMesasOcupadas() {
		aux = inicio;
		int cont = 0;
		while(aux != null) {
			if(aux.getCliente() != null) {
				cont++;
			}
			
			aux = aux.getProxima();
		}
		
		return cont;
	}
	
	public boolean existemMesasOcupadas() {
		aux = inicio;
		
		while(aux != null) {
			if(aux.getCliente() != null) {
				return true;
			}
			
			aux = aux.getProxima();
		}
		
		return false;
	}
	
	public void listarMesasDesocupadas() {
		aux = inicio;
		int cont = 0;
		while(aux != null) {
			if(aux.getCliente() == null) {
				System.out.println("A mesa "+aux.getNumero()+ " está desocupada.");
				cont++;
			}
			aux = aux.getProxima();
		}
		
		if(cont == 0) {
			System.out.println("Todas as mesas estão ocupadas. ");
		}
	}
	
	public void listarMesasOcupadas() {
		aux = inicio;
		while(aux != null) {
			if(aux.getCliente() != null) {
				System.out.println(aux.getCliente().getNome()+" está sentado na mesa "+aux.getNumero()+ ".");
			}
			aux = aux.getProxima();
		}
		
	}
	
	public boolean verificarMesa(int numero) {
		aux = inicio;
		
		while(aux != null) {
			if(aux.getNumero() == numero) {
				if(aux.getCliente() != null) {
					return false;
				}else {
					return true;
				}
			}
			aux = aux.getProxima();
		}
		
		return false;
	}
	
	public boolean adicionarCliente(int numero, Cliente cliente) {
		aux = inicio;
		
		while(aux != null) {
			if(aux.getNumero() == numero) {
				if(aux.getCliente() != null) {
					System.out.println("A mesa escolhida está ocupada.");
					return false;
				}else {
					aux.setCliente(cliente);
					return true;
				}
			}
			
			aux = aux.getProxima();		}
		return false;
	}
	
	public Cliente removerCliente(int numero) {
		aux = inicio;
		
		while(aux != null) {
			if(aux.getNumero() == numero) {
				Cliente cliente = aux.getCliente();
				aux.setCliente(null);
				return cliente;
			}
			
			aux = aux.getProxima();		}
		return null;
		
	}
	
	
}
