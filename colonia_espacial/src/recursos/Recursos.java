
package recursos;
public abstract class Recursos {

    // Atributos
    private String nome;
    private float quantidade;
    private float capacidadeMaxima;

    // Construtor
    public Recursos(
            String nome,
            float quantidade,
            float capacidadeMaxima
    ) {
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;

        if (quantidade < 0) {
            this.quantidade = 0;
        } else if (quantidade > capacidadeMaxima) {
            this.quantidade = capacidadeMaxima;
        } else {
            this.quantidade = quantidade;
        }
    }

    // Adiciona uma unidade do recurso
    public void adicionar() {
        if (quantidade < capacidadeMaxima) {
            quantidade++;
            System.out.println(nome + " adicionado!");
        } else {
            System.out.println(nome + " atingiu a capacidade máxima!");
        }
    }

    // Consome uma unidade do recurso
    public void consumir() {
        if (quantidade > 0) {
            quantidade--;
            System.out.println(nome + " consumido!");
        } else {
            System.out.println("Não há " + nome + " disponível!");
        }
    }

    // Mostra a quantidade disponível
    public void mostrarQuantidade() {
        System.out.println(
                nome + ": " + quantidade + "/" + capacidadeMaxima
        );
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public float getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
}
