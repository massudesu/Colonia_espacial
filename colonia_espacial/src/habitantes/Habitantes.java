package habitantes;

public abstract class Habitantes {

    private String nome;
    private int idade;
    private double saude;
    private double energia;
    private double saldo;

    public Habitantes(String nome, int idade, double saude, double energia, double saldo) {
        this.nome = nome;
        this.idade = idade;
        this.saude = saude;
        this.energia = energia;
        this.saldo = saldo;
    }

    public abstract String trabalhar();

    public boolean gastarEnergiaEGanharSaldo() {
        if (energia < 50) {
            System.out.println(nome + " não tem energia suficiente para trabalhar! (Energia atual: " + energia + ")");
            return false;
        }
        energia -= 50;
        saldo += 25;
        System.out.println(nome + " trabalhou: -50 de Energia | +R$ 25,00 de Saldo.");
        return true;
    }

    public void descansar() {
        if (energia >= 100) {
            System.out.println(nome + " já está com a energia no máximo (100)!");
            energia = 100;
        } else {
            energia += 50;
            if (energia > 100) energia = 100;
            System.out.println(nome + " descansou! Energia atual: " + energia);
        }
    }

    public void receberDinheiro(double valor) {
        saldo += valor;
        System.out.println(nome + " recebeu R$ " + valor);
    }

    public void sofrerDano(double valor) {
        if (saude <= 0) {
            System.out.println(nome + " não pode sofrer mais dano.");
        } else {
            saude -= valor;
            if (saude < 0) saude = 0;
            System.out.println(nome + " sofreu dano de " + valor);
        }
    }

    public void recuperarSaude(double valor) {
        if (saude >= 100) {
            System.out.println(nome + " já está totalmente saudável!");
        } else {
            saude += valor;
            if (saude > 100) saude = 100;
            System.out.println(nome + " recuperou saúde! Saúde atual: " + saude);
        }
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public double getSaude() { return saude; }
    public double getEnergia() { return energia; }
    public double getSaldo() { return saldo; }
}