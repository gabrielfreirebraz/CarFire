package carfire.web.model.temp;



public class ClienteDAOFactory extends DAOFactory {


    public IPessoaFisicaDAO createPessoaFisicaDAO() {
    	return new ClientePessoaFisicaDAO();
    }
    public IPessoaJuridicaDAO createPessoaJuridicaDAO() {
    	return new ClientePessoaJuridicaDAO();
    }
    
}
