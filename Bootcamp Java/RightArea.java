package com.desenvolvimento.matematica;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problema:
 *      Leia um caractere maiúsculo, que indica uma operação que deve ser 
 *      realizada e uma matriz M[12][12]. Em seguida, calcule e mostre a soma 
 *      ou a média considerando somente aqueles elementos que estão na área 
 *      direita da matriz: 
 *          M[5][7], M[6][7];
 *          M[4][8], M[5][8], M[6][8], M[7][8];
 *          M[3][9], M[4][9], M[5][9], M[6][9], M[7][9], M[8][9];
 *          M[2][10], M[3][10], M[4][10], M[5][10], M[6][10], M[7][10], M[8][10], M[9][10];
 *          M[1][11], M[2][11], M[3][11], M[4][11], M[5][11], M[6][11], M[7][11], M[8][11], M[9][11], M[10][11].
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
public class RightArea {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        char option = scanner.next().toUpperCase().charAt(0);
        double[][] m = new double[12][12];
        
        // Add the values
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                m[i][j] = scanner.nextDouble();
            }
        }
        
        // Add right area
        for (int i = 11; i > 6; i--) {
            for (int j = (12 - i); j < i; j++) {
                result += m[j][i];
            }
        }
        
        // If the option average was selected
        if ( option == 'M' ) {
            result /= 30;
        }
        
        System.out.println( String.format( "%.1f", result ) );
    }
}