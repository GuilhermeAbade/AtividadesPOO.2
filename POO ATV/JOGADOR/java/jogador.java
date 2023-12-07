public class Jogador {
  
  private String nome;
    private String funcao;
    private String nomeTime;
    private String patente;

    public Jogador(String nome, String funcao, String nomeTime, String patente) {
        this.nome = nome;
        this.funcao = funcao;
        this.nomeTime = nomeTime;
        this.patente = patente;
    }

    public String getNome() {
        return nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public String getPatente() {
        return patente;
    }
    
    public void imprimirDados() {
        System.out.println("Nome: " + nome + ", Função: " + funcao + ", Nome do Time: " + nomeTime + ", Patente: " + patente);
   

 }
}
