package carfire.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carfire.web.model.to.ItensEmprestimoTO;
import carfire.web.util.ConectaMySQL;

public class ItensEmprestimoDAO {
	

	public ArrayList<ItensEmprestimoTO> listarItens(long idEmprestimo) {		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
       
        ArrayList<ItensEmprestimoTO> listaItens_emprestimo = new ArrayList<ItensEmprestimoTO>();
    
        try {            
        	String sql = "SELECT * FROM itens_emprestimo WHERE emprestimo_id = ?";
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql); 
            
            stm.setLong(1, idEmprestimo);
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	ItensEmprestimoTO itens_emprestimo = new ItensEmprestimoTO();
            	itens_emprestimo.setEmprestimo_id(rs.getLong("emprestimo_id")); 
            	itens_emprestimo.setVeiculo_id(rs.getLong("veiculo_id"));        		
        		
            	listaItens_emprestimo.add(itens_emprestimo);
            }     
            rs.close();            
            return listaItens_emprestimo;            
            
        } catch (SQLException e) {            
            e.printStackTrace();
            try {
                conexao.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return listaItens_emprestimo;
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
	public boolean inserir(ItensEmprestimoTO itens_emprestimo) {
		String sqlInsert = "INSERT INTO itens_emprestimo "
				+ "(emprestimo_id, veiculo_id) "
				+ "VALUES (?, ?)";
		
		PreparedStatement stm = null;
		Connection conexao = null;		

		try {
			conexao = ConectaMySQL.getConexao();			
			stm = conexao.prepareStatement(sqlInsert);
			
        	stm.setLong(1, itens_emprestimo.getEmprestimo_id());	
        	stm.setLong(2, itens_emprestimo.getVeiculo_id());	
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
	public boolean editar(ItensEmprestimoTO itens_emprestimo) {
		String sqlUpdate = "UPDATE itens_emprestimo SET "
				+ "veiculo_id = ? "
				+ "WHERE emprestimo_id = ?";

		PreparedStatement stm = null;
		Connection conexao = null;		

		try {
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlUpdate);
			
			stm.setLong(1, itens_emprestimo.getVeiculo_id());
        	stm.setLong(2, itens_emprestimo.getEmprestimo_id());        	
			
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
	public boolean excluir(long idEmprestimo) {		
		String sqlDelete = "DELETE FROM itens_emprestimo WHERE emprestimo_id = ?";

		PreparedStatement stm = null;
		Connection conexao = null;
		
		try {		
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlDelete);	
			
			stm.setLong(1, idEmprestimo);
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
