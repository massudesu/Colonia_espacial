package estruturas;


public abstract class Estruturas {

    // Atributos
    private String nome;
    private int nivel;
    private float vida;
    private float capacidade;

    // Construtor
    public Estruturas(
            String nome,
            int nivel,
            float vida,
            float capacidade
    ) {
        this.nome = nome;
        this.nivel = nivel;
        this.vida = vida;
        this.capacidade = capacidade;
    }

    // Métodos
    public void construir() {
        System.out.println(nome + " está sendo construída.");
    }

    public void melhorar() {
        nivel++;
        System.out.println(nome + " foi melhorada para o nível " + nivel);
    }

    public void receberDano(float dano) {
        if (dano <= 0) {
            System.out.println("O dano deve ser positivo.");
            return;
        }

        vida -= dano;

        if (vida < 0) {
            vida = 0;
        }

        System.out.println(nome + " recebeu " + dano + " de dano.");
    }

    public void reparar() {
        vida = capacidade;

        System.out.println(nome + " foi reparada.");
    }

    public void produzir() {
        System.out.println(nome + " está produzindo.");
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public float getVida() {
        return vida;
    }

    public float getCapacidade() {
        return capacidade;
    }
}