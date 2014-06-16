package carfire.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carfire.web.util.ConectaMySQL;


public class ClientePJ extends Cliente {
	
	private long   cnpj                = 0;
	private String razao_social        = null;
	private String nome_comercial      = null;	
	private String inscricao_estadual  = null;
	private String data_fundacao       = null;
	private int    numero_funcionarios = 0;
	private String tipo                = "PJ";
	

	public static ArrayList<ClientePJ> getArrayObjects() {
		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
        
        ArrayList<ClientePJ> clientes = new ArrayList<ClientePJ>();
    
        try {
            
        	String sql = "SELECT * FROM cliente WHERE tipo = 'PJ'";
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {
            	ClientePJ cliente = new ClientePJ();
            	cliente.setId(rs.getInt("id"));            	
            	cliente.setEmail(rs.getString("email"));
            	cliente.setTelefone(rs.getString("telefone"));
            	cliente.setEndereco(rs.getString("endereco"));
            	cliente.setBairro(rs.getString("bairro"));
            	cliente.setCidade(rs.getString("cidade"));
            	cliente.setEstado(rs.getString("estado"));
            	cliente.setCep(rs.getString("cep"));
            	cliente.setTipo(rs.getString("tipo"));
            	
            	cliente.setCnpj(rs.getLong("cnpj"));
            	cliente.setRazao_social(rs.getString("razao_social"));
            	cliente.setNome_comercial(rs.getString("nome_comercial"));            	           	
            	cliente.setInscricao_estadual(rs.getString("inscricao_estadual"));
            	cliente.setData_fundacao(rs.getString("data_fundacao")); 
            	cliente.setNumero_funcionarios(rs.getInt("numero_funcionarios"));
        		
        		//add ao ArrayList
        		clientes.add(cliente);
            }            

            rs.close();            
            return clientes;
            
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conexao.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return clientes;
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
		
		String sqlInsert = "INSERT INTO cliente "
    			+ "(email, telefone, endereco, bairro, cidade, estado, cep, tipo, "
    			+ "cnpj, razao_social, nome_comercial, inscricao_estadual, data_fundacao, numero_funcionarios) "
    			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stm = null;
        Connection conexao = null; 
        
        
        try {
        	conexao = ConectaMySQL.getConexao();           
    		stm = conexao.prepareStatement(sqlInsert);
    		
    		stm.setString(1, email);
    		stm.setString(2, telefone);
    		stm.setString(3, endereco);
    		stm.setString(4, bairro);
    		stm.setString(5, cidade);
    		stm.setString(6, estado);
    		stm.setString(7, cep);
    		stm.setString(8, tipo);
    		
    		stm.setLong(9, cnpj);
    		stm.setString(10, razao_social);
    		stm.setString(11, nome_comercial);
    		stm.setString(12, inscricao_estadual);
    		stm.setString(13, data_fundacao);
    		stm.setInt(14, numero_funcionarios);
    		
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


	public boolean editar() {
		
		String sqlUpdate = "UPDATE cliente SET "
    			+ "email = ?, telefone = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, tipo = ?, "
    			+ "cnpj = ?, razao_social = ?, nome_comercial = ?, inscricao_estadual = ?, data_fundacao = ?, numero_funcionarios = ? "
    			+ "WHERE id = ?";
		
		Connection conexao = null;
		PreparedStatement stm = null;
		
		
		try {
			
			conexao = ConectaMySQL.getConexao();  
			stm = conexao.prepareStatement(sqlUpdate);

    		stm.setString(1, email);
    		stm.setString(2, telefone);
    		stm.setString(3, endereco);
    		stm.setString(4, bairro);
    		stm.setString(5, cidade);
    		stm.setString(6, estado);
    		stm.setString(7, cep);
    		stm.setString(8, tipo);
    		
    		stm.setLong(9, cnpj);
    		stm.setString(10, razao_social);
    		stm.setString(11, nome_comercial);
    		stm.setString(12, inscricao_estadual);
    		stm.setString(13, data_fundacao);
    		stm.setInt(14, numero_funcionarios);
    		stm.setInt(15, id);
    		
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

	public boolean excluir() {		

		String sqlDelete = "DELETE FROM cliente WHERE id = ?";

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
	
	
	
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazao_social() {
		return razao_social;
	}
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	public String getNome_comercial() {
		return nome_comercial;
	}
	public void setNome_comercial(String nome_comercial) {
		this.nome_comercial = nome_comercial;
	}
	public String getInscricao_estadual() {
		return inscricao_estadual;
	}
	public void setInscricao_estadual(String inscricao_estadual) {
		this.inscricao_estadual = inscricao_estadual;
	}
	public String getData_fundacao() {
		return data_fundacao;
	}
	public void setData_fundacao(String data_fundacao) {
		this.data_fundacao = data_fundacao;
	}
	public int getNumero_funcionarios() {
		return numero_funcionarios;
	}
	public void setNumero_funcionarios(int numero_funcionarios) {
		this.numero_funcionarios = numero_funcionarios;
	}
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
