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
                    + "nomefantasia,complemento"
                    + ",cod_vend_resp,"
                    + "vend_resp, ativo,dtInicio,contato1,"
                    + "nomecont1,contato2,nomecont2,"
                    + "contato3,nomecont3)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1, pessoaJuridica.getCodigo());
            ps.setString(2, pessoaJuridica.getEmail());
            ps.setString(3, pessoaJuridica.getRua());
            ps.setString(4, pessoaJuridica.getNumero());
            ps.setString(5, pessoaJuridica.getBairro());
            ps.setString(6, pessoaJuridica.getCidade());
            ps.setString(7, pessoaJuridica.getCep());
            ps.setString(8, pessoaJuridica.getUf());
            ps.setString(9, pessoaJuridica.getCnpj());
            ps.setString(10, pessoaJuridica.getNome());
            ps.setString(11, pessoaJuridica.getComplemento());
            ps.setInt(12, pessoaJuridica.getCod_vend_resp());
            ps.setString(13, pessoaJuridica.getVendedor_responsavel());
            ps.setString(14, "A");
            ps.setString(15, pessoaJuridica.getDtInicio());
            ps.setString(16, pessoaJuridica.getTel1());
            ps.setString(17, pessoaJuridica.getContato1());
            ps.setString(18, pessoaJuridica.getTel2());
            ps.setString(19, pessoaJuridica.getContato2());
            ps.setString(20, pessoaJuridica.getTel3());
            ps.setString(21, pessoaJuridica.getContato3());
            
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
                    + " cod_vend_resp = ? ,"
                    + " vend_resp = ?, contato1 = ?, contato2 = ?,"
                    + " contato3 = ?, nomecont1 = ?, nomecont2 = ?,"
                    + " nomecont3 = ?"
                    + "where codigo = ?");
            
            ps.setString(1, pessoaJuridica.getEmail());
            ps.setString(2, pessoaJuridica.getRua());
            ps.setString(3, pessoaJuridica.getNumero());
            ps.setString(4, pessoaJuridica.getBairro());
            ps.setString(5, pessoaJuridica.getCidade());
            ps.setString(6, pessoaJuridica.getUf());
            ps.setString(7, pessoaJuridica.getCep());
            ps.setString(8, pessoaJuridica.getComplemento());
            ps.setInt(9, pessoaJuridica.getCod_vend_resp());
            ps.setString(10, pessoaJuridica.getVendedor_responsavel());
            ps.setString(11, pessoaJuridica.getTel1());
            ps.setString(12, pessoaJuridica.getTel2());
            ps.setString(13, pessoaJuridica.getTel3());
            ps.setString(14, pessoaJuridica.getContato1());
            ps.setString(15, pessoaJuridica.getContato2());
            ps.setString(16, pessoaJuridica.getContato3());
            ps.setString(17, pessoaJuridica.getCodigo());
            
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
            
            ps.setString(1, ativo);
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
                    PJ = new PessoaJuridica(rs.getString("codigo"), rs.getString("nomefantasia"),
                            rs.getString("email"), rs.getString("rua"),
                            rs.getString("numero"), rs.getString("bairro"),
                            rs.getString("cidade"), rs.getString("uf"),
                            rs.getString("cep"), rs.getString("ativo"));
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
            ps = conn.prepareStatement("SELECT * from P_JURIDICA where "
                    + "CNPJ = ?");
            ps.setString(1, cnpj);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next() == true) {
                p = new PessoaJuridica(rs.getString("codigo"), rs.getString("nomefantasia"),
                        rs.getString("email"), rs.getString("rua"),
                        rs.getString("numero"), rs.getString("bairro"),
                        rs.getString("cidade"), rs.getString("uf"),
                        rs.getString("cep"), rs.getString("ativo"));
                p.setVendedor_responsavel(rs.getString("vend_resp"));
                p.setCod_vend_resp(rs.getInt("cod_vend_resp"));
                p.setComplemento(rs.getString("complemento"));
                p.setTel1(rs.getString("contato1"));
                p.setContato1(rs.getString("nomecont1"));
                p.setTel2(rs.getString("contato2"));
                p.setContato2(rs.getString("nomecont2"));
                p.setTel3(rs.getString("contato3"));
                p.setContato3(rs.getString("nomecont3"));
                p.setCnpj(rs.getString("CNPJ"));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (p);
    }
    
    public PessoaJuridica consultar(String codigo) {
        PessoaJuridica p = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from P_Juridica where "
                    + "CODIGO = ?");
            ps.setString(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next() == true) {
                p = new PessoaJuridica(rs.getString("codigo"), rs.getString("nomefantasia"),
                        rs.getString("email"), rs.getString("rua"),
                        rs.getString("numero"), rs.getString("bairro"),
                        rs.getString("cidade"), rs.getString("uf"),
                        rs.getString("cep"), rs.getString("ativo"));
                p.setVendedor_responsavel(rs.getString("vend_resp"));
                p.setCod_vend_resp(rs.getInt("cod_vend_resp"));
                p.setComplemento(rs.getString("complemento"));
                p.setTel1(rs.getString("contato1"));
                p.setContato1(rs.getString("nomecont1"));
                p.setTel2(rs.getString("contato2"));
                p.setContato2(rs.getString("nomecont2"));
                p.setTel3(rs.getString("contato3"));
                p.setContato3(rs.getString("nomecont3"));
                p.setCnpj(rs.getString("CNPJ"));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (p);
    }
    
    public ArrayList<PessoaJuridica> ListarPJPorCodVend(int codigo) {
        {
            PessoaJuridica PJ = null;
            ArrayList<PessoaJuridica> lista = new ArrayList();
            PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement("SELECT * from P_JURIDICA where cod_vend_resp = ?");
                ps.setInt(1, codigo);
                
                ResultSet rs = ps.executeQuery();
                while (rs.next() == true) {
                    PJ = new PessoaJuridica(rs.getString("codigo"), rs.getString("nomefantasia"),
                            rs.getString("email"), rs.getString("rua"),
                            rs.getString("numero"), rs.getString("bairro"),
                            rs.getString("cidade"), rs.getString("uf"),
                            rs.getString("cep"), rs.getString("ativo"));
                    PJ.setCnpj(rs.getString("CNPJ"));
                    lista.add(PJ);
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
            return (lista);
            
        }
    }
    
}
