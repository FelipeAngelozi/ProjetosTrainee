package principal;

public class Produto {

    double valor;
    int codigo = 0;
    String nome;
    boolean verificadorProduto;

    public int getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;

        if (this.codigo == 1111) {
            this.nome = "Abacate";
            this.valor = 5.99;
        } else if (this.codigo == 2222) {
            this.nome = "Abacaxi";
            this.valor = 8.99;
        } else if (this.codigo == 3333) {
            this.nome = "Laranja";
            this.valor = 2.99;
        } else if (this.codigo == 0000){

        }
    }

    @Override
    public String toString() {
        return "Produto = " + this.nome + "  |  " +
                "Preço = " + this.valor;
    }
}
