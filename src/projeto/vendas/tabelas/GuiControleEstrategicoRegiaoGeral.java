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
public class GuiControleEstrategicoRegiaoGeral {
    private String UF;
    private String Estado;
    private int qtdCli;
    private int qtdCliPF;
    private int qtdCliPJ;
    private int qtdVendas;
    private double valorVendas;

    public int getQtdVendas() {
        return qtdVendas;
    }

    public void setQtdVendas(int qtdVendas) {
        this.qtdVendas = qtdVendas;
    }

    public GuiControleEstrategicoRegiaoGeral() {
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getQtdCli() {
        return qtdCli;
    }

    public void setQtdCli(int qtdCli) {
        this.qtdCli = qtdCli;
    }

    public int getQtdCliPF() {
        return qtdCliPF;
    }

    public void setQtdCliPF(int qtdCliPF) {
        this.qtdCliPF = qtdCliPF;
    }

    public int getQtdCliPJ() {
        return qtdCliPJ;
    }

    public void setQtdCliPJ(int qtdCliPJ) {
        this.qtdCliPJ = qtdCliPJ;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }
    ;
}
