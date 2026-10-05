package habitantes;

public class Agricultor extends Habitantes {

    // Construtor
    public Agricultor(
            String nome,
            int idade,
            double saude,
            double energia,
            double saldo
    ) {
        super(nome, idade, saude, energia, saldo);
    }

    @Override
    public void trabalhar() {
        cultivar();
    }

    public void cultivar() {
        System.out.println(getNome() + " está trabalhando na agricultura.");
    }

    public void colher() {
        System.out.println(getNome() + " está realizando a colheita.");
    }
}