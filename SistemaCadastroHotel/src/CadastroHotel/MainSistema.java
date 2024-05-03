package CadastroHotel;
import java.util.Scanner;
import java.util.ArrayList;

public class MainSistema {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		ArrayList <Reserva> cadastroReserva = new ArrayList<>();
		
		int op;
		
		do {
			System.out.println("MENU: ");
			System.out.println("\n1 - Cadastrar reserva");
			System.out.println("2 - Listar reserva");
			System.out.println("3 - Excluir reserva");
			System.out.println("4 - Alterar reserva");
			System.out.println("5 - Buscar reserva");
			System.out.println("6 - Sair do menu de opcoes ");
			System.out.println("\nInforme a opcao desejada: ");
			op = input.nextInt();
			input.nextLine();
			
			switch (op) {
			
			case 1:
				
				System.out.println("\n> CADASTRAR RESERVA");
				
				Reserva novaReserva = new Reserva();
				Hospede novoHospede = new Hospede();
				
				
				System.out.println("\nInforme o nome do hospede: ");
				String nomeHospede = input.nextLine();
				novoHospede.setNomeHospede(nomeHospede);
				
				boolean quartoValido;
				int numeroQuarto;
				
				do {
				System.out.println("Informe o numero do quarto: ");
				numeroQuarto = input.nextInt();
				input.nextLine(); // Consome o restante da linha
				novaReserva.setNumeroQuarto(numeroQuarto);
					
				quartoValido = true;
		        for (Reserva reserva : cadastroReserva) {
		            if (reserva.getNumeroQuarto() == numeroQuarto) {
		                quartoValido = false;
		                System.out.println("Numero de quarto inválido. Tente novamente.");
		                break;
		            }
		        }
		    } while (!quartoValido);
				
				
				System.out.println("Informe o valor da reserva: ");
				float valorReserva = input.nextFloat();
				input.nextLine(); // Consome o restante da linha
				novaReserva.setValorReserva(valorReserva);				
				
				System.out.println("Informe a data e a hora do check-in (dd/MM/yyyy  hh:mm): ");
				String dataCheckIn = input.nextLine();
				novaReserva.setDataCheckIn(dataCheckIn);
				
				System.out.println("Informe a data e a hora do check-out (dd/MM/yyyy  hh:mm): ");
				String dataCheckOut = input.nextLine();
				novaReserva.setDataCheckOut(dataCheckOut);
				
				// Esta linha gera um código único para a reserva recém-criada. 
				//O código é baseado no número atual de reservas na lista 'cadastroReserva'.
				novaReserva.setCodigoReserva(cadastroReserva.size() + 1);
				
				 novaReserva.setHospede(novoHospede);  // Associou o Hospede à Reserva				 
				 cadastroReserva.add(novaReserva);
			
				System.out.println("\n ==> Reserva cadastrada com sucesso! <==\n");
				
				break;
				
			case 2:
				
				System.out.println("\n> LISTAR RESERVA\n");
								
				for (Reserva reservas : cadastroReserva) {
					
					System.out.println("Codigo da reserva: " + reservas.getCodigoReserva());
					// Adicionado a impressão do código da reserva
					System.out.println("Nome do hospede: " + reservas.getHospede().getNomeHospede());
					// reservas.getHospede() é um método chamado na instância reservas da classe Reserva. 
					// Esse método retorna o objeto Hospede que foi associado à reserva.
					// .getNomeHospede() é outro método chamado no objeto Hospede que acabamos de obter. 
					// Esse método retorna o nome do hóspede como uma string.
					
					System.out.println("Numero do quarto: " + reservas.getNumeroQuarto());
					System.out.println("Valor da reserva: " + reservas.getValorReserva());
					System.out.println("Data e hora do Check-in: " + reservas.getDataCheckIn());
					System.out.println("Data e hora do Check-out: " + reservas.getDataCheckOut());
					System.out.println("\n\n");
				}
			
				break;
				
			case 3:
				
				 System.out.println("\n> EXCLUIR RESERVA: ");
				 
	//isEmpty:  Este método é usado para verificar se a lista reservasParaExcluir está vazia ou não. 
	//Se a lista estiver vazia, isso significa que nenhuma reserva com o código fornecido foi encontrada na lista cadastroReserva.
	//Portanto, !reservasParaExcluir.isEmpty() retorna true se pelo menos uma reserva foi encontrada para exclusão
	// e false se nenhuma reserva foi encontrada.
				 
				 
   //removeAll: Este método é usado para remover todas as reservas da lista cadastroReserva que também estão presentes na lista reservasParaExcluir.
  //Em outras palavras, ele remove todas as reservas que têm o mesmo código que o usuário forneceu.
 //Se pelo menos uma reserva foi removida, o método retorna true, caso contrário, retorna false.
				    
				    System.out.println("\nInforme o codigo da reserva que deseja excluir: ");
				    int codigoReserva = input.nextInt();
				    input.nextLine(); // Consome o restante da linha
				    
				    ArrayList <Reserva> reservasParaExcluir = new ArrayList<>();
				    
				    for (Reserva reserva : cadastroReserva) {
				        if(reserva.getCodigoReserva() == codigoReserva) { // Verifica se o código da reserva atual é igual ao código fornecido pelo usuário.
				            reservasParaExcluir.add(reserva); // Se o código da reserva for igual ao código fornecido pelo usuário, adiciona a reserva à lista 'reservasParaExcluir'.
				        }
				    }
				    
				    if (!reservasParaExcluir.isEmpty()) {
				        cadastroReserva.removeAll(reservasParaExcluir); // Remove todas as reservas na lista 'reservasParaExcluir' da lista 'cadastroReserva'.
				        System.out.println("\n ==> Reserva excluída! <==\n");
				    } else {
				        System.out.println("\n ==> Codigo invalido! <==\n");
				    }
				    				
				break;
				
			case 4:
				
				// Código de alterar reserva
				
				break;
				
			case 5:
				
				// Código de buscar reserva
				
				break;
				
			case 6:
				
				System.out.println("\n===>  Finalizando sistema...  <=== ");
				
	
				 break;
				
}		
}	while(op != 6);
}
}




		

