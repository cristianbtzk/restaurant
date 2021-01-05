package trabalhoRestaurante;

public class PilhaPratos {
	private Prato topo = null;
	private Prato aux = null;
	
	public void adicionar() {
		Prato prato = new Prato();
		
		if(topo == null) {
			topo = prato;
			prato.setProximo(null);
		}else{
			prato.setProximo(topo);
			topo = prato;
		}
	}
	
	public void removerPrato() {
		if(topo == null) {
			System.out.println("Não há pratos na pilha.");
		}else {
			topo = topo.getProximo();
		}
	}
	
	public int contarPratos() {
		aux = topo;
		int cont = 0;
		
		while(aux != null) {
			cont++;
			aux = aux.getProximo();
		}
		
		return cont;
	}
}
