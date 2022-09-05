package principal;

public class Cliente {

    int codigo;
    String nome;
    String cpf;
    boolean verificadorCodigo = true;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;

        if (this.codigo == 10) {
            this.nome = "Felipe";
            this.cpf = "111.111.111-49";
        } else if (this.codigo == 20) {
            this.nome = "Maria";
            this.cpf = "109.876.543-21";
        } else if (this.codigo == 30) {
            this.nome = "Rodrigo";
            this.cpf = "123.456.789-10";
        } else {
            this.verificadorCodigo = true;
            System.out.println("Código de cliente inválido!");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "\nCliente: " + this.getNome() + "\n" +
                "CPF: " + this.getCpf() + "\n";
    }
}

