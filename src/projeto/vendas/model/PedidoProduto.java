
package projeto.vendas.model;

public class PedidoProduto {
    private int pedidoCod;
    private int produtoCod;
    private int produtoQtd;

    public PedidoProduto(int pedidoCod, int produtoCod, int produtoQtd) {
        this.pedidoCod = pedidoCod;
        this.produtoCod = produtoCod;
        this.produtoQtd = produtoQtd;
    }

    public int getPedidoCod() {
        return pedidoCod;
    }

    public void setPedidoCod(int pedidoCod) {
        this.pedidoCod = pedidoCod;
    }

    public int getProdutoCod() {
        return produtoCod;
    }

    public void setProdutoCod(int produtoCod) {
        this.produtoCod = produtoCod;
    }

    public int getProdutoQtd() {
        return produtoQtd;
    }

    public void setProdutoQtd(int produtoQtd) {
        this.produtoQtd = produtoQtd;
    }
    

  }
