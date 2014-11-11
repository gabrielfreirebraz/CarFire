package carfire.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carfire.web.model.to.PagamentoCartaoCreditoTO;
import carfire.web.util.ConectaMySQL;

public class PagamentoCartaoCreditoDAO {
	

	public ArrayList<PagamentoCartaoCreditoTO> listarItens() {		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
       
        ArrayList<PagamentoCartaoCreditoTO> pagamentos = new ArrayList<PagamentoCartaoCreditoTO>();
    
        try {            
        	String sql = "SELECT * FROM pagamento_cc";
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	PagamentoCartaoCreditoTO pagamento = new PagamentoCartaoCreditoTO();
            	pagamento.setId(rs.getLong("id"));   
            	pagamento.setBandeira(rs.getString("bandeira"));
            	pagamento.setNome_titular(rs.getString("nome_titular"));
            	pagamento.setCpf(rs.getString("cpf"));
            	pagamento.setNumero_cartao(rs.getString("numero_cartao"));
            	pagamento.setData_validade(rs.getString("data_validade"));
            	pagamento.setCod_seguranca(rs.getString("cod_seguranca"));
        		
            	pagamentos.add(pagamento);
            }     
            rs.close();            
            return pagamentos;            
            
        } catch (SQLException e) {            
            e.printStackTrace();
            try {
                conexao.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return pagamentos;
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
	public boolean inserir(PagamentoCartaoCreditoTO pagamento) {
		String sqlInsert = "INSERT INTO pagamento_cc "
				+ "(bandeira, nome_titular, cpf, numero_cartao, data_validade, cod_seguranca) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stm = null;
		Connection conexao = null;		

		try {
			conexao = ConectaMySQL.getConexao();			
			stm = conexao.prepareStatement(sqlInsert);
			
        	stm.setString(1, pagamento.getBandeira());
        	stm.setString(2, pagamento.getNome_titular());
        	stm.setString(3, pagamento.getCpf());
        	stm.setString(4, pagamento.getNumero_cartao());
        	stm.setString(5, pagamento.getData_validade());
        	stm.setString(6, pagamento.getCod_seguranca());
        	
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
	public boolean editar(PagamentoCartaoCreditoTO pagamento) {
		String sqlUpdate = "UPDATE pagamento_cc SET "
				+ "bandeira = ?, nome_titular = ?, cpf = ?, numero_cartao = ?, data_validade = ?, cod_seguranca = ? "
				+ "WHERE id = ?";

		PreparedStatement stm = null;
		Connection conexao = null;		

		try {
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlUpdate);
			
        	stm.setString(1, pagamento.getBandeira());	
        	stm.setString(2, pagamento.getNome_titular());
        	stm.setString(3, pagamento.getCpf());
        	stm.setString(4, pagamento.getNumero_cartao());
        	stm.setString(5, pagamento.getData_validade());
        	stm.setString(6, pagamento.getCod_seguranca());
        	stm.setLong(7, pagamento.getId());
			
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
		String sqlDelete = "DELETE FROM pagamento_cc WHERE id = ?";

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
