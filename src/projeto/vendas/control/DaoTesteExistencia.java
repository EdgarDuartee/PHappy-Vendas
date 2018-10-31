package projeto.vendas.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.vendas.model.Vendedor;
import projeto.vendas.model.PessoaFisica;
import projeto.vendas.model.PessoaJuridica;



public class DaoTesteExistencia {
    private Connection conn;
    
    public DaoTesteExistencia(Connection conn) {
         this.conn = conn;
    }
 
    public Vendedor testeVendedor (int codigo) {
        Vendedor v = null;
        PreparedStatement ps = null;
        try {     
            ps = conn.prepareStatement("SELECT ativo from Usuario_Sistema where " +
                                                 "CODIGO = ?");
            ps.setInt(1,codigo);
  
            ResultSet rs = ps.executeQuery();            
            
            if(rs.next() == true ){ 
                v.setAtivo(rs.getString("ativo"));
            }             
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
        return  (v);
    }   
    
    public  PessoaFisica testeClientePF(int codigo) {
        PessoaFisica f = null;
        PreparedStatement ps = null;
        try {     
            ps = conn.prepareStatement("SELECT ativo from P_Fisica where " +
                                                 "CODIGO = ?");
            ps.setInt(1,codigo);
  
            ResultSet rs = ps.executeQuery();            
            
            if(rs.next() == true ){ 
                f.setAtivo(rs.getString("ativo"));
            }             
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
        return (f);
    }   
    
    public  PessoaJuridica testeClientePJ(int codigo) {
        PessoaJuridica j = null;
        PreparedStatement ps = null;
        try {     
            ps = conn.prepareStatement("SELECT ativo from P_Juridica where " +
                                                 "CODIGO = ?");
            ps.setInt(1,codigo);
  
            ResultSet rs = ps.executeQuery();            
            
            if(rs.next() == true ){ 
                j.setAtivo(rs.getString("ativo"));
            }             
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
        return (j);
    }   
}