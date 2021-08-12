package com.desenvolvimento.matematica;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problema:
 *      Leia um caractere maiúsculo, que indica uma operação que deve ser 
 *      realizada e uma matriz M[12][12]. Em seguida, calcule e mostre a soma 
 *      ou a média considerando somente aqueles elementos que estão na área 
 *      esquerda da matriz:
 *          M[1][0];
 *          M[2][0], M[2][1];
 *          M[3][0], M[3][1], M[3][2];
 *          M[4][0], M[4][1], M[4][2], M[4][3];
 *          M[5][0], M[5][1], M[5][2], M[5][3], M[5][4];
 *          M[6][0], M[6][1], M[6][2], M[6][3], M[6][4];
 *          M[7][0], M[7][1], M[7][2], M[7][3];
 *          M[8][0], M[8][1], M[8][2];
 *          M[9][0], M[9][1];
 *          M[10][0].
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
public class LeftArea {

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
        
        // Add left area
        for (int i = 0; i < 5; i++) {
            for (int j = (i + 1); j < (11 - i); j++) {
                result += M[j][i];
            }
        }
        
        // If the average option was selected
        if ( option == 'M' ) {
            result /= 30;
        }
        System.out.println( String.format( "%.1f", result ) );
    }
}
