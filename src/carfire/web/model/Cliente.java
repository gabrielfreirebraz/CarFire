package carfire.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import carfire.web.util.ConectaMySQL;

abstract public class Cliente {

	protected int id = 0;
	protected String email     = null;
	protected String telefone  = null;	
	protected String endereco  = null;
	protected String bairro    = null;
	protected String cidade    = null;
	protected String estado    = null;
	protected String cep       = null;
	protected String tipo      = null;

	

	/**
	 * Métodos para serem implementados em classes filhas
	 */
//	abstract protected boolean inserir(); 
//	
//	abstract protected boolean editar();
//	
//	abstract protected boolean excluir(); 
	
	
	
	
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
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
	
	
}
