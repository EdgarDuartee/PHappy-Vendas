package projeto.vendas.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.vendas.model.PessoaFisica;
import projeto.vendas.model.PessoaJuridica;
/**
 *
 * @author Bruno
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
                                       + "uf, latitude, longitude, cnpj,"
                                       + "nomefantasia, tel,complemento)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1,    pessoaJuridica.getCodigo());
            ps.setString(2, pessoaJuridica.getEmail());
            ps.setString(3, pessoaJuridica.getRua());
            ps.setString(4, pessoaJuridica.getNumero());
            ps.setString(5, pessoaJuridica.getBairro());
            ps.setString(6, pessoaJuridica.getCidade());
            ps.setString(7, pessoaJuridica.getCep());
            ps.setString(8, pessoaJuridica.getUf());
            ps.setDouble(9, pessoaJuridica.getLatitude());
            ps.setDouble(10,pessoaJuridica.getLongitude());
            ps.setString(11,pessoaJuridica.getCnpj());
            ps.setString(12,pessoaJuridica.getNome());
            ps.setString(13,pessoaJuridica.getTel());
            ps.setString(14,pessoaJuridica.getComplemento());
            ps.setString(15,"A");
            
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
                    PJ = new PessoaJuridica(rs.getString("CODIGO"), rs.getString("nomefastasia"), rs.getString("email"), rs.getString("rua"),
                            rs.getString("numero"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("uf"),
                            rs.getString("CEP"), rs.getDouble("latitude"), rs.getDouble("longitude"),rs.getString("ativo"));
                    lista.add(PJ);
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
            return (lista);

        }

    }

     public PessoaJuridica consultaCNPJ(String codigo) {
        PessoaJuridica p = null;
        PreparedStatement ps = null;
        try {  
            ps = conn.prepareStatement("SELECT * from P_JURIDICA where " +
                                                 "CNPJ = ?");
            ps.setString(1,codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next() == true ){
                p = new PessoaJuridica(rs.getString("codigo"),rs.getString("nomefastasia"),
                                  rs.getString("email"),rs.getString("rua"),
                                  rs.getString("numero"),rs.getString("bairro"),
                                  rs.getString("cidade"),rs.getString("uf"),
                                  rs.getString("cep"),rs.getDouble("latitude"),
                                  rs.getDouble("longitude"),rs.getString("ativo"));
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
    
}
