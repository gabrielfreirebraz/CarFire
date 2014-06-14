package carfire.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carfire.web.util.ConectaMySQL;

public class Veiculo {

	private int id;
	private String chassi;
	private String placa;
	private String km;
	private String cidade;
	private String estado;
	private String marca;
	private String modelo;
	private String fabricante;
	private String tarifa;
	private String taxa;
	private String combustivel;
	private int portas;
	private int ano_modelo;
	private String cor;
	private String renavam;
	private String descricao;
	private boolean disponivel;
	private int estoque;
	private String observacoes;
	

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
				+ "(chassi, placa, cidade, estado, modelo, fabricante) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement stm = null;
		Connection conexao = null;
		

		try {
			conexao = ConectaMySQL.getConexao();
			stm = conexao.prepareStatement(sqlInsert);

			stm.setString(1, chassi);
			stm.setString(2, placa);
			stm.setString(3, cidade);
			stm.setString(4, estado);
			stm.setString(5, modelo);
			stm.setString(6, fabricante);
			stm.execute();

			return true;

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
			stm.execute();
			
			return true;
			
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
