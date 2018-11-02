package projeto.vendas.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.vendas.model.Produto;

public class DaoProduto {

    private Connection conn;

    public DaoProduto(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Produto> ListarProdutos() {
        Produto produto = null;
        ArrayList<Produto> lista = new ArrayList();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM produto");
            ResultSet rs = ps.executeQuery();
            while (rs.next() == true) {
                produto = new Produto(rs.getInt("CODIGO"),
                                      rs.getString("DESCRICAO"),
                                      rs.getInt("qtdEstoque"),
                                      rs.getFloat("valorUnitario"));
                produto.setImpostoConfins(rs.getFloat("impostoConfins"));
                produto.setImpostoIcms(rs.getFloat("impostoICMS"));
                produto.setImpostoIpi(rs.getFloat("impostoIPI"));
                produto.setImpostoPis(rs.getFloat("impostoPIS"));
                lista.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (lista);
    }

    public Produto consultar(int codigo) {
        Produto produto = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Select * from PRODUTO Where CODIGO = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                produto = new Produto(rs.getInt("codigo"), rs.getString("descricao"),
                        rs.getInt("qtdEstoque"), rs.getFloat("valorUnitario"));
                produto.setImpostoConfins(rs.getFloat("impostoConfins"));
                produto.setImpostoIcms(rs.getFloat("impostoICMS"));
                produto.setImpostoIpi(rs.getFloat("impostoIPI"));
                produto.setImpostoPis(rs.getFloat("impostoPIS"));


            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return produto;
    }
}
