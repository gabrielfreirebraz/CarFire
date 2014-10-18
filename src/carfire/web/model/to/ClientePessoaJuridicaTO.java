package carfire.web.model.to;



public class ClientePessoaJuridicaTO {
	
	protected long id = 0;
	protected String email    = null;
	protected String telefone = null;	
	protected String endereco = null;
	protected String bairro   = null;
	protected String cidade   = null;
	protected String estado   = null;
	protected String cep      = null;
	
	protected long   cnpj                = 0;
	protected String razao_social        = null;
	protected String nome_comercial      = null;	
	protected String inscricao_estadual  = null;
	protected String data_fundacao       = null;
	protected int    numero_funcionarios = 0;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
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
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
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
}
