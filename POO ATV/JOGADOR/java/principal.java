public class Principal {
  
  public static void main(String[] args) {
        BancoDeDados bd = new BancoDeDados();


        bd.inserirJogador(new Jogador("Faker", "Mid", "SKTT1", "Desafiante"));
        bd.inserirJogador(new Jogador("Ranger", "Jungler", "Cloud9", "Mestre"));
        bd.inserirJogador(new Jogador("Ceos", "Suporte", "LOUD", "Diamante"));


        for (Jogador jogador : bd.getJogadores()) {
            jogador.imprimirDados();
        }
    }
}
