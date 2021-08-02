package com.desenvolvimento.estruturadedados;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problema: 
 *      Theon pode dizer que seu algoz é alguma dentre N pessoas. Considere 
 *      que as pessoas são numeradas de 1 a N. Se Theon responder que seu algoz é a 
 *      pessoa i, Ramsay irá atingi-lo Ti vezes. Sua tarefa é ajudar Theon a determinar 
 *      qual deve ser sua resposta de forma a minimizar o número de vezes que ele será atingido.
 * 
 * Entrada:
 *      A primeira linha contém um inteiro N (1 ≤ N ≤ 100). A segunda linha 
 *      contém N inteiros T1, T2, ..., TN (0 ≤ Ti ≤ 20).
 * Saída:
 *      Imprima uma linha contendo o número da pessoa que Theon deve dizer ser 
 *      seu algoz. Se existe mais de uma resposta possível, imprima a menor.
 *
 * @author Emerson
 */
public class RespostaTheon {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        
        int N = leitor.nextInt();
        int T, menor = 1000, posMenor = 0;
        
        for (int i = 0; i < N; i++) {
            T = leitor.nextInt();
            
            if (T < menor) {
                menor = T;
                posMenor = i + 1;
            }
            
        }
        
        System.out.println(posMenor);
    }

}
