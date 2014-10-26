package carfire.web.model.to;



public class EmprestimoTO {

	private long id = 0;
	private long agencia_id = 0;
	private long pagamento_id = 0;
	private long devolucao_id = 0;
	private long reserva_id = 0;
	private long cliente_pf_id = 0;
	private long cliente_pj_id = 0;
	private String data = null;
	private String hora = null;
	private String status = null;	

	
	
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
	public long getPagamento_id() {
		return pagamento_id;
	}
	public void setPagamento_id(long pagamento_id) {
		this.pagamento_id = pagamento_id;
	}
	public long getDevolucao_id() {
		return devolucao_id;
	}
	public void setDevolucao_id(long devolucao_id) {
		this.devolucao_id = devolucao_id;
	}
	public long getReserva_id() {
		return reserva_id;
	}
	public void setReserva_id(long reserva_id) {
		this.reserva_id = reserva_id;
	}
	public long getCliente_pf_id() {
		return cliente_pf_id;
	}
	public void setCliente_pf_id(long cliente_pf_id) {
		this.cliente_pf_id = cliente_pf_id;
	}
	public long getCliente_pj_id() {
		return cliente_pj_id;
	}
	public void setCliente_pj_id(long cliente_pj_id) {
		this.cliente_pj_id = cliente_pj_id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
