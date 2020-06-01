package challenge;


import java.util.Objects;

public class Motorista {

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) throws IllegalArgumentException{
        //if (nome == null || nome.equals("")) throw new IllegalArgumentException("O motorista não tem nome");
        if (!validaNome(nome)) throw new NullPointerException();
        if (!verificaHabilitacao(habilitacao)) throw new NullPointerException();
        // O motorista precisa ter idade suficiente para dirigir e possuir uma habilitação.
        if (!validaIdade(idade)) throw new EstacionamentoException("O motorista não tem idade suficiente para dirigir");
        // A habilitação não deverá está suspensa, ou seja, a pontuação da carteira de motorista não deverá ser superior a vinte pontos.
        if (!validaHabilitacao(pontos)) throw new EstacionamentoException("Motorista com habilitação suspensa");
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    private boolean validaIdade(int idade){
        if (idade < 18){
           return false;
        }
        return true;
    }

    private boolean verificaHabilitacao(String habilitacao){
        if (habilitacao == null || habilitacao.equals("")){
            return  false;
        }
        return  true;
    }

    public boolean validaNome(String nome){
        if (nome ==null || nome.equals(""))  {
            return false;
        }
        return true;
    }

    private boolean validaHabilitacao(int pontos){
        if (pontos > 20) {
            return  false;
        }
        return   true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String nome) {
            if (nome == null) throw new IllegalArgumentException();
            this.nome = nome;
            return this;
        }

        public MotoristaBuilder withIdade(int idade) {
            if (idade < 0) throw new IllegalArgumentException();
            this.idade = idade;
            return this;
        }

        public MotoristaBuilder withPontos(int pontos) {
            if (pontos < 0) throw new IllegalArgumentException();
            this.pontos = pontos;
            return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {
            if (habilitacao == null) throw new IllegalArgumentException();
            this.habilitacao = habilitacao;
            return this;
        }


        public Motorista build() {
            return new Motorista(nome, idade, pontos, habilitacao);
        }
    }
}
