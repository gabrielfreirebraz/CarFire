package carfire.web.model.to;


public class ItensTarifaTO {

	private long grupo_id = 0;
	private long tarifa_id = 0;
	private String descricao = null;
	
	
	public long getGrupo_id() {
		return grupo_id;
	}
	public void setGrupo_id(long grupo_id) {
		this.grupo_id = grupo_id;
	}
	public long getTarifa_id() {
		return tarifa_id;
	}
	public void setTarifa_id(long tarifa_id) {
		this.tarifa_id = tarifa_id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
