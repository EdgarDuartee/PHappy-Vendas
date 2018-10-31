/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.vendas.model;

/**
 *
 * @author EdgarSamsung
 */
public class PessoaFisica extends Cliente {
    private String cpf;
    private String rg;
    private String tel;
    private String cel;
    private String dtNasc;

    public PessoaFisica(String codigo, String nome, String email, String rua,
            String numero, String bairro, String cidade, String uf, String cep,
            String ativo) {
        super(codigo, nome, email, rua, numero, bairro, cidade, uf, cep,ativo);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }
    
    
    
   
}
