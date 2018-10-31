
package projeto.vendas.model;

public class Produto {
    private int codigo;
    private String descricao;
    private int qtdEstoque;
    private String prodCat;
    private float valorUnitario;
    private float impostoIpi;
    private float impostoPis;
    private float impostoIcms;
    private float impostoConfins;

    public Produto(int codigo, String descricao, int qtdEstoque, float valorUnitario) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.valorUnitario = valorUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getProdCat() {
        return prodCat;
    }

    public void setProdCat(String prodCat) {
        this.prodCat = prodCat;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public float getImpostoIpi() {
        return impostoIpi;
    }

    public void setImpostoIpi(float impostoIpi) {
        this.impostoIpi = impostoIpi;
    }

    public float getImpostoPis() {
        return impostoPis;
    }

    public void setImpostoPis(float impostoPis) {
        this.impostoPis = impostoPis;
    }

    public float getImpostoIcms() {
        return impostoIcms;
    }

    public void setImpostoIcms(float impostoIcms) {
        this.impostoIcms = impostoIcms;
    }

    public float getImpostoConfins() {
        return impostoConfins;
    }

    public void setImpostoConfins(float impostoConfins) {
        this.impostoConfins = impostoConfins;
    }
}
