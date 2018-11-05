package projeto.vendas.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.vendas.model.PessoaJuridica;
/**
 *
 * @author Cleiton
 */
public class DaoPJuridica {
    private Connection conn;
    
    public DaoPJuridica(Connection conn) {
         this.conn = conn;
    }
    public void inserir(PessoaJuridica pessoaJuridica) {
        PreparedStatement ps = null;
        try {      
            ps = conn.prepareStatement("INSERT INTO P_Juridica(codigo, email, "
                                       + "rua, numero, bairro, cidade, cep,"
                                       + "uf, cnpj,"
                                       + "nomefastasia, tel,complemento"
                                       + ",cod_vend_resp,"
                                       + "vend_resp, ativo,dtInicio)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1,    pessoaJuridica.getCodigo());
            ps.setString(2, pessoaJuridica.getEmail());
            ps.setString(3, pessoaJuridica.getRua());
            ps.setString(4, pessoaJuridica.getNumero());
            ps.setString(5, pessoaJuridica.getBairro());
            ps.setString(6, pessoaJuridica.getCidade());
            ps.setString(7, pessoaJuridica.getCep());
            ps.setString(8, pessoaJuridica.getUf());
            ps.setString(9,pessoaJuridica.getCnpj());
            ps.setString(10,pessoaJuridica.getNome());
            ps.setString(11,pessoaJuridica.getTel());
            ps.setString(12,pessoaJuridica.getComplemento());
            ps.setInt(13,pessoaJuridica.getCod_vend_resp());
            ps.setString(14,pessoaJuridica.getVendedor_responsavel());
            ps.setString(15,"A");
            ps.setString(16,pessoaJuridica.getDtInicio());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());   
        }

    }
    
    public void alterar(PessoaJuridica pessoaJuridica) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE P_Juridica set email = ?,"
                                       + " rua = ?, numero = ?, bairro = ?,"
                                       + " cidade = ?, uf = ?, cep = ?, "
                                       + " complemento = ?, "
                                       + " tel = ?, cod_vend_resp = ? ,"
                                       + " vend_resp = ?"  
                                       + "where codigo = ?");
            
            ps.setString(1, pessoaJuridica.getEmail());
            ps.setString(2, pessoaJuridica.getRua());
            ps.setString(3, pessoaJuridica.getNumero());
            ps.setString(4, pessoaJuridica.getBairro());
            ps.setString(5, pessoaJuridica.getCidade());
            ps.setString(6, pessoaJuridica.getUf());
            ps.setString(7, pessoaJuridica.getCep());
            ps.setString(8, pessoaJuridica.getComplemento());
            ps.setString(9, pessoaJuridica.getTel());
            ps.setInt(10, pessoaJuridica.getCod_vend_resp());
            ps.setString(11, pessoaJuridica.getVendedor_responsavel());
            ps.setString(12,pessoaJuridica.getCodigo());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
     public void desativarOUativar(PessoaJuridica pessoaJuridica, String ativo) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE P_Juridica set ativo = ? where "
                                        + "codigo = ?");
            
            ps.setString(1,ativo);  
            ps.setString(2, pessoaJuridica.getCodigo());
             
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public ArrayList<PessoaJuridica> ListarPessoasJuridicas() {
        {
            PessoaJuridica PJ = null;
            ArrayList<PessoaJuridica> lista = new ArrayList();
            PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement("SELECT * from P_JURIDICA");
                ResultSet rs = ps.executeQuery();
                while (rs.next() == true) {
                    PJ = new PessoaJuridica(rs.getString("codigo"), rs.getString("nomefastasia"), 
                            rs.getString("email"), rs.getString("rua"),
                            rs.getString("numero"), rs.getString("bairro"), 
                            rs.getString("cidade"), rs.getString("uf"),
                            rs.getString("cep"),rs.getString("ativo"));
                    lista.add(PJ);
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
            return (lista);

        }

    }

     public PessoaJuridica consultaCNPJ(String cnpj) {
        PessoaJuridica p = null;
        PreparedStatement ps = null;
        try {  
            ps = conn.prepareStatement("SELECT * from P_JURIDICA where " +
                                                 "CNPJ = ?");
            ps.setString(1,cnpj);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next() == true ){
                p = new PessoaJuridica(rs.getString("codigo"),rs.getString("nomefastasia"),
                                  rs.getString("email"),rs.getString("rua"),
                                  rs.getString("numero"),rs.getString("bairro"),
                                  rs.getString("cidade"),rs.getString("uf"),
                                  rs.getString("cep"),rs.getString("ativo"));
              //  p.setVendedor_responsavel(rs.getString("vend_resp"));
                p.setComplemento(rs.getString("complemento"));
                p.setTel(rs.getString("tel"));
                p.setCnpj(rs.getString("CNPJ"));
                
            }             
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
        return  (p);
    }
    public PessoaJuridica consultar(String codigo) {
        PessoaJuridica p = null;
        PreparedStatement ps = null;
        try {  
            ps = conn.prepareStatement("SELECT * from P_Juridica where " +
                                                 "CODIGO = ?");
            ps.setString(1,codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next() == true ){
                p = new PessoaJuridica (rs.getString("codigo"),rs.getString("nomefastasia"),
                                  rs.getString("email"),rs.getString("rua"),
                                  rs.getString("numero"),rs.getString("bairro"),
                                  rs.getString("cidade"),rs.getString("uf"),
                                  rs.getString("cep"),rs.getString("ativo"));
                p.setCod_vend_resp(rs.getInt("cod_vend_resp"));
                p.setVendedor_responsavel(rs.getString("vend_resp"));
                p.setComplemento(rs.getString("complemento"));
                p.setTel(rs.getString("tel"));
                p.setCnpj(rs.getString("cnpj"));
                
            }             
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
        return  (p);
    }   
}
