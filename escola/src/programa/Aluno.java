package programa;

public class Aluno {

    private String nome, cpf;
    private int idade;
    private Endereco endereco;


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Aluno = " + nome + "\n" +
                "CPF = " + cpf + "\n" +
                "Idade =" + idade + "\n" +
                "Endereço: \n" + endereco.toString();
    }
}
