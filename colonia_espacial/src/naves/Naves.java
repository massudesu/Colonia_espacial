package naves;
public abstract class Naves {

    // Atributos
    private String nome;
    private int capacidade;
    private Combustivel combustivel;
    private int velocidade;

    // Construtor
    public Naves(
            String nome,
            int capacidade,
            Combustivel combustivel,
            int velocidade
    ) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.combustivel = combustivel;
        this.velocidade = velocidade;
    }

    // Viaja com a nave
    public void viajar() {
        if (combustivel == Combustivel.VAZIO) {
            System.out.println(nome + " não pode viajar: combustível vazio.");
            return;
        }

        System.out.println(nome + " está viajando a "
                + velocidade + " km/h.");

        abastecerConsumo();
    }

    // Simula o consumo de combustível
    public void abastecerConsumo() {
        if (combustivel == Combustivel.CHEIO) {
            combustivel = Combustivel.RESERVA;
        } else if (combustivel == Combustivel.RESERVA) {
            combustivel = Combustivel.VAZIO;
        }
    }

    // Mostra o status da nave
    public void mostrarStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Capacidade: " + capacidade);
        System.out.println("Combustível: " + combustivel);
        System.out.println("Velocidade: " + velocidade + " km/h");
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public int getVelocidade() {
        return velocidade;
    }

    // Setter
    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }
}
