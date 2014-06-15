package carfire.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carfire.web.util.ConectaMySQL;

public class Veiculo {

	private int id = 0;
	private String chassi = null;
	private String placa = null;
	private String km = null;
	private String cidade = null;
	private String estado = null;
	private String marca = null;
	private String modelo = null;
	private String fabricante = null;
	private String tarifa = null;
	private String taxa = null;
	private String combustivel = null;
	private int portas = 0;
	private int ano_modelo = 0;
	private String cor = null;
	private String renavam = null;
	private String descricao = null;
	private boolean disponivel = false;
	private int estoque = 0;
	private String observacoes = null;
	

	public Veiculo() {

	}
	public Veiculo(int id) {
		this.id = id;
	}

	public static ArrayList<Veiculo> getArrayObjects() {
		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
        
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    
        try {
            
        	String sql = "SELECT * FROM veiculo";
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	Veiculo veiculo = new Veiculo();
            	veiculo.setId(rs.getInt("id"));
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
        		
        		//add ao ArrayList
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

	public boolean inserir() {

		String sqlInsert = "INSERT INTO veiculo "
				+ "(chassi, placa, km, cidade, estado, marca, modelo, fabricante, tarifa, taxa, "
				+ "combustivel, portas, ano_modelo, cor, renavam, descricao, disponivel, estoque, observacoes) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stm = null;
		Connection conexao = null;
		

		try {
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlInsert);
			
        	stm.setString(1, chassi);
        	stm.setString(2, placa);
        	stm.setString(3, km);
        	stm.setString(4, cidade);
        	stm.setString(5, estado);
        	stm.setString(6, marca);
        	stm.setString(7, modelo);
        	stm.setString(8, fabricante);
        	stm.setString(9, tarifa);
        	stm.setString(10, taxa);
        	stm.setString(11, combustivel);
        	stm.setInt(12, portas);
        	stm.setInt(13, ano_modelo);
        	stm.setString(14, cor);
        	stm.setString(15, renavam);
        	stm.setString(16, descricao);
        	stm.setBoolean(17, disponivel);
        	stm.setInt(18, estoque);
        	stm.setString(19, observacoes);
						
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
	
	public boolean editar() {

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
			
        	stm.setString(1, chassi);
        	stm.setString(2, placa);
        	stm.setString(3, km);
        	stm.setString(4, cidade);
        	stm.setString(5, estado);
        	stm.setString(6, marca);
        	stm.setString(7, modelo);
        	stm.setString(8, fabricante);
        	stm.setString(9, tarifa);
        	stm.setString(10, taxa);
        	stm.setString(11, combustivel);
        	stm.setInt(12, portas);
        	stm.setInt(13, ano_modelo);
        	stm.setString(14, cor);
        	stm.setString(15, renavam);
        	stm.setString(16, descricao);
        	stm.setBoolean(17, disponivel);
        	stm.setInt(18, estoque);
        	stm.setString(19, observacoes);
			stm.setInt(20, id);		
			
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
	
	public boolean excluir() {
		
		String sqlDelete = "DELETE FROM veiculo WHERE id = ?";

		PreparedStatement stm = null;
		Connection conexao = null;
		
		try {		
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlDelete);	
			
			stm.setInt(1, id);
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getTarifa() {
		return tarifa;
	}
	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}
	public String getTaxa() {
		return taxa;
	}
	public void setTaxa(String taxa) {
		this.taxa = taxa;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public int getPortas() {
		return portas;
	}
	public void setPortas(int portas) {
		this.portas = portas;
	}
	public int getAno_modelo() {
		return ano_modelo;
	}
	public void setAno_modelo(int ano_modelo) {
		this.ano_modelo = ano_modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}



}
