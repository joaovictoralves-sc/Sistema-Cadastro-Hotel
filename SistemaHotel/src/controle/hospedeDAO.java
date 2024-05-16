package controle;

import modelo.Hospede;

import java.util.ArrayList;

import java.util.List;



public class hospedeDAO {

	

	 private ArrayList<Hospede> cadastroHospede;



	   public hospedeDAO() {

	       this.cadastroHospede = new ArrayList<>();

	   }



	   public void cadastrarHospede(Hospede hospede) {

	       cadastroHospede.add(hospede);

	   }



	   public List<Hospede> listarHospedes() {

	       return this.cadastroHospede;

	   }



	   public boolean excluirHospede(String nome) {

	       for (Hospede hospede : cadastroHospede) {

	           if (hospede.getNomeHospede().equals(nome)) {

	               cadastroHospede.remove(hospede);

	               return true;

	           }

	       }

	       return false;

	   }



	}