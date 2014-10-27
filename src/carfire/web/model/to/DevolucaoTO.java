package carfire.web.model.to;



public class DevolucaoTO {

	private long id = 0;
	private long agencia_id = 0;
	private String data = null;
	private String hora = null;	

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAgencia_id() {
		return agencia_id;
	}
	public void setAgencia_id(long agencia_id) {
		this.agencia_id = agencia_id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
