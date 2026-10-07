package recursos;

public abstract class Recursos {

    private String nome;
    private float quantidade;
    private float capacidadeMaxima;

    public Recursos(String nome, float quantidade, float capacidadeMaxima) {
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        if (quantidade < 0) this.quantidade = 0;
        else if (quantidade > capacidadeMaxima) this.quantidade = capacidadeMaxima;
        else this.quantidade = quantidade;
    }

    public void adicionarQtd(float qtd) {
        if (quantidade + qtd <= capacidadeMaxima) {
            quantidade += qtd;
            System.out.println(qtd + " unidades de " + nome + " adicionadas!");
        } else {
            quantidade = capacidadeMaxima;
            System.out.println(nome + " atingiu a capacidade máxima (" + capacidadeMaxima + ")!");
        }
    }

    public boolean consumirQtd(float qtd) {
        if (quantidade >= qtd) {
            quantidade -= qtd;
            System.out.println(qtd + " de " + nome + " consumido!");
            return true;
        } else {
            System.out.println("Recurso insuficiente de " + nome + "! Necessário: " + qtd + ", Atual: " + quantidade);
            return false;
        }
    }

    public void mostrarQuantidade() {
        System.out.println(nome + ": " + quantidade + "/" + capacidadeMaxima);
    }

    public String getNome() { return nome; }
    public float getQuantidade() { return quantidade; }
    public float getCapacidadeMaxima() { return capacidadeMaxima; }
}