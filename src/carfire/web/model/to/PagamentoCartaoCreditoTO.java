package carfire.web.model.to;

/**
 * 
 * CLASSE NÃO TERMINADA
 * 
 * @author Gabriel
 *
 */
public class PagamentoCartaoCreditoTO {

	private long id = 0;
	private String bandeira = null;
	private String nome_titular = null;
	private String cpf = null;
	private String numero_cartao = null;
	private String data_validade = null;
	private String cod_seguranca = null;
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	public String getNome_titular() {
		return nome_titular;
	}
	public void setNome_titular(String nome_titular) {
		this.nome_titular = nome_titular;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNumero_cartao() {
		return numero_cartao;
	}
	public void setNumero_cartao(String numero_cartao) {
		this.numero_cartao = numero_cartao;
	}
	public String getData_validade() {
		return data_validade;
	}
	public void setData_validade(String data_validade) {
		this.data_validade = data_validade;
	}
	public String getCod_seguranca() {
		return cod_seguranca;
	}
	public void setCod_seguranca(String cod_seguranca) {
		this.cod_seguranca = cod_seguranca;
	}
	
}
