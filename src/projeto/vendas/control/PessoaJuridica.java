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
public class PessoaJuridica extends Cliente {

    private String cnpj;
    private String tel1;
    private String tel2;
    private String tel3;
    private String contato1;
    private String contato2;
    private String contato3;

    public PessoaJuridica(String codigo, String nome, String email, String rua,
            String numero, String bairro, String cidade, String uf, String cep,
            String ativo) {
        super(codigo, nome, email, rua, numero, bairro, cidade, uf, cep, ativo);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
