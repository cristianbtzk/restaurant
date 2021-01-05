package trabalhoRestaurante;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ListaMesas listaMesas = new ListaMesas();
		FilaRestaurante filaRestaurante = new FilaRestaurante();
		FilaMesas filaMesas = new FilaMesas();
		PilhaPratos pilhaPratos = new PilhaPratos();
		FilaCaixa filaCaixa = new FilaCaixa();
		
		listaMesas.inserir();
		listaMesas.inserir();
		listaMesas.inserir();
		listaMesas.inserir();
		listaMesas.inserir();
		listaMesas.inserir();
		
		double totalCaixa = 0;
		int pessoasAtendidas = 0;
		int opcao = 0;
		
		do {
			System.out.println("\nEscolha uma opção: \n"
					+ "1 - Entrar na fila\n"
					+ "2 - Servir-se no buffet\n"
					+ "3 - Reposição de pratos\n"
					+ "4 - Escolher mesa para sentar\n"
					+ "5 - Finalizar o almoço e entrar na fila do caixa\n"
					+ "6 - Efetuar pagamento\n"
					+ "7 - Mostrar relatório\n"
					+ "8 - Exibir Clientes na fila do almoço\n"
					+ "9 - Exibir Clientes na fila para as mesas\n"
					+ "10 - Exibir Clientes na fila do caixa\n"
					+ "0 - Sair\n");
			opcao = scan.nextInt();
			scan.nextLine();
			switch (opcao) {
				case 1: {
					System.out.println("Informe o nome do cliente: ");
					String nome = scan.nextLine();
					filaRestaurante.entrar(nome);
					
					break;
				}
				case 2: {
					if(pilhaPratos.contarPratos() <= 0) {
						System.out.println("Não há pratos na pilha. Aguarde a reposição. ");
					}else {
						if(filaRestaurante.contarClientes() <= 0) {
							System.out.println("Não há clientes na fila. ");
							
						}else {
							Cliente cliente = filaRestaurante.remover();
							try
							{
							    Thread.sleep(2000);
							}
							catch(InterruptedException ex)
							{
							    System.out.println(ex);
							}
							System.out.println(cliente.getNome()+" acabou de se servir. ");
							pilhaPratos.removerPrato();
							filaMesas.entrar(cliente);
						}
					}
					
					break;
				}
				case 3:{
					System.out.println("Informe quantos pratos serão repostos: ");
					int quantidade = scan.nextInt();
					scan.nextLine();
					for (int i = 0; i < quantidade; i++) {
						pilhaPratos.adicionar();
					}
					System.out.println("Pratos repostos. Atualmente há "+pilhaPratos.contarPratos() + " na pilha.");
					break;
				}
				case 4:{
					if(filaMesas.contarClientes() <= 0) {
						System.out.println("Não há clientes na lista para escolher uma mesa.");
					}else {
						if(listaMesas.quantidadeMesasLivres() <= 0) {
							System.out.println("Não há mesas livres. Aguarde alguns instantes.");
						}else {
							listaMesas.listarMesasDesocupadas();
							int numero = 0;
							boolean mesaLivre = false;
							do {
								System.out.println("Em qual mesa você deseja sentar? ");
								numero = scan.nextInt();
								scan.nextLine();
								mesaLivre = listaMesas.verificarMesa(numero);
								if(!mesaLivre) {
									System.out.println("A mesa está ocupada.");
								}
							}while(!mesaLivre);
							Cliente cliente = filaMesas.remover();
							if(!listaMesas.adicionarCliente(numero, cliente)) {
								System.out.println("Erro ao sentar na mesa.");
							}
						}
					}	
					break;
				}
				case 5:{
					if(!listaMesas.existemMesasOcupadas()) {
						System.out.println("Não há pessoas almoçando no momento. ");
					}else {
						System.out.println("Mesas ocupadas no momento: ");
						listaMesas.listarMesasOcupadas();
						System.out.println("Informe em qual mesa está sentado o cliente que irá efetuar o pagamento: ");
						int numero = scan.nextInt();
						scan.nextLine();
						if(listaMesas.verificarMesa(numero)) {
							System.out.println("A mesa está vazia. ");
						}else {
							Cliente cliente = listaMesas.removerCliente(numero);
							filaCaixa.entrar(cliente);
						}
					}
					
					break;
				}
				case 6:{
					if(filaCaixa.contarClientes() <= 0) {
						System.out.println("Não há clientes na fila do caixa.");
					}else {
						filaCaixa.efetuarPagamento();
						totalCaixa += 20;
						pessoasAtendidas++;
					}
					
					break;
				}
				case 7:{
					System.out.println("Valor movimentado pelo caixa: R$ "+totalCaixa);
					System.out.println("Número de pessoas na fila para almoçar (buffet + mesas): "+ 
							(filaMesas.contarClientes() + filaRestaurante.contarClientes())+ " pessoas.");
					System.out.println("Número de pessoas na fila do caixa: "+filaCaixa.contarClientes()+" pessoas.");
					System.out.println("Número de pessoas almoçando no restaurante: "+listaMesas.quantidadeMesasOcupadas()+ " "
							+ "pessoas.");
					System.out.println("Total de clientes atendidos no restaurante: "+pessoasAtendidas+ " clientes.");
					System.out.println("Pratos na pilha: "+pilhaPratos.contarPratos() + " pratos.");
					System.out.println("Quantidade de mesas livres: "+listaMesas.quantidadeMesasLivres());
					break;
				}
				case 8:{
					filaRestaurante.exibirClientesNaFila();
					break;
				}
				case 9:{
					filaMesas.exibirClientesNaFila();
					break;
				}
				case 10:{
					filaCaixa.exibirClientesNaFila();
					break;
				}
				default:
					opcao = 0;
			}
			
		}while(opcao != 0);
		
		scan.close();
	}

}
