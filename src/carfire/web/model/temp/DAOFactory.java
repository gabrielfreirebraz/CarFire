package carfire.web.model.temp;



public abstract class DAOFactory {

    /**
     * Cria um novo DAOFactory. O tipo real é definido por: 
     * A propriedade bexee.dao.factory. 
     * 
     * Se não estiver definido, então MemoryDAOFactory será criado.
     */
    public static DAOFactory getInstance() {
    	return getInstance();
    }

    /**
     * As fábricas concretas implementarão este método
     */
    public abstract IPessoaFisicaDAO createPessoaFisicaDAO();

    /**
     * As fábricas concretas implementarão este método
     */
    public abstract IPessoaJuridicaDAO createPessoaJuridicaDAO();
}
