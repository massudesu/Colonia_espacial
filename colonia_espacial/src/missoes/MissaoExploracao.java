package missoes;
import naves.Naves;

public class MissaoExploracao extends Missoes {

    public MissaoExploracao(String nome, String descricao,
                            int duracao, Naves nave) {
        super(nome, descricao, duracao, nave);
    }
}
