package carfire.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carfire.web.model.to.ClientePessoaFisicaTO;
import carfire.web.util.ConectaMySQL;


public class ClientePessoaFisicaDAO {

	


	/**
	 * 
	 * @param clienteTO
	 * @return
	 */
	public boolean inserir(ClientePessoaFisicaTO clienteTO) {		
		String sqlInsert = "INSERT INTO cliente_pf "
    			+ "(email, telefone, endereco, bairro, cidade, estado, cep, "
    			+ "cpf, nome, rg, habilitacao, data_nascimento, genero) "
    			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stm = null;
        Connection conexao = null;        
        
        try {
        	conexao = ConectaMySQL.getConexao();           
    		stm = conexao.prepareStatement(sqlInsert);
    		
    		stm.setString(1, clienteTO.getEmail());
    		stm.setString(2, clienteTO.getTelefone());
    		stm.setString(3, clienteTO.getEndereco());
    		stm.setString(4, clienteTO.getBairro());
    		stm.setString(5, clienteTO.getCidade());
    		stm.setString(6, clienteTO.getEstado());
    		stm.setString(7, clienteTO.getCep());
    		
    		stm.setLong(8, clienteTO.getCpf());
    		stm.setString(9, clienteTO.getNome());
    		stm.setString(10, clienteTO.getRg());
    		stm.setString(11, clienteTO.getHabilitacao());
    		stm.setString(12, clienteTO.getData_nascimento());
    		stm.setString(13, clienteTO.getGenero());
    		
    		return stm.execute();            
        } catch (SQLException e) {
        	
            System.out.print(e.getMessage());
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
                    stm.close();
                }
                catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        }
	}


	
	/**
	 * 
	 * @param clienteTO
	 * @return
	 */
	public boolean editar(ClientePessoaFisicaTO clienteTO) {		
		String sqlUpdate = "UPDATE cliente_pf SET "
    			+ "email = ?, telefone = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, "
    			+ "cpf = ?, nome = ?, rg = ?, habilitacao = ?, data_nascimento = ?, genero = ? "
    			+ "WHERE id = ?";
		
		Connection conexao = null;
		PreparedStatement stm = null;		
		
		try {			
			conexao = ConectaMySQL.getConexao();  
			stm = conexao.prepareStatement(sqlUpdate);
    		
    		stm.setString(1, clienteTO.getEmail());
    		stm.setString(2, clienteTO.getTelefone());
    		stm.setString(3, clienteTO.getEndereco());
    		stm.setString(4, clienteTO.getBairro());
    		stm.setString(5, clienteTO.getCidade());
    		stm.setString(6, clienteTO.getEstado());
    		stm.setString(7, clienteTO.getCep());
    		
    		stm.setLong(8, clienteTO.getCpf());
    		stm.setString(9, clienteTO.getNome());
    		stm.setString(10, clienteTO.getRg());
    		stm.setString(11, clienteTO.getHabilitacao());
    		stm.setString(12, clienteTO.getData_nascimento());
    		stm.setString(13, clienteTO.getGenero());
    		stm.setLong(14, clienteTO.getId());
    		
    		return stm.execute();            		
		} catch (Exception e) {
			
			e.printStackTrace();
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return false;			
		} 
		finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}

	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean excluir(long id) {	
		String sqlDelete = "DELETE FROM cliente_pf WHERE id = ?";

		PreparedStatement stm = null;
		Connection conexao = null;
		
		try {		
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlDelete);	
			
			stm.setLong(1, id);
			return stm.execute();
						
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return false;
		} 
		finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}		
	}
	
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	public static boolean consultar(long cpf) {		
		String sql = "SELECT * FROM cliente_pf WHERE cpf = ?";
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
	 * 
	 * @return
	 */
	public ArrayList<ClientePessoaFisicaTO> listarItens() {		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
        
        ArrayList<ClientePessoaFisicaTO> clientes = new ArrayList<ClientePessoaFisicaTO>();
    
        try {            
        	String sql = "SELECT * FROM cliente_pf";
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {
            	ClientePessoaFisicaTO clienteTO = new ClientePessoaFisicaTO();
            	clienteTO.setId(rs.getInt("id"));            	
            	clienteTO.setEmail(rs.getString("email"));
            	clienteTO.setTelefone(rs.getString("telefone"));
            	clienteTO.setEndereco(rs.getString("endereco"));
            	clienteTO.setBairro(rs.getString("bairro"));
            	clienteTO.setCidade(rs.getString("cidade"));
            	clienteTO.setEstado(rs.getString("estado"));
            	clienteTO.setCep(rs.getString("cep"));
            	
            	clienteTO.setCpf(rs.getLong("cpf"));
            	clienteTO.setNome(rs.getString("nome"));
            	clienteTO.setRg(rs.getString("rg"));            	           	
            	clienteTO.setHabilitacao(rs.getString("habilitacao"));
            	clienteTO.setData_nascimento(rs.getString("data_nascimento")); 
            	clienteTO.setGenero(rs.getString("genero"));
        		
        		clientes.add(clienteTO);
            }
            rs.close();            
            return clientes;            
            
        } catch (SQLException e) {            
            e.printStackTrace();
            try {
                conexao.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return clientes;
        }
        finally{
            if (stm != null) {
                try {
                    stm.close();
                }
                catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        }		
	}
}
