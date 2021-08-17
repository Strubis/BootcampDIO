package com.desenvolvimento.intermediario;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problema: Dadas as previsões meteorológicas, você terá o desafio de descubrir
 * quantos guarda-chuvas Thor deve comprar e guardar em casa e no escritório, de
 * modo que ele nunca se molhe e nunca precise carregar o guarda-chuva quando
 * não estiver chovendo.
 *
 * Entrada: A primeira linha da entrada contém um inteiro N, indicando a
 * quantidade de dias previstos pelo sistema meteorológico (1 <= N <= 1000). Em seguida
 *      haverá N linhas, cada uma contendo duas palavras SD e SN, indicando a
 *      previsão do tempo para a ida e para a volta do trabalho, respectivamente.
 *      Se a palavra for "sol" significa que neste horário fará sol, e se a
 *      palavra for "chuva" significa que neste horário irá chover.
 * >
 * Saída: Para cada caso de teste imprima uma linha contendo dois inteiros C e
 * E, indicando quantos guarda-chuvas Thor deve comprar e guardar em sua casa e
 * escritório.
 *
 * @author Emerson
 */
public class AvoidingRain {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();
        int buyedHome = 0;
        int leftoverHome = 0;
        int buyedWork = 0;
        int leftoverWork = 0;
        String[] line;
        String go, back;

        scanner.nextLine();

        for (int i = 0; i < days; ++i) {
            line = scanner.nextLine().split(" ");
            go = line[0];
            back = line[1];

            if ( go.equals("chuva") ) {
                if ( leftoverHome > 0 ) {
                    --leftoverHome;
                } else {
                    buyedHome++;
                }
                leftoverWork++;
            }

            if ( back.equals("chuva") ) {
                if ( leftoverWork > 0 ) {
                    --leftoverWork;
                } else {
                    buyedWork++;
                }
                leftoverHome++;
            }
        }
        System.out.println( buyedHome + " " + buyedWork );
    }
}
