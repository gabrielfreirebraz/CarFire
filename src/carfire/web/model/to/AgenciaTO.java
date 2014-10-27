package carfire.web.model.to;



public class AgenciaTO {

	private long id = 0;
	private long cidade_id = 0;
	private String nome = null;	

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}	
	public long getCidade_id() {
		return cidade_id;
	}
	public void setCidade_id(long cidade_id) {
		this.cidade_id = cidade_id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
