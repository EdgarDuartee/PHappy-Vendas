
package projeto.vendas.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class Conexao {
    private String connectionString;
   private String driver;
   private String usuario;
   private String senha;
   private Connection connection=null;

   public Conexao() {
        //conexao Edgar
        this.usuario = "Edgar";
        this.senha = "hercules";
       
        //conexao Luis
//        this.usuario = "fernando";
//        this.senha = "fernando98";   
        
        //conexao FACULDADE
        //this.usuario = "";
        //this.senha = "";   
   }

   public void setConnectionString() {
//        setar conexao Edgar
        this.connectionString = "jdbc:oracle:thin:@localhost:1523:xe";
        
        //setar conexao Luiz
//        this.connectionString = "jdbc:oracle:thin:@localhost:1521:xe";
        
        //setar conexao FACULDADE
        //this.connectionString = "jdbc:oracle:thin:@Apolo:1521:xe";
   }

   public void setDriver() {
        this.driver = "oracle.jdbc.driver.OracleDriver";
   }
   
   public Connection conectar() {
        
	   if (connection == null){
	      try {
                 Class.forName(driver);
            
                 connection = DriverManager.getConnection(connectionString, usuario, senha);               
	         System.out.println("Conexao OK");
              }catch (Exception ex) {
                  System.out.println("Falha na Conexao");
                  System.out.println(ex.toString() + ex.getMessage());
          }
	   }
       
	   return connection;
   }
   
   public void fecharConexao(){
        if (connection != null){
	   try {
                  connection.close();
           } catch (SQLException ex) {
                   System.out.println(ex.toString());    
           }
        }   
    }
}
