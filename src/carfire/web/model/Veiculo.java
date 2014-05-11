package carfire.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import carfire.web.util.ConectaMySQL;

public class Veiculo {
	
	private String chassi;
	private String placa;
	private String cidade;	
	private String km;
	private String estado;
	private String modelo;
	private String fabricante;
	private String marca;
	
	
	
	
	public Veiculo() {
		
	}
	
	public boolean inserir(){
				
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

}
