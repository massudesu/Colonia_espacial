package habitantes;

public abstract class Habitantes {

    // Atributos
    private String nome;
    private int idade;
    private double saude;
    private double energia;
    private double saldo;

    // Construtor
    public Habitantes(
            String nome,
            int idade,
            double saude,
            double energia,
            double saldo
    ) {
        this.nome = nome;
        this.idade = idade;
        this.saude = saude;
        this.energia = energia;
        this.saldo = saldo;
    }

    // Metodo abstrato
    public abstract void trabalhar();

    // Metodos
    public void descansar() {
        energia += 10;
        System.out.println(nome + " está descansando.");
    }

    public void receberDinheiro(double valor) {
        saldo += valor;
        System.out.println(nome + " recebeu R$ " + valor);
    }

    public void sofrerDano(double valor) {

        if (saude < 0){
            System.out.println(nome + "Não pode sobre mais dano");
        }
        else {
            saude -= valor;
            if (saude < 0) {
                saude = 0;
                System.out.println(nome + " sofreu dano de " + valor);

            }
        }
    }

    public void  recuperarSaude(double valor) {
        if (saude > 100){
            System.out.println(nome + "Já esta totalmente saudavel");
        }
        else {
        saude += valor;
        if (saude > 100){
                saude = 100;
                System.out.println(nome + " recuperou " + valor);
            }
        }
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getSaude() {
        return saude;
    }

    public double getEnergia() {
        return energia;
    }

    public double getSaldo() {
        return saldo;
    }
}