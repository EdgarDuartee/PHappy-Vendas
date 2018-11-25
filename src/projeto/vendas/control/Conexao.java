package projeto.vendas.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author
 */
public class Conexao {

    public Statement stm;
    public  ResultSet res;
    private String connectionString;
    private String driver;
    private String usuario;
    private String senha;
    private Connection connection = null;

    public Conexao() {
        //conexao Edgar
//        this.usuario = "Edgar";
//        this.senha = "hercules";

       // this.usuario = "Edgar";
        //this.senha = "hercules";
       
        //conexao Luis
        this.usuario = "fernando";
        this.senha = "fernando98"; 
  
        
        //conexao FACULDADE
//        this.usuario = "BD1621028";
//        this.senha = "BD1621028";   
        
        //conexao Cleiton
//       this.usuario = "System";
//       this.senha = "Cleiton";  
   }

    public void setConnectionString() {
//        setar conexao Edgar
//        this.connectionString = "jdbc:oracle:thin:@localhost:1523:xe";

//        this.connectionString = "jdbc:oracle:thin:@localhost:1523:xe";
        
        //setar conexao Luiz
        //this.connectionString = "jdbc:oracle:thin:@localhost:1521:xe";
        
        //setar conexao FACULDADE
//        this.connectionString = "jdbc:oracle:thin:@Apolo:1521:xe";

        //setar conexao Cleiton
       this.connectionString = "jdbc:oracle:thin:@localhost:1521:xe";
        
   }

    public void setDriver() {
        this.driver = "oracle.jdbc.driver.OracleDriver";
    }

    public Connection conectar() {

        if (connection == null) {
            try {
                Class.forName(driver);

                connection = DriverManager.getConnection(connectionString, 
                       usuario,senha);
                System.out.println("Conexao OK");
            } catch (Exception ex) {
                System.out.println("Falha na Conexao");
                System.out.println(ex.toString() + ex.getMessage());
            }
        }

        return connection;
    }

    public void fecharConexao() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
   
    public void executaSQL (String sql){
        try{
            stm = connection.createStatement(res.TYPE_SCROLL_INSENSITIVE,res.CONCUR_READ_ONLY);
            res = stm.executeQuery(sql);
        }
        catch(SQLException ex){
            
        }
    }
}
