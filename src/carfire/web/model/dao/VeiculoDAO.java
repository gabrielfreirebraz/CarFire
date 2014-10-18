package carfire.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carfire.web.model.to.VeiculoTO;
import carfire.web.util.ConectaMySQL;

public class VeiculoDAO {
	

	public static ArrayList<VeiculoTO> listarItens() {		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
        
        ArrayList<VeiculoTO> veiculos = new ArrayList<VeiculoTO>();
    
        try {            
        	String sql = "SELECT * FROM veiculo";
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	VeiculoTO veiculo = new VeiculoTO();
            	veiculo.setId(rs.getLong("id"));
        		veiculo.setChassi(rs.getString("chassi"));
        		veiculo.setPlaca(rs.getString("placa"));
        		veiculo.setKm(rs.getString("km"));
        		veiculo.setCidade(rs.getString("cidade"));
        		veiculo.setEstado(rs.getString("estado"));
        		veiculo.setMarca(rs.getString("marca"));
        		veiculo.setModelo(rs.getString("modelo"));
        		veiculo.setFabricante(rs.getString("fabricante"));
        		veiculo.setTarifa(rs.getString("tarifa"));
        		veiculo.setTaxa(rs.getString("taxa"));
        		veiculo.setCombustivel(rs.getString("combustivel"));
        		veiculo.setPortas(rs.getInt("portas"));
        		veiculo.setAno_modelo(rs.getInt("ano_modelo"));
        		veiculo.setCor(rs.getString("cor"));
        		veiculo.setRenavam(rs.getString("renavam"));
        		veiculo.setDescricao(rs.getString("descricao"));
        		veiculo.setDisponivel(rs.getBoolean("disponivel"));
        		veiculo.setEstoque(rs.getInt("estoque"));
        		veiculo.setObservacoes(rs.getString("observacoes"));
        		
            	veiculos.add(veiculo);
            }     
            rs.close();            
            return veiculos;            
            
        } catch (SQLException e) {            
            e.printStackTrace();
            try {
                conexao.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return veiculos;
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
	public boolean inserir(VeiculoTO veiculo) {
		String sqlInsert = "INSERT INTO veiculo "
				+ "(chassi, placa, km, cidade, estado, marca, modelo, fabricante, tarifa, taxa, "
				+ "combustivel, portas, ano_modelo, cor, renavam, descricao, disponivel, estoque, observacoes) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stm = null;
		Connection conexao = null;
		

		try {
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlInsert);
			
        	stm.setString(1, veiculo.getChassi());
        	stm.setString(2, veiculo.getPlaca());
        	stm.setString(3, veiculo.getKm());
        	stm.setString(4, veiculo.getCidade());
        	stm.setString(5, veiculo.getEstado());
        	stm.setString(6, veiculo.getMarca());
        	stm.setString(7, veiculo.getModelo());
        	stm.setString(8, veiculo.getFabricante());
        	stm.setString(9, veiculo.getTarifa());
        	stm.setString(10, veiculo.getTaxa());
        	stm.setString(11, veiculo.getCombustivel());
        	stm.setInt(12, veiculo.getPortas());
        	stm.setInt(13, veiculo.getAno_modelo());
        	stm.setString(14, veiculo.getCor());
        	stm.setString(15, veiculo.getRenavam());
        	stm.setString(16, veiculo.getDescricao());
        	stm.setBoolean(17, true);
        	stm.setInt(18, veiculo.getEstoque());
        	stm.setString(19, veiculo.getObservacoes());
						
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
	public boolean editar(VeiculoTO veiculo) {
		String sqlUpdate = "UPDATE veiculo SET "
				+ "chassi = ?, placa = ?, km = ?, cidade = ?, estado = ?, marca = ?, modelo = ?, "
				+ "fabricante = ?, tarifa = ?, taxa = ?, combustivel = ?, portas = ?, ano_modelo = ?, "
				+ "cor = ?, renavam = ?, descricao = ?, disponivel = ?, estoque = ?, observacoes = ? "
				+ "WHERE id = ?";

		PreparedStatement stm = null;
		Connection conexao = null;		

		try {
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlUpdate);
			
        	stm.setString(1, veiculo.getChassi());
        	stm.setString(2, veiculo.getPlaca());
        	stm.setString(3, veiculo.getKm());
        	stm.setString(4, veiculo.getCidade());
        	stm.setString(5, veiculo.getEstado());
        	stm.setString(6, veiculo.getMarca());
        	stm.setString(7, veiculo.getModelo());
        	stm.setString(8, veiculo.getFabricante());
        	stm.setString(9, veiculo.getTarifa());
        	stm.setString(10, veiculo.getTaxa());
        	stm.setString(11, veiculo.getCombustivel());
        	stm.setInt(12, veiculo.getPortas());
        	stm.setInt(13, veiculo.getAno_modelo());
        	stm.setString(14, veiculo.getCor());
        	stm.setString(15, veiculo.getRenavam());
        	stm.setString(16, veiculo.getDescricao());
        	stm.setBoolean(17, veiculo.getDisponivel());
        	stm.setInt(18, veiculo.getEstoque());
        	stm.setString(19, veiculo.getObservacoes());	
        	stm.setLong(20, veiculo.getId());
			
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
		String sqlDelete = "DELETE FROM veiculo WHERE id = ?";

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
