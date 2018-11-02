package projeto.vendas.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.vendas.model.PessoaFisica;
/**
 *
 * @author Bruno
 */
public class DaoPFisica {
    private Connection conn;
    
    public DaoPFisica(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(PessoaFisica pessoaFisica) {
        PreparedStatement ps = null;
        try {      
            ps = conn.prepareStatement("INSERT INTO P_Fisica(codigo, email, rua,"
                                       + "numero, bairro, cidade, cep, uf ,"
                                       + "nome , cpf, rg,"
                                       + "dtnasc, tel , cel, complemento,cod_vend_resp,"
                                       + "vend_resp, ativo,dtInicio)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1,    pessoaFisica.getCodigo());
            ps.setString(2, pessoaFisica.getEmail());
            ps.setString(3, pessoaFisica.getRua());
            ps.setString(4, pessoaFisica.getNumero());
            ps.setString(5, pessoaFisica.getBairro());
            ps.setString(6, pessoaFisica.getCidade());
            ps.setString(7, pessoaFisica.getCep());
            ps.setString(8, pessoaFisica.getUf());
            ps.setString(9,pessoaFisica.getNome());
            ps.setString(10,pessoaFisica.getCpf());
            ps.setString(11,pessoaFisica.getRg());
            ps.setString(12,pessoaFisica.getDtNasc());
            ps.setString(13,   pessoaFisica.getTel());
            ps.setString(14,pessoaFisica.getCel());
            ps.setString(15,pessoaFisica.getComplemento());
            ps.setInt(16,pessoaFisica.getCod_vend_resp());
            ps.setString(17,pessoaFisica.getVendedor_responsavel());
            ps.setString(18,"A");
            ps.setString(19,pessoaFisica.getDtInicio());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());   
        }

    }
  
    public void alterar(PessoaFisica pessoaFisica) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE P_Fisica set rua = ?,"
                                       + " numero = ?, bairro = ?, cidade = ?,"
                                       + " uf = ?, cep = ?, complemento = ?, "
                                       + " tel = ?, cel = ?,"
                                       + " email = ?, cod_vend_resp = ? ,"
                                       + " vend_resp = ?"  
                                       + "where codigo = ?");
            
            ps.setString(1, pessoaFisica.getRua());
            ps.setString(2, pessoaFisica.getNumero());
            ps.setString(3, pessoaFisica.getBairro());
            ps.setString(4, pessoaFisica.getCidade());
            ps.setString(5, pessoaFisica.getUf());
            ps.setString(6, pessoaFisica.getCep());
            ps.setString(7, pessoaFisica.getComplemento());
            ps.setString(8, pessoaFisica.getTel());
            ps.setString(9, pessoaFisica.getCel());
            ps.setString(10, pessoaFisica.getEmail());
            ps.setInt(11, pessoaFisica.getCod_vend_resp());
            ps.setString(12, pessoaFisica.getVendedor_responsavel());
            ps.setString(13,pessoaFisica.getCodigo());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void desativarOUativar(PessoaFisica pessoaFisica, String ativo) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE P_Fisica set ativo = ? where "
                                        + "codigo = ?");
            
            ps.setString(1,ativo);  
            ps.setString(2, pessoaFisica.getCodigo());
             
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }

    public PessoaFisica consultarCPF(String cpf) {
        PessoaFisica p = null;
        PreparedStatement ps = null;
        try {  
            ps = conn.prepareStatement("SELECT * from P_Fisica where " +
                                                 "CPF = ?");
            ps.setString(1,cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next() == true ){
                p = new PessoaFisica (rs.getString("codigo"),rs.getString("nome"),
                                  rs.getString("email"),rs.getString("rua"),
                                  rs.getString("numero"),rs.getString("bairro"),
                                  rs.getString("cidade"),rs.getString("uf"),
                                  rs.getString("cep"),rs.getString("ativo"));
                p.setCod_vend_resp(rs.getInt("cod_vend_resp"));
                p.setVendedor_responsavel(rs.getString("vend_resp"));
                p.setComplemento(rs.getString("complemento"));
                p.setCel(rs.getString("cel"));
                p.setTel(rs.getString("tel"));
                p.setDtNasc(rs.getString("dtNasc"));
                p.setRg(rs.getString("rg"));
                p.setCpf(rs.getString("cpf"));
                
            }             
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
        return  (p);
    } 
    
    public PessoaFisica consultar(String codigo) {
        PessoaFisica p = null;
        PreparedStatement ps = null;
        try {  
            ps = conn.prepareStatement("SELECT * from P_Fisica where " +
                                                 "CODIGO = ?");
            ps.setString(1,codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next() == true ){
                p = new PessoaFisica (rs.getString("codigo"),rs.getString("nome"),
                                  rs.getString("email"),rs.getString("rua"),
                                  rs.getString("numero"),rs.getString("bairro"),
                                  rs.getString("cidade"),rs.getString("uf"),
                                  rs.getString("cep"),rs.getString("ativo"));
                p.setCod_vend_resp(rs.getInt("cod_vend_resp"));
                p.setVendedor_responsavel(rs.getString("vend_resp"));
                p.setComplemento(rs.getString("complemento"));
                p.setCel(rs.getString("cel"));
                p.setTel(rs.getString("tel"));
                p.setDtNasc(rs.getString("dtNasc"));
                p.setRg(rs.getString("rg"));
                p.setCpf(rs.getString("cpf"));
                
            }             
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
        return  (p);
    }   
    
    public ArrayList<PessoaFisica> ListarPessoasFisicas() {
        {
            PessoaFisica PF = null;
            ArrayList<PessoaFisica> lista = new ArrayList();
            PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement("SELECT * from P_FISICA");
                ResultSet rs = ps.executeQuery();
                while (rs.next() == true) {
                    PF = new PessoaFisica(rs.getString("codigo"),rs.getString("nome"),
                                  rs.getString("email"),rs.getString("rua"),
                                  rs.getString("numero"),rs.getString("bairro"),
                                  rs.getString("cidade"),rs.getString("uf"),
                                  rs.getString("cep"),rs.getString("ativo"));
                PF.setVendedor_responsavel(rs.getString("vend_resp"));
                PF.setComplemento(rs.getString("complemento"));
                PF.setCel(rs.getString("cel"));
                PF.setTel(rs.getString("tel"));
                PF.setDtNasc(rs.getString("dtNasc"));
                PF.setRg(rs.getString("rg"));
                PF.setCpf(rs.getString("cpf"));
                    lista.add(PF);
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
            return (lista);

        }
        


    }
    
    public PessoaFisica consultaCPF(String codigo) {
        PessoaFisica p = null;
        PreparedStatement ps = null;
        try {  
            ps = conn.prepareStatement("SELECT * from P_Fisica where " +
                                                 "cpf = ?");
            ps.setString(1,codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next() == true ){
                p = new PessoaFisica (rs.getString("codigo"),rs.getString("nome"),
                                  rs.getString("email"),rs.getString("rua"),
                                  rs.getString("numero"),rs.getString("bairro"),
                                  rs.getString("cidade"),rs.getString("uf"),
                                  rs.getString("cep"),rs.getString("ativo"));
                p.setVendedor_responsavel(rs.getString("vend_resp"));
                p.setComplemento(rs.getString("complemento"));
                p.setCel(rs.getString("cel"));
                p.setTel(rs.getString("tel"));
                p.setDtNasc(rs.getString("dtNasc"));
                p.setRg(rs.getString("rg"));
                p.setCpf(rs.getString("cpf"));
                
            }             
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
        return  (p);
    }   

}
