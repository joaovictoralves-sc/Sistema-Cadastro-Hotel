package controle;

import modelo.Reserva;
import modelo.Hospede;
import java.util.List;

public interface ReservaDAO {
    void cadastrarReserva(Reserva reserva);
    List<Reserva> listarReservas();
    void excluirReserva(int codigoReserva);
    void alterarReserva(int codigoReserva, double novoValor, String novaDataCheckIn, String novaDataCheckOut);
    Reserva buscarReserva(int codigoReserva);
}