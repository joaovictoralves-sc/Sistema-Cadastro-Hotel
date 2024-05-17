package controle;

import modelo.Reserva;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    private static ReservaDAO instance;
    private List<Reserva> cadastroReserva;

    private ReservaDAO() {
        this.cadastroReserva = new ArrayList<>();
    }

    public static synchronized ReservaDAO getInstance() {
        if (instance == null) {
            instance = new ReservaDAO();
        }
        return instance;
    }

    public void cadastrarReserva(Reserva reserva) {
        cadastroReserva.add(reserva);
    }

    public List<Reserva> listarReservas() {
        return this.cadastroReserva;
    }

    public boolean excluirReserva(int codigo) {
        for (Reserva reserva : cadastroReserva) {
            if (reserva.getCodigoReserva() == codigo) {
                cadastroReserva.remove(reserva);
                return true;
            }
        }
        return false;
    }

    public Reserva buscarReserva(int codigo) {
        for (Reserva reserva : cadastroReserva) {
            if (reserva.getCodigoReserva() == codigo) {
                return reserva;
            }
        }
        return null;
    }
}
