import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    private List<Jogador> jogadores;

    public BancoDeDados() {
        jogadores = new ArrayList<>();
    }

    public void inserirJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }
}
