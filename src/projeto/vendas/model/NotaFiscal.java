
package projeto.vendas.model;
public class NotaFiscal {
    
    private int Numero;           
    private int Serie;
    private int PedidoCod;
    private String Tipo;
    private String CFOP;
    private float Total;
    private String DataEmissao;
    private String HoraEmissao;
    private int TranspCod;
    private String Transp_DataSaida;
    private String Transp_HoraSaida;

    public NotaFiscal(int Numero, int Serie, int PedidoCod, String Tipo, String CFOP, float Total, String DataEmissao, String HoraEmissao, int TranspCod) {
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

    public float getTotal() {
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
