/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.vendas.tabelas;

/**
 *
 * @author Fernando
 */
public class GuiControleEstrategico_ClienteGeral implements Comparable<GuiControleEstrategico_ClienteGeral> {
    private String nome;
    private float frequencia;
    private float maiorCompra;
    private float mediaCompras;
    private String produtoFavorito;

    public GuiControleEstrategico_ClienteGeral(String nome, float frequencia, float maiorCompra, float mediaCompras, String produtoFavorito) {
        this.nome = nome;
        this.frequencia = frequencia;
        this.maiorCompra = maiorCompra;
        this.mediaCompras = mediaCompras;
        this.produtoFavorito = produtoFavorito;
    }
    
    
    public int compareTo(GuiControleEstrategico_ClienteGeral outro) {
     if (this.frequencia > outro.getFrequencia()) {
          return -1;
     }
     if (this.frequencia < outro.getFrequencia()){
          return 1;
     }
     return 0;
}
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(float frequencia) {
        this.frequencia = frequencia;
    }

    public float getMaiorCompra() {
        return maiorCompra;
    }

    public void setMaiorCompra(float maiorCompra) {
        this.maiorCompra = maiorCompra;
    }

    public float getMediaCompras() {
        return mediaCompras;
    }

    public void setMediaCompras(float mediaCompras) {
        this.mediaCompras = mediaCompras;
    }

    public String getProdutoFavorito() {
        return produtoFavorito;
    }

    public void setProdutoFavorito(String produtoFavorito) {
        this.produtoFavorito = produtoFavorito;
    }
    
    
}
