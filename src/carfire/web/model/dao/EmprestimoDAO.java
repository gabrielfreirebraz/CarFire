package carfire.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carfire.web.model.to.EmprestimoTO;
import carfire.web.util.ConectaMySQL;

public class EmprestimoDAO {
	

	public ArrayList<EmprestimoTO> listarItens() {		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
       
        ArrayList<EmprestimoTO> emprestimos = new ArrayList<EmprestimoTO>();
    
        try {            
        	String sql = "SELECT a.*, b.nome AS agencia, c.nome AS cliente FROM emprestimo a "
        			+ "INNER JOIN agencia b ON a.agencia_id = b.id "
        			+ "INNER JOIN cliente_pf c ON a.cliente_pf_id = c.id "
        			+ "WHERE a.status = 'emprestado' ORDER BY a.id DESC ";
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	EmprestimoTO emprestimo = new EmprestimoTO();
            	emprestimo.setId(rs.getLong("id")); 
            	emprestimo.setAgencia(rs.getString("agencia")); 
            	emprestimo.setPagamento_id(rs.getLong("pagamento_id")); 
            	emprestimo.setDevolucao_id(rs.getLong("devolucao_id")); 
            	emprestimo.setReserva_id(rs.getLong("reserva_id")); 
            	emprestimo.setCliente(rs.getString("cliente"));
            	emprestimo.setCliente_pj_id(rs.getLong("cliente_pj_id"));
            	emprestimo.setData(rs.getString("data"));
            	emprestimo.setHora(rs.getString("hora"));
            	emprestimo.setStatus(rs.getString("status"));
        		
            	emprestimos.add(emprestimo);
            }     
            rs.close();            
            return emprestimos;            
            
        } catch (SQLException e) {            
            e.printStackTrace();
            try {
                conexao.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return emprestimos;
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
	public boolean inserir(EmprestimoTO emprestimo) {
		String sqlInsert = "INSERT INTO emprestimo "
				+ "(agencia_id, pagamento_id, devolucao_id, reserva_id, cliente_pf_id, cliente_pj_id, data, hora, status) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stm = null;
		Connection conexao = null;		

		try {
			conexao = ConectaMySQL.getConexao();			
			stm = conexao.prepareStatement(sqlInsert);
			
			stm.setLong(1, emprestimo.getAgencia_id());
			stm.setLong(2, emprestimo.getPagamento_id());
			stm.setLong(3, emprestimo.getDevolucao_id());
			stm.setLong(4, emprestimo.getReserva_id());
			stm.setLong(5, emprestimo.getCliente_pf_id());
			stm.setLong(6, emprestimo.getCliente_pj_id());
			stm.setString(7, emprestimo.getData());
			stm.setString(8, emprestimo.getHora());
        	stm.setString(9, emprestimo.getStatus());
        	
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
	public boolean fazerDevolucao(EmprestimoTO emprestimo) {
		String sqlUpdate = "UPDATE emprestimo SET "
				+ "devolucao_id = ?, status = ? "
				+ "WHERE id = ?";

		PreparedStatement stm = null;
		Connection conexao = null;		

		try {
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlUpdate);
			
			stm.setLong(1, emprestimo.getDevolucao_id());
        	stm.setString(2, "finalizado");
        	stm.setLong(3, emprestimo.getId());
			
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
	public boolean cancelar(long id) {		
		String sqlDelete = "UPDATE emprestimo SET status = ? WHERE id = ?";

		PreparedStatement stm = null;
		Connection conexao = null;
		
		try {		
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlDelete);	
			
			stm.setString(1, "cancelado");
			stm.setLong(2, id);
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
