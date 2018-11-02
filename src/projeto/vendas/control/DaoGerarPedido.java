package projeto.vendas.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.vendas.model.Pedido;

public class DaoGerarPedido {

    private Connection conn;

    public DaoGerarPedido(Connection conn) {
        this.conn = conn;
    }

    public Pedido Consultar(int codigo) {
        PreparedStatement ps = null;
        Pedido pedido = null;
        try {
            ps = conn.prepareStatement("Select * from pedido where codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pedido = new Pedido(rs.getInt("codigo"),
                        rs.getString("clienteCod"),
                        rs.getInt("vendedorCod"),
                        rs.getString("dtPedido"),
                        rs.getFloat("TotalPedido"),
                        rs.getInt("Situacao"));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return (pedido);
    }

    public int getProximoCodigo() {
        int codigo = 1;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select max(codigo) as codigo from pedido");
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
                codigo = (rs.getInt("codigo"));
                codigo = codigo + 1;
            } else {
                codigo = 1;
            }
        } catch (SQLException ex) {
            System.out.println("ERRO SQL :" + ex);
        }
        return codigo;
    }

    public void inserir(Pedido pedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT into Pedido(codigo, clienteCod, vendedorCod,"
                    + "dtPedido, totalPedido, Situacao)"
                    + "VALUES(?, ?, ?, ? , ?, ?)");
            ps.setInt(1, pedido.getCodigo());
            ps.setString(2, pedido.getClienteCod());
            ps.setInt(3, pedido.getVendedorCod());
            ps.setString(4, pedido.getDtPedido());
            ps.setFloat(5, pedido.getTotal());
            ps.setInt(6, pedido.getSituacao());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void PrimeiroPedido(Pedido pedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT into Pedido(codigo, clientCod, vendedorCod,"
                    + "dtPedido, totalPedido,Situacao)"
                    + "VALUES(?, ?, ?, ? , ?)");

            ps.setInt(1, pedido.getCodigo());
            ps.setString(2, pedido.getClienteCod());
            ps.setInt(3, pedido.getVendedorCod());
            ps.setString(4, pedido.getDtPedido());
            ps.setFloat(5, pedido.getTotal());
            ps.setInt(6, pedido.getSituacao());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public ArrayList<Pedido> ListarPedidos() {
        Pedido pedido = null;
        ArrayList<Pedido> lista = new ArrayList();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from pedido");
            ResultSet rs = ps.executeQuery();
            while (rs.next() == true) {
                pedido = new Pedido(rs.getInt("CODIGO"),
                        rs.getString("ClienteCod"),
                        rs.getInt("VendedorCod"),
                        rs.getString("dtPedido"),
                        rs.getFloat("totalPedido"),
                        rs.getInt("Situacao"));
                lista.add(pedido);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (lista);
    }

    public ArrayList<Pedido> listarPedidosPorCod(String codigo) {
        Pedido pedido = null;
        ArrayList<Pedido> lista = new ArrayList();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from pedido where clienteCod = ?");

            ps.setString(1, codigo);

            ResultSet rs = ps.executeQuery();
            while (rs.next() == true) {
                pedido = new Pedido(rs.getInt("CODIGO"),
                        rs.getString("ClienteCod"),
                        rs.getInt("VendedorCod"),
                        rs.getString("dtPedido"),
                        rs.getFloat("totalPedido"),
                        rs.getInt("Situacao"));
                lista.add(pedido);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (lista);
    }

    public ArrayList<Pedido> listarPedidosDataSituacao(int Situcao,String dtInicio, String dtFinal) {
        Pedido pedido = null;
        ArrayList<Pedido> lista = new ArrayList();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from pedido");
            ResultSet rs = ps.executeQuery();
            while (rs.next() == true) {
                pedido = new Pedido(rs.getInt("CODIGO"),
                        rs.getString("ClientCod"),
                        rs.getInt("VendedorCod"),
                        rs.getString("dtPedido"),
                        rs.getFloat("totalPedido"),
                        rs.getInt("Situacao"));
                lista.add(pedido);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (lista);
    }

    public void aprovar(int pedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE Pedido set situacao = ? where "
                                        + "codigo = ?");
            
            ps.setInt(1,1);  
            ps.setInt(2,pedido);
             
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void reprovar(int pedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE Pedido set situacao = ? where "
                                        + "codigo = ?");
            
            ps.setInt(1,2);  
            ps.setInt(2,pedido);
             
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
        public void Faturar(int pedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE Pedido set situacao = ? where "
                                        + "codigo = ?");
            
            ps.setInt(1,4);  
            ps.setInt(2,pedido);
             
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
}
