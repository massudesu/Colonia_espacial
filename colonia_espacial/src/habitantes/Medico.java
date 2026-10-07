package habitantes;

public class Medico extends Habitantes {

    private String especialidade;
    private int pacientes;

    public Medico(String nome, int idade, double saude, double energia, double saldo, String especialidade, int pacientes) {
        super(nome, idade, saude, energia, saldo);
        this.especialidade = especialidade;
        this.pacientes = pacientes;
    }

    @Override
    public String trabalhar() {
        if (gastarEnergiaEGanharSaldo()) {
            System.out.println(getNome() + " purificou suprimentos e gerou +10 de Água!");
            return "AGUA";
        }
        return null;
    }
}