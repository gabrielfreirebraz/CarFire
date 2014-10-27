package carfire.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carfire.web.model.to.DevolucaoTO;
import carfire.web.util.ConectaMySQL;

public class DevolucaoDAO {
	

	public ArrayList<DevolucaoTO> listarItens() {		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
       
        ArrayList<DevolucaoTO> devolucoes = new ArrayList<DevolucaoTO>();
    
        try {            
        	String sql = "SELECT * FROM devolucao";
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	DevolucaoTO devolucao = new DevolucaoTO();
            	devolucao.setId(rs.getLong("id")); 
            	devolucao.setAgencia_id(rs.getLong("agencia_id")); 
            	devolucao.setData(rs.getString("data"));
            	devolucao.setHora(rs.getString("hora"));
        		
            	devolucoes.add(devolucao);
            }     
            rs.close();            
            return devolucoes;            
            
        } catch (SQLException e) {            
            e.printStackTrace();
            try {
                conexao.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return devolucoes;
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
	public boolean inserir(DevolucaoTO devolucao) {
		String sqlInsert = "INSERT INTO devolucao "
				+ "(agencia_id, data, hora) "
				+ "VALUES (?, ?, ?)";
		
		PreparedStatement stm = null;
		Connection conexao = null;		

		try {
			conexao = ConectaMySQL.getConexao();			
			stm = conexao.prepareStatement(sqlInsert);
			
			stm.setLong(1, devolucao.getAgencia_id());
			stm.setString(2, devolucao.getData());
			stm.setString(3, devolucao.getHora());
        	
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
	public boolean editar(DevolucaoTO devolucao) {
		String sqlUpdate = "UPDATE devolucao SET "
				+ "agencia_id = ?, data = ?, hora = ? "
				+ "WHERE id = ?";

		PreparedStatement stm = null;
		Connection conexao = null;		

		try {
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlUpdate);
			
			stm.setLong(1, devolucao.getAgencia_id());
			stm.setString(2, devolucao.getData());
        	stm.setString(3, devolucao.getHora());
        	stm.setLong(4, devolucao.getId());
			
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
		String sqlDelete = "DELETE FROM devolucao WHERE id = ?";

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
