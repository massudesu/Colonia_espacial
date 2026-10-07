package habitantes;

public class Agricultor extends Habitantes {

    public Agricultor(String nome, int idade, double saude, double energia, double saldo) {
        super(nome, idade, saude, energia, saldo);
    }

    @Override
    public String trabalhar() {
        if (gastarEnergiaEGanharSaldo()) {
            System.out.println(getNome() + " cultivou a terra e gerou +10 de Alimento!");
            return "ALIMENTO";
        }
        return null;
    }
}