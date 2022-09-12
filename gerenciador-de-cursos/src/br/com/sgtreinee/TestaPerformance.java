package br.com.sgtreinee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {
    public static void main(String[] args) {

        Collection<Integer> numeros = new ArrayList<>();

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
            numeros.add(i);
        }

        numeros.forEach(numero -> numeros.contains(numero));

        long fim = System.currentTimeMillis();

        long tempoDeExecucao = fim - inicio;

        System.out.println("tempo gasto: " + tempoDeExecucao);

        // resultado com arraylist : 1260
        // resultado com hashsey : 65
    }
}
