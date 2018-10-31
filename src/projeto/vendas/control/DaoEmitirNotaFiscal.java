
package projeto.vendas.control;

import java.sql.Connection;

public class DaoEmitirNotaFiscal {
    private Connection conn;

    public DaoEmitirNotaFiscal(Connection conn) {
        this.conn = conn;
    }
}
