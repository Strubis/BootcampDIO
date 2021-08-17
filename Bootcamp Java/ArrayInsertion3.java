package com.desenvolvimento.intermediario;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Problema: Leia um valor X. Coloque este valor na primeira posição de um vetor
 * N[100]. Em cada posição subsequente de N (1 até 99), coloque a metade do
 * valor armazenado na posição anterior, conforme o exemplo abaixo. Imprima o
 * vetor N.
 *
 * Entrada: A entrada contem um valor de dupla precisão com 4 casas decimais.
 * Saída: Para cada posição do vetor N, escreva "N[i] = Y", onde i é a posição
 * do vetor e Y é o valor armazenado naquela posição. Cada valor do vetor deve
 * ser apresentado com 4 casas decimais.
 *
 * Obs: o tratamento feito usando BigDecimal ao invés de apenas Double, foi para
 * o caso de os números serem muito grandes.
 * 
 * @author Emerson
 */
public class ArrayInsertion3 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double X = scanner.nextDouble();
        BigDecimal[] N = new BigDecimal[100];

        // Insertion
        N[0] = new BigDecimal( X );
        for (int i = 1; i < N.length; i++) {
            N[i] = N[i - 1].divide( new BigDecimal(2) );
        }
        scanner.close();
        
        // Printing
        DecimalFormat decimalFormat = new DecimalFormat( "0.0000" );
        for (int i = 0; i < N.length; i++) {
            System.out.println( "N[" + i + "] = " + decimalFormat.format( N[i] ) );
        }
    }
}
