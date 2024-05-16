package controle;

import java.util.List;

import modelo.Reserva;

import java.util.ArrayList;



public class reservaDAO {

	

	  private ArrayList<Reserva> cadastroReserva;



	   public reservaDAO() {

	       this.cadastroReserva = new ArrayList<>();

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