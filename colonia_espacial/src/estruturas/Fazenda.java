package estruturas;

public class Fazenda extends Estruturas {

    private String tipoCultivo;
    private double produtividade;

    public Fazenda(String nome, int nivel, float vida, float capacidade,
                   String tipoCultivo, double produtividade) {
        super(nome, nivel, vida, capacidade);
        this.tipoCultivo = tipoCultivo;
        this.produtividade = produtividade;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public double getProdutividade() {
        return produtividade;
    }

    public void setProdutividade(double produtividade) {
        this.produtividade = produtividade;
    }

    @Override
    public void produzir() {
        System.out.println(getNome() + " está produzindo " + tipoCultivo + " com produtividade de " + produtividade + "x.");
    }
}