package carfire.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carfire.web.model.to.ClientePessoaJuridicaTO;
import carfire.web.util.ConectaMySQL;


public class ClientePessoaJuridicaDAO {	


	
	/**
	 * 
	 * @param clienteTO
	 * @return
	 */
	public boolean inserir(ClientePessoaJuridicaTO clienteTO) {	
		String sqlInsert = "INSERT INTO cliente_pj "
    			+ "(email, telefone, endereco, bairro, cidade, estado, cep, "
    			+ "cnpj, razao_social, nome_comercial, inscricao_estadual, data_fundacao, numero_funcionarios) "
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
    		
    		stm.setLong(8, clienteTO.getCnpj());
    		stm.setString(9, clienteTO.getRazao_social());
    		stm.setString(10, clienteTO.getNome_comercial());
    		stm.setString(11, clienteTO.getInscricao_estadual());
    		stm.setString(12, clienteTO.getData_fundacao());
    		stm.setInt(13, clienteTO.getNumero_funcionarios());
    		
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
	public boolean editar(ClientePessoaJuridicaTO clienteTO) {		
		String sqlUpdate = "UPDATE cliente_pj SET "
    			+ "email = ?, telefone = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, "
    			+ "cnpj = ?, razao_social = ?, nome_comercial = ?, inscricao_estadual = ?, data_fundacao = ?, numero_funcionarios = ? "
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
    		
    		stm.setLong(8, clienteTO.getCnpj());
    		stm.setString(9, clienteTO.getRazao_social());
    		stm.setString(10, clienteTO.getNome_comercial());
    		stm.setString(11, clienteTO.getInscricao_estadual());
    		stm.setString(12, clienteTO.getData_fundacao());
    		stm.setInt(13, clienteTO.getNumero_funcionarios());
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
		String sqlDelete = "DELETE FROM cliente_pj WHERE id = ?";

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
	 * @param cnpj
	 * @return
	 */
	public static boolean consultar(long cnpj) {		
		String sql = "SELECT * FROM cliente_pj WHERE cnpj = ?";
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;    
    
        try {                    	
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);
            stm.setLong(1, cnpj);            
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
	public ArrayList<ClientePessoaJuridicaTO> listarItens() {
		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
        
        ArrayList<ClientePessoaJuridicaTO> clientes = new ArrayList<ClientePessoaJuridicaTO>();
    
        try {            
        	String sql = "SELECT * FROM cliente_pj";
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {
            	ClientePessoaJuridicaTO clienteTO = new ClientePessoaJuridicaTO();
            	clienteTO.setId(rs.getInt("id"));            	
            	clienteTO.setEmail(rs.getString("email"));
            	clienteTO.setTelefone(rs.getString("telefone"));
            	clienteTO.setEndereco(rs.getString("endereco"));
            	clienteTO.setBairro(rs.getString("bairro"));
            	clienteTO.setCidade(rs.getString("cidade"));
            	clienteTO.setEstado(rs.getString("estado"));
            	clienteTO.setCep(rs.getString("cep"));
            	
            	clienteTO.setCnpj(rs.getLong("cnpj"));
            	clienteTO.setRazao_social(rs.getString("razao_social"));
            	clienteTO.setNome_comercial(rs.getString("nome_comercial"));            	           	
            	clienteTO.setInscricao_estadual(rs.getString("inscricao_estadual"));
            	clienteTO.setData_fundacao(rs.getString("data_fundacao")); 
            	clienteTO.setNumero_funcionarios(rs.getInt("numero_funcionarios"));
        		
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
