package habitantes;

public class Engenheiro extends Habitantes {

    // Atributos
    private String especialidade;
    private int nivelTecnico;

    // Construtor
    public Engenheiro(
            String nome,
            int idade,
            double saude,
            double energia,
            double saldo,
            String especialidade,
            int nivelTecnico
    ) {

        super(nome, idade, saude, energia, saldo);

        this.especialidade = especialidade;
        this.nivelTecnico = nivelTecnico;
    }

    @Override
    public void trabalhar() {
        System.out.println(getNome() + " está trabalhando como engenheiro.");
    }

    public void reparar() {
        System.out.println(getNome() + " está reparando uma estrutura.");
    }

    public void construir() {
        System.out.println(getNome() + " está construindo uma estrutura.");
    }
}
