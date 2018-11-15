/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.vendas.tabelas;

/**
 *
 * @author EdgarSamsung
 */
public class GuiControleEstrategicoRegiaoEspecifica {
    private String codigo;
    private String nome;
    private String cidade;
    private int qtdCompras;
    private double valorCompras;
    private int codVendResp;
    private String vendResp;

    public GuiControleEstrategicoRegiaoEspecifica() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getQtdCompras() {
        return qtdCompras;
    }

    public void setQtdCompras(int qtdCompras) {
        this.qtdCompras = qtdCompras;
    }

    public double getValorCompras() {
        return valorCompras;
    }

    public void setValorCompras(double valorCompras) {
        this.valorCompras = valorCompras;
    }

    public int getCodVendResp() {
        return codVendResp;
    }

    public void setCodVendResp(int codVendResp) {
        this.codVendResp = codVendResp;
    }

    public String getVendResp() {
        return vendResp;
    }

    public void setVendResp(String vendResp) {
        this.vendResp = vendResp;
    }
    
}
