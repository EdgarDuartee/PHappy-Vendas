
package projeto.vendas.model;

import java.sql.Date;



public class Pedido {
    private int codigo;
    private String clienteCod;
    private String clienteNome;
    private int vendedorCod;
    private String dtPedido;
    private float total;
    private int situacao;

    public Pedido(int codigo, String clienteCod, int vendedorCod, String dtPedido, float total,int situacao) {
        this.codigo = codigo;
        this.clienteCod = clienteCod;
        this.vendedorCod = vendedorCod;
        this.dtPedido = dtPedido;
        this.total = total;
        this.situacao = situacao;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getClienteCod() {
        return clienteCod;
    }

    public void setClienteCod(String clienteCod) {
        this.clienteCod = clienteCod;
    }

    public int getVendedorCod() {
        return vendedorCod;
    }

    public void setVendedorCod(int vendedorCod) {
        this.vendedorCod = vendedorCod;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public String getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(String dtPedido) {
        this.dtPedido = dtPedido;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }


    
    
}
