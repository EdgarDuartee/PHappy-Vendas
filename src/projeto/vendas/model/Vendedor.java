/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.vendas.model;

import java.sql.Date;

/**
 *
 * @author EdgarSamsung
 */
public class Vendedor {
    private int codigo;
    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private String tel;
    private String cel;
    private String dataNasc;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private int permissao;
    private String senha;
    private String complemento;
    private String dtInicio;

    public String getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }
    private String ativo;

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public Vendedor(int codigo, String nome, String rg, String cpf,
                    String email, String tel, String cel, String dataNasc,
                    String rua, String numero, String bairro, String cidade,
                    String uf, String cep) {
        this.codigo = codigo;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.tel = tel;
        this.cel = cel;
        this.dataNasc = dataNasc;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
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

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getCel() {
        return cel;
    }

    public String getDataNasc() {
        return dataNasc;
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

    public int getPermissao() {
        return permissao;
    }

    public String getSenha() {
        return senha;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
        
}
