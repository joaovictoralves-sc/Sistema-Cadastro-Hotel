package modelo;

public class Reserva {
    private Hospede hospede; 
    private Integer numeroQuarto; 
    private double valorReserva; 
    private String dataCheckIn; 
    private String dataCheckOut;
    private Integer codigoReserva;
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
	public Integer getCodigoReserva() {
		return codigoReserva;
	}
	public void setCodigoReserva(Integer codigoReserva) {
		this.codigoReserva = codigoReserva;
	}
}
