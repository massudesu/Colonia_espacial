package missoes;


import naves.Naves;

public class MissaoMineracao extends Missoes {

    public MissaoMineracao(String nome, String descricao,
                           int duracao, Naves nave) {
        super(nome, descricao, duracao, nave);
    }
}