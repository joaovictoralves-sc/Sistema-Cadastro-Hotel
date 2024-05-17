package visao;

import controle.HospedeDAO;
import controle.ReservaDAO;
import modelo.Hospede;
import modelo.Reserva;

import java.util.List;
import java.util.Scanner;

public class SistemaMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ReservaDAO reservaDAO = ReservaDAO.getInstance();
        HospedeDAO hospedeDAO = HospedeDAO.getInstance();

        int op;

        do {
            System.out.println("MENU: ");
            System.out.println("\n1 - Cadastrar reserva");
            System.out.println("2 - Listar reserva");
            System.out.println("3 - Excluir reserva");
            System.out.println("4 - Alterar reserva");
            System.out.println("5 - Buscar reserva");
            System.out.println("6 - Sair do menu de opções");
            System.out.println("\nInforme a opção desejada: ");
            op = input.nextInt();
            input.nextLine();

            switch (op) {

                case 1:
                    System.out.println("\n> CADASTRAR RESERVA");

                    Reserva novaReserva = new Reserva();
                    Hospede novoHospede = null;

                    System.out.println("\nInforme o nome do hóspede: ");
                    String nomeHospede = input.nextLine();

                    for (Hospede hospede : hospedeDAO.listarHospedes()) {
                        if (hospede.getNomeHospede().equals(nomeHospede)) {
                            novoHospede = hospede;
                            break;
                        }
                    }

                    if (novoHospede == null) {
                        novoHospede = new Hospede();
                        novoHospede.setNomeHospede(nomeHospede);
                        hospedeDAO.cadastrarHospede(novoHospede);
                    }

                    novaReserva.setHospede(novoHospede);

                    System.out.println("Informe o número do quarto: ");
                    int numeroQuarto = input.nextInt();
                    novaReserva.setNumeroQuarto(numeroQuarto);

                    System.out.println("Informe o valor da reserva: ");
                    double valorReserva = input.nextDouble();
                    novaReserva.setValorReserva(valorReserva);

                    System.out.println("Informe a data e hora do check-in (dd/MM/yyyy hh:mm): ");
                    input.nextLine(); // Limpar o buffer
                    String dataCheckIn = input.nextLine();
                    novaReserva.setDataCheckIn(dataCheckIn);

                    System.out.println("Informe a data e hora do check-out (dd/MM/yyyy hh:mm): ");
                    String dataCheckOut = input.nextLine();
                    novaReserva.setDataCheckOut(dataCheckOut);

                    novaReserva.setCodigoReserva(reservaDAO.listarReservas().size() + 1);

                    reservaDAO.cadastrarReserva(novaReserva);

                    System.out.println("\n ==> Reserva cadastrada com sucesso! <==\n");
                    break;

                case 2:
                    System.out.println("\n> LISTAR RESERVA\n");

                    List<Reserva> reservas = reservaDAO.listarReservas();
                    if (reservas.isEmpty()) {
                        System.out.println("Não há reservas cadastradas.");
                    } else {
                        for (Reserva reserva : reservas) {
                            System.out.println("Código da reserva: " + reserva.getCodigoReserva());
                            System.out.println("Nome do hóspede: " + reserva.getHospede().getNomeHospede());
                            System.out.println("Número do quarto: " + reserva.getNumeroQuarto());
                            System.out.println("Valor da reserva: R$" + reserva.getValorReserva());
                            System.out.println("Data e hora do Check-in: " + reserva.getDataCheckIn());
                            System.out.println("Data e hora do Check-out: " + reserva.getDataCheckOut());
                            System.out.println("");
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n> EXCLUIR RESERVA: ");
                    System.out.println("\nInforme o código da reserva que deseja excluir: ");
                    int codigoReservaExcluir = input.nextInt();
                    input.nextLine();

                    if (reservaDAO.excluirReserva(codigoReservaExcluir)) {
                        System.out.println("\n ==> Reserva excluída! <==\n");
                    } else {
                        System.out.println("\n ==> Reserva não encontrada! <==\n");
                    }
                    break;

                case 4:
                    System.out.println("\n> ALTERAR RESERVA\n");

                    System.out.println("Informe o código da reserva que deseja alterar: ");
                    int codigoReservaAlterar = input.nextInt();
                    input.nextLine(); // Limpar o buffer

                    Reserva reservaParaAlterar = reservaDAO.buscarReserva(codigoReservaAlterar);

                    if (reservaParaAlterar != null) {
                        System.out.println("\nReserva encontrada:");
                        System.out.println("Código da reserva: " + reservaParaAlterar.getCodigoReserva());
                        System.out.println("Nome do hóspede: " + reservaParaAlterar.getHospede().getNomeHospede());
                        System.out.println("Número do quarto: " + reservaParaAlterar.getNumeroQuarto());
                        System.out.println("Valor da reserva: R$" + reservaParaAlterar.getValorReserva());
                        System.out.println("Data e hora do Check-in: " + reservaParaAlterar.getDataCheckIn());
                        System.out.println("Data e hora do Check-out: " + reservaParaAlterar.getDataCheckOut());

                        System.out.println("\nInforme os novos dados da reserva:");

                        System.out.println("\nNovo nome do hóspede: ");
                        String novoNomeHospede = input.nextLine();
                        reservaParaAlterar.getHospede().setNomeHospede(novoNomeHospede);

                        System.out.println("Novo número do quarto: ");
                        int novoNumeroQuarto = input.nextInt();
                        reservaParaAlterar.setNumeroQuarto(novoNumeroQuarto);

                        System.out.println("Novo valor da reserva: ");
                        double novoValorReserva = input.nextDouble();
                        reservaParaAlterar.setValorReserva(novoValorReserva);

                        System.out.println("Nova data e hora do Check-in (dd/MM/yyyy hh:mm): ");
                        input.nextLine(); // Limpar o buffer
                        String novaDataCheckIn = input.nextLine();
                        reservaParaAlterar.setDataCheckIn(novaDataCheckIn);

                        System.out.println("Nova data e hora do Check-out (dd/MM/yyyy hh:mm): ");
                        String novaDataCheckOut = input.nextLine();
                        reservaParaAlterar.setDataCheckOut(novaDataCheckOut);

                        System.out.println("\n ==> Reserva alterada com sucesso! <==\n");
                    } else {
                        System.out.println("\n ==> Reserva não encontrada! <==\n");
                    }
                    break;

                case 5:
                    System.out.println("\n> BUSCAR RESERVA\n");
                    System.out.println("\nInforme o código da reserva que deseja buscar: ");
                    int codigoReservaBuscar = input.nextInt();
                    input.nextLine();

                    Reserva reservaEncontrada = reservaDAO.buscarReserva(codigoReservaBuscar);
                    if (reservaEncontrada != null) {
                        System.out.println("\nReserva encontrada:");
                        System.out.println("Código da reserva: " + reservaEncontrada.getCodigoReserva());
                        System.out.println("Nome do hóspede: " + reservaEncontrada.getHospede().getNomeHospede());
                        System.out.println("Numero do quarto: " + reservaEncontrada.getNumeroQuarto());
                        System.out.println("Valor da reserva: R$" + reservaEncontrada.getValorReserva());
                        System.out.println("Data e hora do Check-in: " + reservaEncontrada.getDataCheckIn());
                        System.out.println("Data e hora do Check-out: " + reservaEncontrada.getDataCheckOut());
                    } else {
                        System.out.println("\n ==> Reserva não encontrada! <==\n");
                    }
                    break;

                case 6:
                    System.out.println("\n===>  Finalizando sistema...  <=== ");
                    break;
            }
        } while (op != 6);

        input.close();
    }
}
