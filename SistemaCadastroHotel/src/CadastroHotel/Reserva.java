package CadastroHotel;

public class Reserva {
	
	private Hospede hospede; 
	private Integer numeroQuarto; 
	private Integer valorReserva; 
	private String dataCheckIn; 
	private String dataCheckOut;
	
	
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
	public Integer getValorReserva() {
		return valorReserva;
	}
	public void setValorReserva(Integer valorReserva) {
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

	
	 

}
