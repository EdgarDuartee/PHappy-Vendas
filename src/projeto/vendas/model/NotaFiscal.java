
package projeto.vendas.model;
public class NotaFiscal {
    
    private int Numero;           
    private int Serie;
    private int PedidoCod;
    private String Tipo;
    private String CFOP;
    private double Total;
    private String DataEmissao;
    private String HoraEmissao;
    private int TranspCod;
    private String Transp_DataSaida;
    private String Transp_HoraSaida;
    private String NaturezaDaOperacao;
    private float BaseICMS;
    private float ICMS;
    private float IPI;
    private String ChaveAcesso;
    private float Valorfrete;
    private String PlacaVeiculo;
    private String CNPJ_CPF;
    private float ValorSeguro;
    private String Endereco;
    private String BAIRRO;
    private String MUNICIPIO;
    private String TELEFONE;
    private String UF;
    private String CEP;
    private String inscricaoEstadual;
    private int Quantidade;
    private String Especie;
    private String Marca;
    private String Numeracao;
    private float PesoBruto;
    private float PesoLiquido;

    public NotaFiscal(int Numero, int Serie, int PedidoCod, String Tipo, String CFOP, double Total, String DataEmissao, String HoraEmissao, int TranspCod) {
        this.Numero = Numero;
        this.Serie = Serie;
        this.PedidoCod = PedidoCod;
        this.Tipo = Tipo;
        this.CFOP = CFOP;
        this.Total = Total;
        this.DataEmissao = DataEmissao;
        this.HoraEmissao = HoraEmissao;
        this.TranspCod = TranspCod;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String Especie) {
        this.Especie = Especie;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getNumeracao() {
        return Numeracao;
    }

    public void setNumeracao(String Numeracao) {
        this.Numeracao = Numeracao;
    }

    public float getPesoBruto() {
        return PesoBruto;
    }

    public void setPesoBruto(float PesoBruto) {
        this.PesoBruto = PesoBruto;
    }

    public float getPesoLiquido() {
        return PesoLiquido;
    }

    public void setPesoLiquido(float PesoLiquido) {
        this.PesoLiquido = PesoLiquido;
    }
    
    

    public String getCNPJ_CPF() {
        return CNPJ_CPF;
    }

    public void setCNPJ_CPF(String CNPJ_CPF) {
        this.CNPJ_CPF = CNPJ_CPF;
    }



    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getBAIRRO() {
        return BAIRRO;
    }

    public void setBAIRRO(String BAIRRO) {
        this.BAIRRO = BAIRRO;
    }

    public String getMUNICIPIO() {
        return MUNICIPIO;
    }

    public void setMUNICIPIO(String MUNICIPIO) {
        this.MUNICIPIO = MUNICIPIO;
    }

    public String getTELEFONE() {
        return TELEFONE;
    }

    public void setTELEFONE(String TELEFONE) {
        this.TELEFONE = TELEFONE;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
    
    

    public String getNaturezaDaOperacao() {
        return NaturezaDaOperacao;
    }

    public void setNaturezaDaOperacao(String NaturezaDaOperacao) {
        this.NaturezaDaOperacao = NaturezaDaOperacao;
    }

    public float getBaseICMS() {
        return BaseICMS;
    }

    public void setBaseICMS(float BaseICMS) {
        this.BaseICMS = BaseICMS;
    }

    public float getICMS() {
        return ICMS;
    }

    public void setICMS(float ICMS) {
        this.ICMS = ICMS;
    }

    public float getIPI() {
        return IPI;
    }

    public void setIPI(float IPI) {
        this.IPI = IPI;
    }

    public String getChaveAcesso() {
        return ChaveAcesso;
    }

    public void setChaveAcesso(String ChaveAcesso) {
        this.ChaveAcesso = ChaveAcesso;
    }

    public float getValorfrete() {
        return Valorfrete;
    }

    public void setValorfrete(float Valorfrete) {
        this.Valorfrete = Valorfrete;
    }

    public String getPlacaVeiculo() {
        return PlacaVeiculo;
    }

    public void setPlacaVeiculo(String PlacaVeiculo) {
        this.PlacaVeiculo = PlacaVeiculo;
    }

    public float getValorSeguro() {
        return ValorSeguro;
    }

    public void setValorSeguro(float ValorSeguro) {
        this.ValorSeguro = ValorSeguro;
    }
    
    

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public int getSerie() {
        return Serie;
    }

    public void setSerie(int Serie) {
        this.Serie = Serie;
    }

    public int getPedidoCod() {
        return PedidoCod;
    }

    public void setPedidoCod(int PedidoCod) {
        this.PedidoCod = PedidoCod;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public String getDataEmissao() {
        return DataEmissao;
    }

    public void setDataEmissao(String DataEmissao) {
        this.DataEmissao = DataEmissao;
    }

    public String getHoraEmissao() {
        return HoraEmissao;
    }

    public void setHoraEmissao(String HoraEmissao) {
        this.HoraEmissao = HoraEmissao;
    }

    public int getTranspCod() {
        return TranspCod;
    }

    public void setTranspCod(int TranspCod) {
        this.TranspCod = TranspCod;
    }

    public String getTransp_DataSaida() {
        return Transp_DataSaida;
    }

    public void setTransp_DataSaida(String Transp_DataSaida) {
        this.Transp_DataSaida = Transp_DataSaida;
    }

    public String getTransp_HoraSaida() {
        return Transp_HoraSaida;
    }

    public void setTransp_HoraSaida(String Transp_HoraSaida) {
        this.Transp_HoraSaida = Transp_HoraSaida;
    }
    
    
    
}
