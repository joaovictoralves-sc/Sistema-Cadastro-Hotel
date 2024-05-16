package modelo;

import java.util.ArrayList;

import java.util.List;



public class Reserva {

	

	 private Hospede hospede;

	   private Integer numeroQuarto;

	   private double valorReserva;

	   private String dataCheckIn;

	   private String dataCheckOut;

	   private int codigoReserva; 



	   public Reserva() {

	       this.hospede = new Hospede();

	   }





	   public Hospede getHospede() {

	       return hospede;

	   }



	   public void setHospede(Hospede hospede) {

	       this.hospede = hospede;

	   }



	   public Integer getNumeroQuarto() {

	       return numeroQuarto;

	   }



	   public void setNumeroQuarto(Integer numeroQuarto) {

	       this.numeroQuarto = numeroQuarto;

	   }



	   public double getValorReserva() {

	       return valorReserva;

	   }



	   public void setValorReserva(double valorReserva) {

	       this.valorReserva = valorReserva;

	   }



	   public String getDataCheckIn() {

	       return dataCheckIn;

	   }



	   public void setDataCheckIn(String dataCheckIn) {

	       this.dataCheckIn = dataCheckIn;

	   }



	   public String getDataCheckOut() {

	       return dataCheckOut;

	   }



	   public void setDataCheckOut(String dataCheckOut) {

	       this.dataCheckOut = dataCheckOut;

	   }



	   public int getCodigoReserva() {

	       return codigoReserva;

	   }



	   public void setCodigoReserva(int codigoReserva) {

	       this.codigoReserva = codigoReserva;

	   }

	}

