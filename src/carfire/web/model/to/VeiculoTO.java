package carfire.web.model.to;


public class VeiculoTO {

	private long id = 0;
	private long grupo_id = 0;
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
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getGrupo_id() {
		return grupo_id;
	}
	public void setGrupo_id(long grupo_id) {
		this.grupo_id = grupo_id;
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
	public boolean getDisponivel() {
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
