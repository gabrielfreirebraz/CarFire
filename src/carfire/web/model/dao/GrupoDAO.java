package carfire.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carfire.web.model.to.GrupoTO;
import carfire.web.util.ConectaMySQL;

public class GrupoDAO {
	

	public static ArrayList<GrupoTO> listarItens() {		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
        
        ArrayList<GrupoTO> grupos = new ArrayList<GrupoTO>();
    
        try {            
        	String sql = "SELECT * FROM grupo";
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	GrupoTO grupo = new GrupoTO();
            	grupo.setId(rs.getLong("id"));
            	grupo.setSigla(rs.getString("sigla")); 
            	grupo.setNome(rs.getString("nome"));        		
        		
            	grupos.add(grupo);
            }     
            rs.close();            
            return grupos;            
            
        } catch (SQLException e) {            
            e.printStackTrace();
            try {
                conexao.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return grupos;
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
	public boolean inserir(GrupoTO grupo) {
		String sqlInsert = "INSERT INTO grupo "
				+ "(sigla, nome) "
				+ "VALUES (?, ?)";
		
		PreparedStatement stm = null;
		Connection conexao = null;
		

		try {
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlInsert);
			
        	stm.setString(1, grupo.getSigla());
        	stm.setString(2, grupo.getNome());
						
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
	public boolean editar(GrupoTO grupo) {
		String sqlUpdate = "UPDATE grupo SET "
				+ "sigla = ?, nome = ? "
				+ "WHERE id = ?";

		PreparedStatement stm = null;
		Connection conexao = null;		

		try {
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlUpdate);
			
        	stm.setString(1, grupo.getSigla());
        	stm.setString(2, grupo.getNome());	
        	stm.setLong(3, grupo.getId());
			
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
		String sqlDelete = "DELETE FROM grupo WHERE id = ?";

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
