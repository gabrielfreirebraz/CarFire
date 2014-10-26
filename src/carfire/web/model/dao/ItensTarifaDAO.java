package carfire.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carfire.web.model.to.ItensTarifaTO;
import carfire.web.util.ConectaMySQL;

public class ItensTarifaDAO {
	

	public ArrayList<ItensTarifaTO> listarItens() {		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
       
        ArrayList<ItensTarifaTO> itensTarifa = new ArrayList<ItensTarifaTO>();
    
        try {            
        	String sql = "SELECT * FROM itens_tarifa";
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	ItensTarifaTO itemTarifa = new ItensTarifaTO();
            	itemTarifa.setGrupo_id(rs.getLong("grupo_id"));
            	itemTarifa.setTarifa_id(rs.getLong("tarifa_id"));
            	itemTarifa.setDescricao(rs.getString("descricao"));        		
        		
            	itensTarifa.add(itemTarifa);
            }     
            rs.close();            
            return itensTarifa;            
            
        } catch (SQLException e) {            
            e.printStackTrace();
            try {
                conexao.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return itensTarifa;
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
	public ArrayList<ItensTarifaTO> listarItensByGrupo(long grupo_id) {		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
       
        ArrayList<ItensTarifaTO> itensTarifa = new ArrayList<ItensTarifaTO>();
    
        try {            
        	String sql = "SELECT * FROM itens_tarifa WHERE grupo_id = ?";
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql); 
            stm.setLong(1, grupo_id);
            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	ItensTarifaTO itemTarifa = new ItensTarifaTO();
            	itemTarifa.setGrupo_id(rs.getLong("grupo_id"));
            	itemTarifa.setTarifa_id(rs.getLong("tarifa_id"));
            	itemTarifa.setDescricao(rs.getString("descricao"));        		
        		
            	itensTarifa.add(itemTarifa);
            }     
            rs.close();            
            return itensTarifa;            
            
        } catch (SQLException e) {            
            e.printStackTrace();
            try {
                conexao.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return itensTarifa;
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
	public boolean inserir(ItensTarifaTO itemTarifa) {
		String sqlInsert = "INSERT INTO itens_tarifa "
				+ "(grupo_id, tarifa_id, descricao) "
				+ "VALUES (?, ?, ?)";
		
		PreparedStatement stm = null;
		Connection conexao = null;		

		try {
			conexao = ConectaMySQL.getConexao();			
			stm = conexao.prepareStatement(sqlInsert);
			
        	stm.setLong(1, itemTarifa.getGrupo_id());
        	stm.setLong(2, itemTarifa.getTarifa_id());
        	stm.setString(3, itemTarifa.getDescricao());
        	
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
	public boolean editar(ItensTarifaTO itemTarifa) {
		String sqlUpdate = "UPDATE itens_tarifa SET "
				+ "tarifa_id = ?, descricao = ? "
				+ "WHERE grupo_id = ?";

		PreparedStatement stm = null;
		Connection conexao = null;		

		try {
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlUpdate);
			        		
        	stm.setLong(1, itemTarifa.getTarifa_id());
        	stm.setString(2, itemTarifa.getDescricao());
        	stm.setLong(3, itemTarifa.getGrupo_id());
			
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
	public boolean excluir(long grupo_id, long tarifa_id) {		
		String sqlDelete = "DELETE FROM itens_tarifa WHERE grupo_id = ? and tarifa_id = ?";

		PreparedStatement stm = null;
		Connection conexao = null;
		
		try {		
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlDelete);	
			
			stm.setLong(1, grupo_id);
			stm.setLong(2, tarifa_id);
			
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
