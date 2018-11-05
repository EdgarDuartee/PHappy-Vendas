package projeto.vendas.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.vendas.model.NotaFiscal;

public class DaoNotaFiscal {

    private Connection conn;

    public DaoNotaFiscal(Connection conn) {
        this.conn = conn;
    }

    public NotaFiscal Consultar(int codigo) {
        PreparedStatement ps = null;
        NotaFiscal nf = null;
        try {
            ps = conn.prepareStatement("Select * from pedido where codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nf = new NotaFiscal(rs.getInt("numero"),
                        rs.getInt("serie"),
                        rs.getInt("PedidoCod"),
                        rs.getString("Tipo"),
                        rs.getFloat("CFOP"),
                        rs.getFloat("Total"),
                        rs.getString("DataEmissao"),
                        rs.getString("HoraEmissao"),
                        rs.getInt("TranspCod")
                );

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return (nf);
    }

    public int getProximoCodigo() {
        int codigo = 1;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select max(codigo) as codigo from Nota_Fiscal");
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

    public void inserir(NotaFiscal nf) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT into Nota_Fiscal(Numero, Serie, PedidoCOD, Tipo,"
                    + "CFOP, Total,DataEmissao,HoraEmissao,TranspCod)"
                    + "VALUES(?, ?, ?, ? , ?, ?,?,?,?)");
            ps.setInt(1, nf.getNumero());
            ps.setInt(2, nf.getSerie());
            ps.setInt(3, nf.getPedidoCod());
            ps.setString(4, nf.getTipo());
            ps.setFloat(5, nf.getCFOP());
            ps.setFloat(6, nf.getTotal());
            ps.setString(7, nf.getDataEmissao());
            ps.setString(8, nf.getHoraEmissao());
            ps.setInt(4, nf.getTranspCod());

            ps.execute();
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
                        rs.getFloat("CFOP"),
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
