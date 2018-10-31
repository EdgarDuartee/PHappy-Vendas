package projeto.vendas.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.vendas.model.Vendedor;



public class DaoVendedor {
    private Connection conn;
    private ArrayList<Vendedor> vendedores;
    
    public DaoVendedor(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {      
            ps = conn.prepareStatement("INSERT INTO Usuario_Sistema(codigo, nome,"
                                       + "rg, cpf, telefone, celular , email, "
                                       + "dtnasc , cidade , uf, rua, numero, "
                                       + "cep , bairro , permissao , senha, complemento,"
                                       + "dtInicio, ativo)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            ps.setInt(1, vendedor.getCodigo());
            ps.setString(2, vendedor.getNome());
            ps.setString(3, vendedor.getRg());
            ps.setString(4, vendedor.getCpf());
            ps.setString(5, vendedor.getTel());
            ps.setString(6, vendedor.getCel());
            ps.setString(7, vendedor.getEmail());
            ps.setString(8, vendedor.getDataNasc());
            ps.setString(9, vendedor.getCidade());
            ps.setString(10, vendedor.getUf());
            ps.setString(11, vendedor.getRua());
            ps.setString(12, vendedor.getNumero());
            ps.setString(13, vendedor.getCep());
            ps.setString(14, vendedor.getBairro());
            ps.setInt(15, vendedor.getPermissao());
            ps.setString(16, vendedor.getSenha());
            ps.setString(17, vendedor.getComplemento());
            ps.setString(18,vendedor.getDtInicio());
            ps.setString(19,"A");
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }

    }
    
    public Vendedor consultar(int codigo) {
        Vendedor v = null;
        PreparedStatement ps = null;
        try {     
            ps = conn.prepareStatement("SELECT * from Colaboradores where " +
                                                 "CODIGO = ?");
            ps.setInt(1,codigo);
  
            ResultSet rs = ps.executeQuery();            
            
            if(rs.next() == true ){
                v = new Vendedor (rs.getInt("codigo"),rs.getString("nome"),
                                  rs.getString("rg"),rs.getString("cpf"),
                                  rs.getString("email"),rs.getString("telefone"),
                                  rs.getString("celular"),rs.getString("dtNasc"),
                                  rs.getString("rua"),rs.getString("numero"),
                                  rs.getString("bairro"),rs.getString("cidade"),
                                  rs.getString("uf"),rs.getString("cep"));
                v.setComplemento(rs.getString("complemento"));
                v.setDtInicio("dtInicio");
            }             
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
        return  (v);
    }   
    
    public ArrayList<Vendedor> listarVendedores(){
        Vendedor v = null;
        PreparedStatement ps = null;

        try{
            ps = conn.prepareStatement("SELECT CODIGO from Usuario_Sistema where " +
                                                 "ativo = ?");
            
            ps.setString(1,"A");
             
            ResultSet rs = ps.executeQuery();
             
            vendedores = new ArrayList<Vendedor>();
             
            
            while(rs.next() == true){
                ps=conn.prepareStatement("SELECT * from usuario_sistema "
                        + "where CODIGO = ?");
                
                ps.setInt(1, rs.getInt("codigo"));
                ResultSet r = ps.executeQuery();
                
                if(r.next() ==true){
                    v = new Vendedor (r.getInt("codigo"),r.getString("nome"),
                                  r.getString("rg"),r.getString("cpf"),
                                  r.getString("email"),r.getString("telefone"),
                                  r.getString("celular"),r.getString("dtNasc"),
                                  r.getString("rua"),r.getString("numero"),
                                  r.getString("bairro"),r.getString("cidade"),
                                  r.getString("uf"),r.getString("cep"));
                    v.setAtivo("ativo");
                    v.setDtInicio("dtInicio");
                }
                vendedores.add(v);
            }
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return vendedores;
    } 

    public void alterar(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE usuario_sistema set Rua = ?,"
                                       + " Numero = ?, Bairro = ?, Cidade = ?,"
                                       + " uf = ?, Cep = ?, Complemento = ?,"
                                       + " Telefone = ?, Celular = ?,"
                                       + "Email = ?, Permissao = ?, senha = ?"  
                                       + "where codigo = ?");
            
            ps.setString(1, vendedor.getRua());
            ps.setString(2, vendedor.getNumero());
            ps.setString(3, vendedor.getBairro());
            ps.setString(4, vendedor.getCidade());
            ps.setString(5, vendedor.getUf());
            ps.setString(6, vendedor.getCep());
            ps.setString(7, vendedor.getComplemento());
            ps.setString(8, vendedor.getTel());
            ps.setString(9, vendedor.getCel());
            ps.setString(10, vendedor.getEmail());
            ps.setInt(11, vendedor.getPermissao());
            ps.setString(12, vendedor.getSenha());
            ps.setInt(13, vendedor.getCodigo());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }

    public void alterarsenha(Vendedor vendedor){
         PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE usuario_sistema set senha = ?" 
                                       + "where codigo = ?");
            
            ps.setString(1, vendedor.getSenha());
            ps.setInt(2, vendedor.getCodigo());

           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterarpermissao(Vendedor vendedor){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE usuario_sistema set permissao = ?," 
                                       + "where codigo = ?");
            
            ps.setString(1, vendedor.getRua());
            ps.setInt(2, vendedor.getPermissao());

           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }

    public void desativar(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update Usuario_Sistema set ativo = ?"
                    + "Where codigo = ?");
            
            ps.setString(1,"I");
            ps.setInt(2, vendedor.getCodigo());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }

    public Vendedor consultarTbVend(int codigo) {
        Vendedor v1 = null;
        PreparedStatement ps = null;
        try {      
            ps = conn.prepareStatement("SELECT * from Usuario_Sistema where " +
                                                 "CODIGO = ?");
            ps.setInt(1,codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next() == true ){
                v1 = new Vendedor (rs.getInt("codigo"),rs.getString("nome"),
                                  rs.getString("rg"),rs.getString("cpf"),
                                  rs.getString("email"),rs.getString("telefone"),
                                  rs.getString("celular"),rs.getString("dtNasc"),
                                  rs.getString("rua"),rs.getString("numero"),
                                  rs.getString("bairro"),rs.getString("cidade"),
                                  rs.getString("uf"),rs.getString("cep"));
                v1.setComplemento(rs.getString("complemento"));
                v1.setPermissao(rs.getInt("permissao"));
                v1.setAtivo(rs.getString("ativo"));
                v1.setDtInicio("dtInicio");
            }             
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
        return  (v1);
    }

    public void reativarVendedor(Vendedor vendedor){
        PreparedStatement ps = null;
        try {      
            ps = conn.prepareStatement("update Usuario_Sistema set ativo = ?"
                    + "Where codigo = ?");
            
            ps.setString(1,"A");
            ps.setInt(2,vendedor.getCodigo());
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }

    }

    public void trocaResponsabilidade(int codigoNovo,String nomeNovo,int codigoAntigo) {
        PreparedStatement ps = null;
        try {      
            ps = conn.prepareStatement("update p_fisica set cod_vend_resp = ?,"
                    + "vend_resp = ?"
                    + "Where cod_vend_resp = ?");
            
            ps.setInt(1,codigoNovo);
            ps.setString(2,nomeNovo);
            ps.setInt(3,codigoAntigo);
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
        PreparedStatement ps1 = null;
        try {      
            ps1 = conn.prepareStatement("update p_juridica set cod_vend_resp = ?,"
                    + "vend_resp = ?"
                    + "Where cod_vend_resp = ?");
            
            ps1.setInt(1,codigoNovo);
            ps1.setString(2,nomeNovo);
            ps1.setInt(3,codigoAntigo);
            
            ps1.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}