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
public class GuiControleEstrategicoVendedorTBVendedoresGeral {
    private int codigo;
    private String nome;
    private String cargo;
    private String dtCadastro;
    private int qtdeVendasPeriodo;
    private double valorVendasPeriodo;
    private int qtdeClientes;
    private String ativo;
    private String dtInatividade;

    public GuiControleEstrategicoVendedorTBVendedoresGeral() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(String dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public int getQtdeVendasPeriodo() {
        return qtdeVendasPeriodo;
    }

    public void setQtdeVendasPeriodo(int qtdeVendasPeriodo) {
        this.qtdeVendasPeriodo = qtdeVendasPeriodo;
    }

    public double getValorVendasPeriodo() {
        return valorVendasPeriodo;
    }

    public void setValorVendasPeriodo(double valorVendasPeriodo) {
        this.valorVendasPeriodo = valorVendasPeriodo;
    }

    public int getQtdeClientes() {
        return qtdeClientes;
    }

    public void setQtdeClientes(int qtdeClientes) {
        this.qtdeClientes = qtdeClientes;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getDtInatividade() {
        return dtInatividade;
    }

    public void setDtInatividade(String dtInatividade) {
        this.dtInatividade = dtInatividade;
    }

    
}
