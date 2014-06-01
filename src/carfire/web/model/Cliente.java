package carfire.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import carfire.web.util.ConectaMySQL;

abstract public class Cliente {

	private String telefone  = null;
	private String email     = null;
	private String endereco  = null;
	private String cidade    = null;
	private String estado    = null;
	private String cep       = null;
	private String tipo      = null;

	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}	
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public static boolean consultar(long cpf) {
	
		
		String sql = "SELECT * FROM cliente WHERE cpf = ?";
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;    
    
        try {                    	
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);
            stm.setLong(1, cpf);
            
            rs = stm.executeQuery();            
                        
            if (rs.next())
            	return true;
            
            return false;
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
            	conexao.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return false;
        }
        finally{
            if (stm != null) {
                try {
                	rs.close();
                    stm.close();
                }
                catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        }

	}
	
	
	/**
	 * Métodos para serem implementados em classes filhas
	 */
	abstract protected boolean inserir(); 
	
	abstract protected boolean editar();
	
	abstract protected boolean excluir(); 
}
