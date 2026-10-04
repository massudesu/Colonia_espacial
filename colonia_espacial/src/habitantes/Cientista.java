package habitantes;

public class Cientista extends Habitantes {

    // Atributos
    private String areaPesquisa;
    private int nivelPesquisa;

    // Construtor
    public Cientista(
            String nome,
            int idade,
            double saude,
            double energia,
            double salario,
            String areaPesquisa,
            int nivelPesquisa
    ) {

        super(nome, idade, saude, energia, salario);

        this.areaPesquisa = areaPesquisa;
        this.nivelPesquisa = nivelPesquisa;
    }

    @Override
    public void trabalhar() {
        pesquisar();
    }

    public void pesquisar() {
        System.out.println(getNome() + " está realizando uma pesquisa.");
    }

    public void analisar() {
        System.out.println(getNome() + " está analisando os resultados.");
    }
}