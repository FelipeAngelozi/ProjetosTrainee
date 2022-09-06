package principal;

import java.util.Comparator;

public class Comparador implements Comparator<Produto> {

    @Override
    public int compare(Produto produto1, Produto produto2) {
        if (produto1.getValor() < produto2.getValor()) {
            return -1;
        } else if (produto1.getValor() > produto2.getValor()) {
            return 1;
        }
        return 0;
    }
}
