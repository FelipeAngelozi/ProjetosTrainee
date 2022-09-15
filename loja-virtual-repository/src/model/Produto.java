package padrao;

public class Produto {
    private Integer id;
    private String nome;
    private String descricao;


    @Override
    public String toString() {
        return "Produto " + this.id +
                ":\nNome: " + this.nome +
                "\nDescricao: " + this.descricao + "\n";
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
