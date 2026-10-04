package habitantes;

public class Agricultor extends Habitantes {

    // Atributos
    private String tipoCultivo;
    private double produtividade;

    // Construtor
    public Agricultor(
            String nome,
            int idade,
            double saude,
            double energia,
            double salario,
            String tipoCultivo,
            double produtividade
            ) {

        super(nome, idade, saude, energia, salario);

        this.tipoCultivo = tipoCultivo;
        this.produtividade = produtividade;
    }

    @Override
    public void trabalhar() {
        cultivar();
    }

    public void cultivar() {
        System.out.println(getNome() + " está cultivando "
                + tipoCultivo + ".");
    }

    public void colher() {
        System.out.println(getNome() + " está realizando a colheita.");
    }
}