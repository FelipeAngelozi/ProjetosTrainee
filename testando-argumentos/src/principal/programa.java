package principal;

import java.util.Objects;

public class programa {
    public static void main(String[] args) {


            if (Objects.equals(args[0], "p")) {
                System.out.println("Parametros");
            } else {
                System.out.println("Abriu programa normal");
            }

    }
}