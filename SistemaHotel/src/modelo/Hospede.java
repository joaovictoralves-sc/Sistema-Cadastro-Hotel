package modelo;

import java.util.ArrayList;

import java.util.List;



public class Hospede {

	

	 private String nomeHospede;

	   private List<Reserva> reservas;



	   public Hospede() {

	       this.reservas = new ArrayList<>();

	   }



	   public String getNomeHospede() {

	       return nomeHospede;

	   }



	   public void setNomeHospede(String nomeHospede) {

	       this.nomeHospede = nomeHospede;

	   }



	   public List<Reserva> getReservas() {

	       return reservas;

	   }



	   public void setReservas(List<Reserva> reservas) {

	       this.reservas = reservas;

	   }

	}