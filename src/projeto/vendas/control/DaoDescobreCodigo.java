/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.vendas.control;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import projeto.vendas.model.PessoaFisica;
import projeto.vendas.model.PessoaJuridica;
import projeto.vendas.model.Vendedor;

/**
 *
 * @author EdgarSamsung
 */
public class DaoDescobreCodigo {
    private Connection conn;
    
    public DaoDescobreCodigo(Connection conn) {
         this.conn = conn;
    }
    
    public int consultarCodPF() {
        PessoaFisica p = null;
        
        String seq = "";
        int aux = 0;
        
        PreparedStatement ps = null;
        try {      
            ps = conn.prepareStatement("SELECT codigo from P_Fisica");                                  
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next() == true ){
                seq = rs.getString("codigo");
            }
            if(seq.length()>2){
                aux = parseInt(seq.substring(2,seq.length()).replace(" ",""));
            }
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
        return  (aux);
    }
    
    public int consultarCodPJ() {
        PessoaJuridica p = null;
        
        String seq = "";
        int aux = 0;
        
        PreparedStatement ps = null;
        try {      
            ps = conn.prepareStatement("SELECT codigo from P_Juridica");                                  
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next() == true ){
                seq = rs.getString("codigo");
            }
            if(seq.length()>2){
                aux = parseInt(seq.substring(2,seq.length()).replace(" ",""));
            }
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
        return  (aux);
    }
  
}
