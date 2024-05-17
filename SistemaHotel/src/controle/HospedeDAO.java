package controle;

import modelo.Hospede;
import java.util.ArrayList;
import java.util.List;

public class HospedeDAO {

    private static HospedeDAO instance;
    private List<Hospede> cadastroHospede;

    private HospedeDAO() {
        this.cadastroHospede = new ArrayList<>();
    }

    public static synchronized HospedeDAO getInstance() {
        if (instance == null) {
            instance = new HospedeDAO();
        }
        return instance;
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
