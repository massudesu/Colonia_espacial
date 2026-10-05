import habitantes.*;
import estruturas.*;
import recursos.*;
import naves.*;
import missoes.*;

import java.util.ArrayList;
import java.util.List;
import static java.lang.IO.*;
void main(){

    List<Habitantes> habitantes = new ArrayList<>();
    List<Estruturas> estruturas = new ArrayList<>();
    List<Recursos> recursos = new ArrayList<>();
    List<Naves> naves = new ArrayList<>();
    List<Missoes> missoes = new ArrayList<>();

    habitantes.add(new Agricultor("Toninho", 50, 100, 100, 1000));
    habitantes.add(new Cientista("Carlos", 25, 100, 100, 500, "Astrofisica", 2));
    habitantes.add(new Engenheiro("Nicolas", 21, 100, 100, 800, "Mecanica Espacial", 3));
    habitantes.add(new Medico("Jullia", 19, 100, 100, 1200, "Traumatologista", 2));

    estruturas.add(new Fazenda("Fazenda Toninhos", 1, 100, 50, "Milho", 1.5));
    estruturas.add(new Hospital("Hospital central", 1 , 200, 20));

    recursos.add(new Agua(50,100));
    recursos.add(new Alimento(40, 100));
    recursos.add(new Energia(80,100));

    Naves naveInicial = new NaveExploracao("LanceX",5, Combustivel.CHEIO, 12000);
    naves.add(naveInicial);

    missoes.add(new MissaoExploracao("Explorar Marte", "Mapear a cratera do sul",5, naveInicial));

    boolean executando = true;

    println("Bem-vindo você esta na Colonia Espacial");

    while (executando){
        println("--- Menu Principal ---");
        println("1. Gerenciar Habitantes");
        println("2. Gerenciar Estruturas");
        println("3. Gerenciar Recursos");
        println("4. Gerenciar Naves");
        println("5. Gerenciar Missoes");
        println("0. Sair");
        int opcao = Integer.parseInt(readln("Escolha uma opção: "));

        switch (opcao){
            case 1:
                println("--- GERENCIAR HABITANTES ---");
                println("1. Listar Habitantes");
                println("2. Fazer Habitante Trabalhar");
                println("3. Fazer Habitante Descansar");
                println("4. Criar Novo Habitante");
                int opcaoHab = Integer.parseInt(readln("Escolha: "));

                switch (opcaoHab) {
                    case 1:
                        println("--- Lista de Habitantes ---");
                        for (int i = 0; i < habitantes.size(); i++) {
                            Habitantes h = habitantes.get(i);
                            println(i + ". " + h.getNome() + " (" + h.getClass().getSimpleName() +
                                    ") - Saúde: " + h.getSaude() + " | Energia: " + h.getEnergia() + " | Saldo: R$" + h.getSaldo());
                        }
                        break;

                    case 2:
                        if (habitantes.isEmpty()) break;
                        int indiceTrab = Integer.parseInt(readln("Escolha o índice do habitante: "));
                        if (indiceTrab >= 0 && indiceTrab < habitantes.size()) {
                            habitantes.get(indiceTrab).trabalhar();
                        } else {
                            println("Índice inválido!");
                        }
                        break;

                    case 3:
                        if (habitantes.isEmpty()) break;
                        int indiceDesc = Integer.parseInt(readln("Escolha o índice do habitante: "));
                        if (indiceDesc >= 0 && indiceDesc < habitantes.size()) {
                            habitantes.get(indiceDesc).descansar();
                        } else {
                            println("Índice inválido!");
                        }
                        break;

                    case 4:
                        String nomeHab = readln("Nome do Habitante: ");
                        int idade = Integer.parseInt(readln("Idade: "));
                        int tipoHab = Integer.parseInt(readln("Tipo: 1. Agricultor | 2. Cientista | 3. Engenheiro | 4. Médico"));

                        switch (tipoHab) {
                            case 1:
                                habitantes.add(new Agricultor(nomeHab, idade, 100, 100, 0));
                                break;
                            case 2:
                                habitantes.add(new Cientista(nomeHab, idade, 100, 100, 0, "Geral", 1));
                                break;
                            case 3:
                                habitantes.add(new Engenheiro(nomeHab, idade, 100, 100, 0, "Civil", 1));
                                break;
                            case 4:
                                habitantes.add(new Medico(nomeHab, idade, 100, 100, 0, "Geral", 0));
                                break;
                            default:
                                println("Tipo inválido!");
                        }
                        println("Habitante criado com sucesso!");
                        break;
                }
                break;
        }
    }
}