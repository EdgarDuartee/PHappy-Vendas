
package projeto.vendas.model;

import java.util.ArrayList;

public class NotaFiscalItens {
    
    private int numero;
    private ArrayList<Produto> ListaProdutos;
    private ArrayList<Integer> QtdPedidoProduto;

    public NotaFiscalItens(int numero) {
        this.numero = numero;
        ListaProdutos = new ArrayList<Produto>();
        QtdPedidoProduto = new ArrayList<Integer>();
    }
    
    public void addProduto (Produto p){
        ListaProdutos.add(p);
    }
    
    public void addQtdProduto(int Qtd){
        QtdPedidoProduto.add(Qtd);
    }

    public ArrayList<Integer> getQtdPedidoProduto() {
        return QtdPedidoProduto;
    }

    public void setQtdPedidoProduto(ArrayList<Integer> QtdPedidoProduto) {
        this.QtdPedidoProduto = QtdPedidoProduto;
       
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Produto> getListaProdutos() {
        return ListaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> ListaProdutos) {
        this.ListaProdutos = ListaProdutos;
    }
    
}
