package carfire.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carfire.web.util.ConectaMySQL;


public class ClientePF extends Cliente {

	private long cpf               = 0;
	private String nome            = null;
	private String rg              = null;	
	private String habilitacao     = null;
	private String data_nascimento = null;	
	private String genero          = null;
	
	
	
	
	public static ArrayList<ClientePF> getArrayObjects() {
		
		PreparedStatement stm = null;
        Connection conexao = null;
        ResultSet rs = null;
        
        ArrayList<ClientePF> clientes = new ArrayList<ClientePF>();
    
        try {
            
        	String sql = "SELECT * FROM cliente";
        	conexao = ConectaMySQL.getConexao();
            
            stm = conexao.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {
            	ClientePF cliente = new ClientePF();
            	cliente.setId(rs.getInt("id"));            	
            	cliente.setEmail(rs.getString("email"));
            	cliente.setTelefone(rs.getString("telefone"));
            	cliente.setEndereco(rs.getString("endereco"));
            	cliente.setBairro(rs.getString("bairro"));
            	cliente.setCidade(rs.getString("cidade"));
            	cliente.setEstado(rs.getString("estado"));
            	cliente.setCep(rs.getString("cep"));
            	cliente.setTipo(rs.getString("tipo"));
            	
            	cliente.setTelefone(rs.getString("cpf"));
            	cliente.setEmail(rs.getString("nome"));
            	cliente.setEndereco(rs.getString("rg"));            	           	
            	cliente.setTipo(rs.getString("habilitacao"));
            	cliente.setEstado(rs.getString("data_nascimento")); 
            	cliente.setCep(rs.getString("genero"));
        		
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
    			+ "cpf, nome, rg, habilitacao, data_nascimento, genero) "
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
    		
    		stm.setLong(9, cpf);
    		stm.setString(10, nome);
    		stm.setString(11, rg);
    		stm.setString(12, habilitacao);
    		stm.setString(13, data_nascimento);
    		stm.setString(14, genero);
    		
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
    			+ "cpf = ?, nome = ?, rg = ?, habilitacao = ?, data_nascimento = ?, genero = ? "
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
    		
    		stm.setLong(9, cpf);
    		stm.setString(10, nome);
    		stm.setString(11, rg);
    		stm.setString(12, habilitacao);
    		stm.setString(13, data_nascimento);
    		stm.setString(14, genero);
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
	
	
	
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getHabilitacao() {
		return habilitacao;
	}
	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}
	public String getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
}
