package projeto.vendas.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.vendas.model.PedidoProduto;
import projeto.vendas.model.Vendedor;

public class DaoPedidoProduto {

    private Connection conn;

    public DaoPedidoProduto(Connection conn) {
        this.conn = conn;
    }

    public void inserir(PedidoProduto pedidoProduto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO Pedido_Produto(pedidoCod, produtoCod, qtdProduto)"
                    + "VALUES(?,?,?)");

            ps.setInt(1, pedidoProduto.getPedidoCod());
            ps.setInt(2, pedidoProduto.getProdutoCod());
            ps.setInt(3, pedidoProduto.getProdutoQtd());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
        public ArrayList<PedidoProduto> listarPedidoProduto(int codigo) {
        ArrayList<PedidoProduto> lista = new ArrayList();
        PedidoProduto pedidoProduto = null;
        
         PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement("SELECT * from Pedido_Produto where pedidoCod = ?");
                ps.setInt(1, codigo);
                ResultSet rs = ps.executeQuery();
                while (rs.next() == true) {
                    pedidoProduto = new PedidoProduto(rs.getInt("pedidoCod"), rs.getInt("produtoCod"), rs.getInt("qtdProduto"));
                    lista.add(pedidoProduto);
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        return lista;
    }

}
