package carfire.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import carfire.web.util.ConectaMySQL;


public class Login {

	private String email;
	private String senha;
	
	
	
	public boolean consultar() {
		
		String sql = "SELECT * FROM usuario WHERE email = ? && senha = ?";
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;    
    
        try {                    	
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);
            stm.setString(1, this.email);
            stm.setString(2, this.senha);
            
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
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
