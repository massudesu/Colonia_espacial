package habitantes;

public class Engenheiro extends Habitantes {

    private String especialidade;
    private int nivelTecnico;

    public Engenheiro(String nome, int idade, double saude, double energia, double saldo, String especialidade, int nivelTecnico) {
        super(nome, idade, saude, energia, saldo);
        this.especialidade = especialidade;
        this.nivelTecnico = nivelTecnico;
    }

    @Override
    public String trabalhar() {
        if (gastarEnergiaEGanharSaldo()) {
            System.out.println(getNome() + " minerou/projetou e gerou +10 de Minério!");
            return "MINERIO";
        }
        return null;
    }
}