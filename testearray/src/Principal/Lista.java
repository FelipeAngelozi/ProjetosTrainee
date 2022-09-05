package Principal;


public class Lista {

    static int i;

    static Pessoa[]  lista = new Pessoa[5];

    public static void preencheArray() {

        for( i = 0; i < lista.length; i++) {
            lista[i] = new Pessoa();
            lista[i].setIdade(i); ;
        }
    }

    public static void imprimirArray() {

        for (i = 0; i < lista.length;i++) {
            System.out.println(lista[i].getIdade());
        }
    }
}
