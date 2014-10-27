package carfire.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carfire.web.model.to.AgenciaTO;
import carfire.web.util.ConectaMySQL;

public class AgenciaDAO {
	

	public ArrayList<AgenciaTO> listarItens() {		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
       
        ArrayList<AgenciaTO> agencias = new ArrayList<AgenciaTO>();
    
        try {            
        	String sql = "SELECT * FROM agencia";
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	AgenciaTO agencia = new AgenciaTO();
            	agencia.setId(rs.getLong("id"));
            	agencia.setCidade_id(rs.getLong("cidade_id")); 
            	agencia.setNome(rs.getString("nome"));
        		
            	agencias.add(agencia);
            }     
            rs.close();            
            return agencias;            
            
        } catch (SQLException e) {            
            e.printStackTrace();
            try {
                conexao.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return agencias;
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
	 * @return
	 */
	public ArrayList<AgenciaTO> listarAgenciasByCidade(long cidade_id) {		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
        
        ArrayList<AgenciaTO> agencias = new ArrayList<AgenciaTO>();
    
        try {            
        	String sql = "SELECT * FROM agencia WHERE cidade_id = ?";
        	conexao = ConectaMySQL.getConexao();
                    	
        	stm = conexao.prepareStatement(sql); 
            stm.setLong(1, cidade_id);
            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	AgenciaTO agencia = new AgenciaTO();
            	agencia.setId(rs.getLong("id"));
            	agencia.setCidade_id(rs.getLong("cidade_id"));
            	agencia.setNome(rs.getString("nome"));
        		
            	agencias.add(agencia);
            }     
            rs.close();            
            return agencias;            
            
        } catch (SQLException e) {            
            e.printStackTrace();
            try {
                conexao.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return agencias;
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
	 * @param veiculo
	 * @return
	 */
	public boolean inserir(AgenciaTO agencia) {
		String sqlInsert = "INSERT INTO agencia "
				+ "(cidade_id, nome) "
				+ "VALUES (?, ?)";
		
		PreparedStatement stm = null;
		Connection conexao = null;		

		try {
			conexao = ConectaMySQL.getConexao();			
			stm = conexao.prepareStatement(sqlInsert);
			
			stm.setLong(1, agencia.getCidade_id());
			stm.setString(2, agencia.getNome());
        	
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
		} finally {
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
	 * @param veiculo
	 * @return
	 */
	public boolean editar(AgenciaTO agencia) {
		String sqlUpdate = "UPDATE agencia SET "
				+ "cidade_id = ?, nome = ? "
				+ "WHERE id = ?";

		PreparedStatement stm = null;
		Connection conexao = null;		

		try {
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlUpdate);
			
			stm.setLong(1, agencia.getCidade_id());
			stm.setString(2, agencia.getNome());			
        	stm.setLong(3, agencia.getId());
			
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
		} finally {
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
		String sqlDelete = "DELETE FROM agencia WHERE id = ?";

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
}
