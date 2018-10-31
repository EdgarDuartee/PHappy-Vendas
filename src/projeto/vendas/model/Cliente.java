package projeto.vendas.model;

/**
 *
 * @author Bruno & Isabella
 */
public abstract class Cliente {
    private String codigo;
    private String nome;
    private String email;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private Double latitude;
    private Double longitude;
    private int    cod_vend_resp;
    private String vendedor_responsavel;
    private String complemento;
    private String dtInicio;

    public String getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }
    private String ativo;

    public Cliente(String codigo, String nome, String email, String rua,
                   String numero, String bairro, String cidade, String uf,
                   String cep,String ativo) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.ativo = ativo;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getVendedor_responsavel() {
        return vendedor_responsavel;
    }

    public void setVendedor_responsavel(String vendedor_responsavel) {
        this.vendedor_responsavel = vendedor_responsavel;
    }
    
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getCod_vend_resp() {
        return cod_vend_resp;
    }

    public void setCod_vend_resp(int cod_vend_resp) {
        this.cod_vend_resp = cod_vend_resp;
    }
    
    
    
}
