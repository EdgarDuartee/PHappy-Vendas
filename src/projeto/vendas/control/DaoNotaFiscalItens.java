package projeto.vendas.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.vendas.model.NotaFiscal;
import projeto.vendas.model.NotaFiscalItens;
import projeto.vendas.model.PedidoProduto;

public class DaoNotaFiscalItens {

    private Connection conn;

    public DaoNotaFiscalItens(Connection conn) {
        this.conn = conn;
    }

    public void inserir(NotaFiscalItens NFitens) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT into Nota_Itens(NumeroNota, ProdutoCod, "
                    + "ProdutoDesc, ProdutoValor,"
                    + "ProdutoQTD, ProdutoPIS,ProdutoCOFINS,ProdutoIPI,ProdutoICMS)"
                    + "VALUES(?, ?, ?, ? , ?, ?, ?, ?, ?)");

            for (int i = 0; i < NFitens.getListaProdutos().size(); i++) {
                ps.setInt(1, NFitens.getNumero());
                ps.setInt(2, NFitens.getListaProdutos().get(i).getCodigo());
                ps.setString(3, NFitens.getListaProdutos().get(i).getDescricao());
                ps.setFloat(4, NFitens.getListaProdutos().get(i).getValorUnitario());
                ps.setInt(5, NFitens.getQtdPedidoProduto().get(i));
                ps.setFloat(6, NFitens.getListaProdutos().get(i).getImpostoPis());
                ps.setFloat(7, NFitens.getListaProdutos().get(i).getImpostoConfins());
                ps.setFloat(8, NFitens.getListaProdutos().get(i).getImpostoIpi());
                ps.setFloat(9, NFitens.getListaProdutos().get(i).getImpostoIcms());
                ps.execute();
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public ArrayList<NotaFiscal> ListarNotasFiscais() {
        NotaFiscal nf = null;
        ArrayList<NotaFiscal> lista = new ArrayList();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from pedido");
            ResultSet rs = ps.executeQuery();
            while (rs.next() == true) {
                nf = new NotaFiscal(rs.getInt("numero"),
                        rs.getInt("serie"),
                        rs.getInt("PedidoCod"),
                        rs.getString("Tipo"),
                        rs.getString("CFOP"),
                        rs.getFloat("Total"),
                        rs.getString("DataEmissao"),
                        rs.getString("HoraEmissao"),
                        rs.getInt("TranspCod"));
                lista.add(nf);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (lista);
    }

}
