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
public class PessoaJuridica extends Cliente{
    private String cnpj;
    private String contato1;
    private String tel1;
    private String contato2;
    private String tel2;
    private String contato3;
    private String tel3;
    
    public PessoaJuridica(String codigo, String nome, String email, String rua,
            String numero, String bairro, String cidade, String uf, String cep,
             String ativo) {
        super(codigo, nome, email, rua, numero, bairro, cidade, uf, cep,ativo);
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
        
    public String getContato1() {
        return contato1;
    }

    public void setContato1(String contato1) {
        this.contato1 = contato1;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getContato2() {
        return contato2;
    }

    public void setContato2(String contato2) {
        this.contato2 = contato2;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getContato3() {
        return contato3;
    }

    public void setContato3(String contato3) {
        this.contato3 = contato3;
    }

    public String getTel3() {
        return tel3;
    }

    public void setTel3(String tel3) {
        this.tel3 = tel3;
    }
}
