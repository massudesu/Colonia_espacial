import habitantes.*;
import estruturas.*;
import recursos.*;
import naves.*;
import missoes.*;

import java.util.ArrayList;
import java.util.List;
import static java.lang.IO.*;

Recursos buscarRecurso(List<Recursos> lista, String nome) {
    for (Recursos r : lista) {
        if (r.getNome().equalsIgnoreCase(nome)) return r;
    }
    return null;
}

        boolean validarEConsumirConstrucao(List<Recursos> recursos, float reqAlimento, float reqEnergia, float reqMinerio) {
            Recursos alimento = buscarRecurso(recursos, "Alimento");
            Recursos energia = buscarRecurso(recursos, "Energia");
            Recursos minerio = buscarRecurso(recursos, "Minério");

            if (alimento == null || energia == null || minerio == null) {
                println("Recursos não encontrados");
                return false;
            }

            if (alimento.getQuantidade() >= reqAlimento &&
                    energia.getQuantidade() >= reqEnergia &&
                    minerio.getQuantidade() >= reqMinerio) {

                alimento.consumirQtd(reqAlimento);
                energia.consumirQtd(reqEnergia);
                minerio.consumirQtd(reqMinerio);
                return true;
            } else {
                println("Recursos insuficientes para construir");
                println("Necessário -> Alimento: " + reqAlimento + " | Energia: " + reqEnergia + " | Minério: " + reqMinerio);
                println("Você possui -> Alimento: " + alimento.getQuantidade() + " | Energia: " + energia.getQuantidade() + " | Minério: " + minerio.getQuantidade());
                return false;
            }
        }

        void main(){

            List<Habitantes> habitantes = new ArrayList<>();
            List<Estruturas> estruturas = new ArrayList<>();
            List<Recursos> recursos = new ArrayList<>();
            List<Naves> naves = new ArrayList<>();
            List<Missoes> missoes = new ArrayList<>();


            recursos.add(new Alimento(60, 200));
            recursos.add(new Energia(60, 200));
            recursos.add(new Minerio(20, 200));
            recursos.add(new Agua(50, 200));

            habitantes.add(new Agricultor("Toninho", 50, 100, 100, 1000));
            habitantes.add(new Cientista("Carlos", 25, 100, 100, 500, "Astrofísica", 2));
            habitantes.add(new Engenheiro("Nicolas", 21, 100, 100, 800, "Mecânica Espacial", 3));
            habitantes.add(new Medico("Jullia", 19, 100, 100, 1200, "Traumatologista", 2));

            estruturas.add(new Fazenda("Fazenda Toninhos", 1, 100, 50, "Milho", 1.5));
            estruturas.add(new Hospital("Hospital Central", 1, 200, 20));

            Naves naveInicial = new NaveExploracao("LanceX", 5, Combustivel.CHEIO, 12000);
            naves.add(naveInicial);

            missoes.add(new MissaoExploracao("Explorar Marte", "Mapear a cratera do sul", 5, naveInicial));

            boolean executando = true;

            //Iniciando aqui
            println("Bem-vindo! Você está na Colônia Espacial");

            while (executando){
                println("\n--- Menu Principal ---");
                println("1. Gerenciar Habitantes");
                println("2. Gerenciar Estruturas");
                println("3. Gerenciar Recursos");
                println("4. Gerenciar Naves");
                println("5. Gerenciar Missões");
                println("0. Sair");
                int opcao = Integer.parseInt(readln("Escolha uma opção: "));

                switch (opcao){
                    case 1: //Habitantes
                        println("--- Gerenciar Habitantes ---");
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
                                    Habitantes h = habitantes.get(indiceTrab);
                                    String recursoGerado = h.trabalhar();

                                    if (recursoGerado != null) {
                                        if (recursoGerado.equals("ALIMENTO")) buscarRecurso(recursos, "Alimento").adicionarQtd(10);
                                        else if (recursoGerado.equals("ENERGIA")) buscarRecurso(recursos, "Energia").adicionarQtd(10);
                                        else if (recursoGerado.equals("MINERIO")) buscarRecurso(recursos, "Minério").adicionarQtd(10);
                                        else if (recursoGerado.equals("AGUA")) buscarRecurso(recursos, "Água").adicionarQtd(10);
                                    }
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
                                int tipoHab = Integer.parseInt(readln("Tipo: 1. Agricultor | 2. Cientista | 3. Engenheiro | 4. Médico: "));

                                switch (tipoHab) {
                                    case 1 -> habitantes.add(new Agricultor(nomeHab, idade, 100, 100, 0));
                                    case 2 -> habitantes.add(new Cientista(nomeHab, idade, 100, 100, 0, "Geral", 1));
                                    case 3 -> habitantes.add(new Engenheiro(nomeHab, idade, 100, 100, 0, "Civil", 1));
                                    case 4 -> habitantes.add(new Medico(nomeHab, idade, 100, 100, 0, "Geral", 0));
                                    default -> println("Tipo inválido!");
                                }
                                println("Habitante criado com sucesso!");
                                break;
                        }
                        break;

                    case 2: //Estruturas
                        println("--- Gerenciar Estruturas ---");
                        println("1. Listar Estruturas");
                        println("2. Produzir/Executar função");
                        println("3. Melhorar Estrutura");
                        println("4. Reparar Estrutura");
                        println("5. Construir Nova Estrutura (Custo: 50 Alimento, 50 Energia, 10 Minério)");
                        int opcaoEst = Integer.parseInt(readln("Escolha: "));
                        switch (opcaoEst){
                            case 1:
                                println("--- Lista de Estruturas ---");
                                for(int i = 0; i < estruturas.size(); i++){
                                    Estruturas e = estruturas.get(i);
                                    println(i + ". " + e.getNome() + " (" + e.getClass().getSimpleName() +
                                            ") - Nível: " + e.getNivel() + " | Vida: " + e.getVida());
                                }
                                break;
                            case 2:
                                if (estruturas.isEmpty()) break;
                                int indiceProd = Integer.parseInt(readln("Escolha o índice da estrutura: "));
                                if (indiceProd >= 0 && indiceProd < estruturas.size()){
                                    estruturas.get(indiceProd).produzir();
                                } else {
                                    println("Índice inválido!");
                                }
                                break;
                            case 3:
                                if (estruturas.isEmpty()) break;
                                int idiceMel = Integer.parseInt(readln("Escolha o índice para melhorar: "));
                                if (idiceMel >= 0 && idiceMel < estruturas.size()) {
                                    estruturas.get(idiceMel).melhorar();
                                } else {
                                    println("Índice inválido!");
                                }
                                break;

                            case 4:
                                if (estruturas.isEmpty()) break;
                                int idiceRep = Integer.parseInt(readln("Escolha o índice para reparar: "));
                                if (idiceRep >= 0 && idiceRep < estruturas.size()) {
                                    estruturas.get(idiceRep).reparar();
                                } else {
                                    println("Índice inválido!");
                                }
                                break;

                            case 5:
                                println("Para construir, são necessários: 50 Alimentos, 50 Energias e 10 Minérios.");
                                if (!validarEConsumirConstrucao(recursos, 50, 50, 10)) {
                                    break;
                                }

                                String nomeEst = readln("Nome da nova Estrutura: ");
                                println("1. Fazenda");
                                println("2. Habitação");
                                println("3. Hospital");
                                println("4. Laboratório");
                                println("5. Usina de Energia");
                                int tipoEst = Integer.parseInt(readln("Escolha: "));

                                switch (tipoEst){
                                    case 1:
                                        boolean jaExisteFazenda = estruturas.stream().anyMatch(e -> e instanceof Fazenda);
                                        if (jaExisteFazenda) {
                                            println("Erro: Já existe uma Fazenda construída!");
                                        } else {
                                            String qualCultivo = readln("O que vai cultivar (ex: Milho, Soja, Batata): ");
                                            estruturas.add(new Fazenda(nomeEst, 1, 100, 50, qualCultivo, 1.5));
                                            println("Fazenda construída com sucesso!");
                                        }
                                        break;
                                    case 2:
                                        boolean jaExisteHabitacao = estruturas.stream().anyMatch(e -> e instanceof Habitacao);
                                        if (jaExisteHabitacao) {
                                            println("Erro: Já existe uma Habitação construída!");
                                        } else {
                                            estruturas.add(new Habitacao(nomeEst, 1, 100, 2));
                                            println("Habitação construída com sucesso!");
                                        }
                                        break;
                                    case 3:
                                        boolean jaExisteHospital = estruturas.stream().anyMatch(e -> e instanceof Hospital);
                                        if (jaExisteHospital) {
                                            println("Erro: Já existe um Hospital construído!");
                                        } else {
                                            estruturas.add(new Hospital(nomeEst, 1, 100, 10));
                                            println("Hospital construído com sucesso!");
                                        }
                                        break;
                                    case 4:
                                        boolean jaExisteLaboratorio = estruturas.stream().anyMatch(e -> e instanceof Laboratorio);
                                        if (jaExisteLaboratorio) {
                                            println("Erro: Já existe um Laboratório construído!");
                                        } else {
                                            estruturas.add(new Laboratorio(nomeEst, 1, 100, 2));
                                            println("Laboratório construído com sucesso!");
                                        }
                                        break;
                                    case 5:
                                        boolean jaExisteUsina = estruturas.stream().anyMatch(e -> e instanceof UsinaEnergia);
                                        if (jaExisteUsina) {
                                            println("Erro: Já existe uma Usina de Energia construída!");
                                        } else {
                                            estruturas.add(new UsinaEnergia(nomeEst, 1, 100, 20));
                                            println("Usina de Energia construída com sucesso!");
                                        }
                                        break;
                                }
                                break;
                        }
                        break;

                    case 3: //Recursos
                        println("--- Gerenciar Recursos---");
                        println("1. Ver Estado dos Recursos");
                        println("2. Adicionar Recurso");
                        println("3. Consumir Recurso");
                        int opRec = Integer.parseInt(readln("Escolha: "));

                        switch (opRec) {
                            case 1:
                                println("--- Recursos Atuais ---");
                                for (Recursos r : recursos) {
                                    r.mostrarQuantidade();
                                }
                                break;

                            case 2:
                                println("Escolha o recurso a adicionar:");
                                for (int i = 0; i < recursos.size(); i++) {
                                    println(i + ". " + recursos.get(i).getNome());
                                }
                                int indiceAdd = Integer.parseInt(readln("Índice: "));
                                if (indiceAdd >= 0 && indiceAdd < recursos.size()) {
                                    recursos.get(indiceAdd).adicionarQtd(10);
                                }
                                break;

                            case 3:
                                println("Escolha o recurso a consumir:");
                                for (int i = 0; i < recursos.size(); i++) {
                                    println(i + ". " + recursos.get(i).getNome());
                                }
                                int indiceCon = Integer.parseInt(readln("Índice: "));
                                if (indiceCon >= 0 && indiceCon < recursos.size()) {
                                    recursos.get(indiceCon).consumirQtd(10);
                                }
                                break;
                        }
                        break;

                    case 4: //Naves
                        println("--- Gerenciar Naves ---");
                        println("1. Status das Naves");
                        println("2. Realizar Viagem");
                        println("3. Abastecer Nave");
                        int opNave = Integer.parseInt(readln("Escolha: "));

                        switch (opNave) {
                            case 1:
                                println("--- Status da Frota ---");
                                for (int i = 0; i < naves.size(); i++) {
                                    println("[" + i + "]");
                                    naves.get(i).mostrarStatus();
                                    println("--------------------");
                                }
                                break;

                            case 2:
                                if (naves.isEmpty()) break;
                                int indiceNav = Integer.parseInt(readln("Escolha o índice da nave: "));
                                if (indiceNav >= 0 && indiceNav < naves.size()) {
                                    naves.get(indiceNav).viajar();
                                }
                                break;

                            case 3:
                                if (naves.isEmpty()) break;
                                int indiceAbas = Integer.parseInt(readln("Escolha o índice da nave a reabastecer: "));
                                if (indiceAbas >= 0 && indiceAbas < naves.size()) {
                                    naves.get(indiceAbas).setCombustivel(Combustivel.CHEIO);
                                    println(naves.get(indiceAbas).getNome() + " reabastecida para CHEIO!");
                                }
                                break;
                        }
                        break;

                    case 5: //Missoes
                        println("--- Gerenciar Missões ---");
                        println("1. Listar Missões");
                        println("2. Iniciar Missão");
                        println("3. Executar Passos da Missão");
                        println("4. Finalizar Missão");
                        println("5. Adicionar Tripulante a uma Missão");
                        int opcaoMis = Integer.parseInt(readln("Escolha: "));

                        switch (opcaoMis) {
                            case 1:
                                println("--- Missões Cadastradas ---");
                                for (int i = 0; i < missoes.size(); i++) {
                                    Missoes m = missoes.get(i);
                                    println(i + ". " + m.getNome() + " | Status: " + m.getStatus() +
                                            " | Nave: " + m.getNave().getNome() + " | Tripulantes: " + m.getTripulacao().size());
                                }
                                break;

                            case 2:
                                if (missoes.isEmpty()) break;
                                int indiceIni = Integer.parseInt(readln("Escolha o índice da missão: "));
                                if (indiceIni >= 0 && indiceIni < missoes.size()) {
                                    missoes.get(indiceIni).iniciar();
                                }
                                break;

                            case 3:
                                if (missoes.isEmpty()) break;
                                int indiceExe = Integer.parseInt(readln("Escolha o índice da missão: "));
                                if (indiceExe >= 0 && indiceExe < missoes.size()) {
                                    missoes.get(indiceExe).executar();
                                }
                                break;

                            case 4:
                                if (missoes.isEmpty()) break;
                                int indiceFin = Integer.parseInt(readln("Escolha o índice da missão: "));
                                if (indiceFin >= 0 && indiceFin < missoes.size()) {
                                    missoes.get(indiceFin).finalizar();
                                }
                                break;

                            case 5:
                                if (missoes.isEmpty() || habitantes.isEmpty()) {
                                    println("É necessário ter missões e habitantes cadastrados!");
                                    break;
                                }
                                int indiceMi = Integer.parseInt(readln("Escolha o índice da missão: "));
                                int indiceHa = Integer.parseInt(readln("Escolha o índice do habitante: "));

                                if (indiceMi >= 0 && indiceMi < missoes.size() && indiceHa >= 0 && indiceHa < habitantes.size()) {
                                    missoes.get(indiceMi).adicionarTripulante(habitantes.get(indiceHa));
                                    println(habitantes.get(indiceHa).getNome() + " adicionado(a) à missão " + missoes.get(indiceMi).getNome() + "!");
                                } else {
                                    println("Índices inválidos!");
                                }
                                break;
                        }
                        break;

                    case 0:
                        executando = false;
                        println("Encerrando o simulador...");
                        break;

                    default:
                        println("Opção inválida! Tente novamente.");
                }
            }
        }