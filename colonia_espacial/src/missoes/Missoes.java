package missoes;


import habitantes.Habitantes;
import naves.Naves;

import java.util.ArrayList;
import java.util.List;

public abstract class Missoes {

    // Atributos
    private String nome;
    private String descricao;
    private int duracao;
    private String status;
    private List<Habitantes> tripulacao;
    private Naves nave;

    // Construtor
    public Missoes(String nome, String descricao, int duracao, Naves nave) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.status = "Planejada";
        this.tripulacao = new ArrayList<>();
        this.nave = nave;
    }

    // Iniciar missão
    public void iniciar() {
        if (status.equals("Planejada")) {
            status = "Em andamento";
            System.out.println("Missão " + nome + " iniciada!");
        } else {
            System.out.println("Não é possível iniciar esta missão.");
        }
    }

    // Executar missão
    public void executar() {
        if (status.equals("Em andamento")) {
            System.out.println("Executando missão: " + nome);
            System.out.println("Descrição: " + descricao);
            System.out.println("Duração: " + duracao + " dias");
        } else {
            System.out.println("A missão não está em andamento.");
        }
    }

    // Finalizar missão
    public void finalizar() {
        if (status.equals("Em andamento")) {
            status = "Concluída";
            System.out.println("Missão " + nome + " finalizada!");
        } else {
            System.out.println("Não é possível finalizar esta missão.");
        }
    }

    // Cancelar missão
    public void cancelar() {
        if (status.equals("Concluída")) {
            System.out.println("Uma missão concluída não pode ser cancelada.");
            return;
        }

        status = "Cancelada";
        System.out.println("Missão " + nome + " cancelada.");
    }

    // Adicionar habitante à tripulação
    public void adicionarTripulante(Habitantes habitante) {
        tripulacao.add(habitante);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getStatus() {
        return status;
    }

    public List<Habitantes> getTripulacao() {
        return tripulacao;
    }

    public Naves getNave() {
        return nave;
    }
}
