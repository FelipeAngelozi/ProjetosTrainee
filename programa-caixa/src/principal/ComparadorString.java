package principal;

import java.util.Comparator;

public class ComparadorString implements Comparator<Produto> {

    @Override
    public int compare(Produto produto1, Produto produto2) {
        String nome1 = produto1.getNome();
        String nome2 = produto2.getNome();
        return nome1.compareTo(nome2);
    }
}
