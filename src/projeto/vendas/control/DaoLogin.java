
package projeto.vendas.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import projeto.vendas.model.Login;

/**
 *
 * @author 
 */
public class DaoLogin {
    private Connection conn;
    
    public DaoLogin(Connection conn) {
         this.conn = conn;
    }
    public Login consultar(String usuario, String senha) {
        Login l = null;
        PreparedStatement ps = null;
        try { 
            ps = conn.prepareStatement("SELECT * from usuario_sistema where " +
                                                 "cpf = ? and senha = ?");
            ps.setString(1, usuario);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()== true ){
                l = new Login(usuario,senha);
                l.setNome(rs.getString("nome"));
                l.setCodigo(rs.getInt("codigo"));
                l.setPermissao(rs.getInt("permissao"));
            }               
        } 
        catch (SQLException ex) {
            System.out.println(ex.toString());   
        }
        return  (l);
    }
    
}
