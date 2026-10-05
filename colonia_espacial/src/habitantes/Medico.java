package habitantes;

public class Medico extends Habitantes {

    // Atributos
    private String especialidade;
    private int pacientes;

    // Construtor
    public Medico(
            String nome,
            int idade,
            double saude,
            double energia,
            double saldo,
            String especialidade,
            int pacientes
    ) {

        super(nome, idade, saude, energia, saldo);

        this.especialidade = especialidade;
        this.pacientes = pacientes;
    }

    @Override
    public void trabalhar() {
        tratar();
    }

    public void tratar() {
        System.out.println(getNome() + " está tratando pacientes.");
    }
}