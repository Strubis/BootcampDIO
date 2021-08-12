package com.desenvolvimento.matematica;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problema:
 *      Leia um caractere maiúsculo, que indica uma operação que deve ser 
 *      realizada e uma matriz M[12][12]. Em seguida, calcule e mostre a soma 
 *      ou a média considerando somente aqueles elementos que estão na área 
 *      inferior da matriz:
 *          M[11][1];
 *          M[11][2], M[10][2];
 *          M[11][3], M[10][3], M[9][3];
 *          M[11][4], M[10][4], M[9][4], M[8][4];
 *          M[11][5], M[10][5], M[9][5], M[8][5], M[7][5];
 *          M[11][6], M[10][6], M[9][6], M[8][6], M[7][6];
 *          M[11][7], M[10][7], M[9][7], M[8][7];
 *          M[11][8], M[10][8], M[9][8];
 *          M[11][9], M[10][9];
 *          M[11][10].
 * 
 * Entrada:
 *      A primeira linha de entrada contem um único caractere Maiúsculo 
 *      option ('S' ou 'M'), indicando a operação (Soma ou Média) que deverá ser 
 *      realizada com os elementos da matriz. Seguem os 144 valores de ponto 
 *      flutuante que compõem a matriz.
 * Saída:
 *      Imprima o resultado solicitado (a soma ou média), com 1 casa 
 *      após o ponto decimal.
 *
 * @author Emerson
 */
public class BottomArea {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        char option = scanner.next().toUpperCase().charAt(0);
        double[][] M = new double[12][12];
        
        // Add the values
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                M[i][j] = scanner.nextDouble();
            }
        }
        
        // Add bottom area
        for (int i = 11; i > 6; i--) {
            for (int j = (12 - i); j < i; j++) {
                result += M[i][j];
            }
        }

        // If the average option was selected
        if ( option == 'M' ) {
            result /= 30;
        }
        
        System.out.println( String.format( "%.1f", result ) );
    }
}
