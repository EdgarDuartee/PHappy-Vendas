
package projeto.vendas.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.vendas.model.NotaFiscal;

public class DaoEmitirNotaFiscal {
    private Connection conn;

    public DaoEmitirNotaFiscal(Connection conn) {
        this.conn = conn;
    }

    public NotaFiscal Consultar(int codigo) {
        PreparedStatement ps = null;
        NotaFiscal nf = null;
        try {
            ps = conn.prepareStatement("Select * from nota_fiscal where numero = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nf = new NotaFiscal(rs.getInt("numero"),
                        rs.getInt("serie"),
                        rs.getInt("PedidoCod"),
                        rs.getString("Tipo"),
                        rs.getString("CFOP"),
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
            ps = conn.prepareStatement("select max(numero) as codigo from Nota_Fiscal");
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
                    + "CFOP, Total,DataEmissao,HoraEmissao,TRANSPCOD,TRANSP_DATASAIDA,TRANSP_HORASAIDA)"
                    + "VALUES(?, ?, ?, ? , ?, ?, ?, ?, ?, ?,?)");
//            System.out.println("invalido 01");
            ps.setInt(1, nf.getNumero());
//            System.out.println("invalido 02");
            ps.setInt(2, nf.getSerie());
//            System.out.println("invalido 03");
            ps.setInt(3, nf.getPedidoCod());
//            System.out.println("invalido 04");
            ps.setString(4, nf.getTipo());
//            System.out.println("invalido 05");
            ps.setString(5, nf.getCFOP());
//            System.out.println("invalido 06");
            ps.setFloat(6, nf.getTotal());
//            System.out.println("invalido 07");
            ps.setString(7, nf.getDataEmissao());
//            System.out.println("invalido 08");
            ps.setString(8, nf.getHoraEmissao());
            System.out.println("invalido 09");
            ps.setInt(9, Integer.parseInt("20"));
            System.out.println("invalido 10");
            ps.setString(10,"Data");
            System.out.println("invalido 11");
            ps.setString(11,"Hora");


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
