package programa;

public class Endereco {

    private String logradouro, numero, complemento, CEP, cidade, estado;

    public Endereco(String cidade, String estado) {
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public String getCEP() {
        return this.CEP;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Logradouro = " + logradouro + "\n" +
                "Numero = " + numero + "\n" +
                "Complemento = " + complemento + "\n" +
                "CEP = " + CEP + "\n" +
                "Cidade = " + cidade + "\n" +
                "Estado = " + estado + "\n\n" ;
    }
}
