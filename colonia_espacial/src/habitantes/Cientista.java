package habitantes;

public class Cientista extends Habitantes {

    private String areaPesquisa;
    private int nivelPesquisa;

    public Cientista(String nome, int idade, double saude, double energia, double saldo, String areaPesquisa, int nivelPesquisa) {
        super(nome, idade, saude, energia, saldo);
        this.areaPesquisa = areaPesquisa;
        this.nivelPesquisa = nivelPesquisa;
    }

    @Override
    public String trabalhar() {
        if (gastarEnergiaEGanharSaldo()) {
            System.out.println(getNome() + " pesquisou fontes de energia e gerou +10 de Energia!");
            return "ENERGIA";
        }
        return null;
    }
}