package visao;
import java.util.Scanner;

import modelo.Hospede;
import modelo.Reserva;

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
				input.nextLine(); 
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
				double valorReserva = input.nextDouble();
				input.nextLine(); 
				novaReserva.setValorReserva(valorReserva);				
				
				System.out.println("Informe a data e a hora do check-in (dd/MM/yyyy  hh:mm): ");
				String dataCheckIn = input.nextLine();
				novaReserva.setDataCheckIn(dataCheckIn);
				
				System.out.println("Informe a data e a hora do check-out (dd/MM/yyyy  hh:mm): ");
				String dataCheckOut = input.nextLine();
				novaReserva.setDataCheckOut(dataCheckOut);
				novaReserva.setCodigoReserva(cadastroReserva.size() + 1);
				
				 novaReserva.setHospede(novoHospede); 			 
				 cadastroReserva.add(novaReserva);
			
				System.out.println("\n ==> Reserva cadastrada com sucesso! <==\n");
				
				break;
				
			case 2:
				
				System.out.println("\n> LISTAR RESERVA\n");
								
				for (Reserva reservas : cadastroReserva) {
					
					System.out.println("Codigo da reserva: " + reservas.getCodigoReserva());			
					System.out.println("Nome do hospede: " + reservas.getHospede().getNomeHospede());				
					System.out.println("Numero do quarto: " + reservas.getNumeroQuarto());
					System.out.println("Valor da reserva: R$" + reservas.getValorReserva());
					System.out.println("Data e hora do Check-in: " + reservas.getDataCheckIn());
					System.out.println("Data e hora do Check-out: " + reservas.getDataCheckOut());
					System.out.println("\n\n");
				}
			
				break;
				
			case 3:
				
				 System.out.println("\n> EXCLUIR RESERVA: ");
				    
				    System.out.println("\nInforme o codigo da reserva que deseja excluir: ");
				    int codigoReserva = input.nextInt();
				    input.nextLine(); 
				    
				    ArrayList <Reserva> reservasParaExcluir = new ArrayList<>();
				    
				    for (Reserva reserva : cadastroReserva) {
				        if(reserva.getCodigoReserva() == codigoReserva) { 
				            reservasParaExcluir.add(reserva); 
				        }
				    }
				    
				    if (!reservasParaExcluir.isEmpty()) {
				        cadastroReserva.removeAll(reservasParaExcluir); 
				        System.out.println("\n ==> Reserva excluída! <==\n");
				    } else {
				        System.out.println("\n ==> Codigo invalido! <==\n");
				    }
				    				
				break;
				

            case 4:
                System.out.println("\n> ALTERAR RESERVA\n");

                System.out.println("\nInforme o código da reserva que deseja alterar: ");
                int codigoReservaAlterar = input.nextInt();
                input.nextLine(); 

                boolean reservaEncontradaAlterar = false;

                for (Reserva reserva : cadastroReserva) {
                    if (reserva.getCodigoReserva() == codigoReservaAlterar) {
                        System.out.println("Informe o novo valor da reserva: ");
                        double novoValor = input.nextDouble();
                        input.nextLine(); 
                        reserva.setValorReserva(novoValor);

                        System.out.println("Informe a nova data e hora do check-in (dd/MM/yyyy hh:mm): ");
                        String novaDataCheckIn = input.nextLine();
                        reserva.setDataCheckIn(novaDataCheckIn);

                        System.out.println("Informe a nova data e hora do check-out (dd/MM/yyyy hh:mm): ");
                        String novaDataCheckOut = input.nextLine();
                        reserva.setDataCheckOut(novaDataCheckOut);

                        System.out.println("\n ==> Reserva alterada com sucesso! <==\n");
                        reservaEncontradaAlterar = true;
                        break; 
                    }
                }

                if (!reservaEncontradaAlterar) {
                    System.out.println("\n ==> Reserva não encontrada! <==\n");
                }
                break;

            case 5:
                System.out.println("\n> BUSCAR RESERVA\n");

                System.out.println("\nInforme o código da reserva que deseja buscar: ");
                int codigoReservaBuscar = input.nextInt();
                input.nextLine(); 

                boolean reservaEncontradaBusca = false;

                for (Reserva reserva : cadastroReserva) {
                    if (reserva.getCodigoReserva() == codigoReservaBuscar) {
                        System.out.println("Reserva encontrada:");
                        System.out.println("Código da reserva: " + reserva.getCodigoReserva());
                        System.out.println("Nome do hóspede: " + reserva.getHospede().getNomeHospede());
                        System.out.println("Número do quarto: " + reserva.getNumeroQuarto());
                        System.out.println("Valor da reserva: R$" + reserva.getValorReserva());
                        System.out.println("Data e hora do check-in: " + reserva.getDataCheckIn());
                        System.out.println("Data e hora do check-out: " + reserva.getDataCheckOut());
                        System.out.println();
                        reservaEncontradaBusca = true;
                        break; 
                    }
                }

                if (!reservaEncontradaBusca) {
                    System.out.println("\n ==> Reserva não encontrada! <==\n");
                }
                break;

				
			case 6:
				
				System.out.println("\n===>  Finalizando sistema...  <=== ");
				
	
				 break;
				
}		
}	while(op != 6);
}
}




		

