package com.desenvolvimento.intermediario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Problema: 
 *      O professor Girafales organizou a confecção de um uniforme para as
 *      turmas da escola para comemorar o final do ano. Após algumas conversas, ficou
 *      decidido com os alunos que eles poderiam escolher a cor do uniforme entre
 *      branco ou vermelho. Assim sendo, Girafales precisa de sua ajuda para
 *      organizar as listas de quem quer o uniforme em cada uma das turmas,
 *      relacionando estas camisetas pela cor, tamanho (P, M ou G) e por último pelo
 *      nome.
 *
 * Entrada: 
 *      Cada caso de teste inicia com um valor N, (1 ≤ N ≤ 60) inteiro e
 *      positivo, que indica a quantidade de uniformes a serem feitas para aquela
 *      turma. As próximas N*2 linhas contém informações de cada um dos uniformes
 *      (serão duas linhas de informação para cada uniforme). A primeira linha irá
 *      conter o nome do estudante e a segunda linha irá conter a cor do uniforme
 *      ("branco" ou "vermelho") seguido por um espaço e pelo tamanho do uniforme "P"
 *      "M" ou "G". A entrada termina quando o valor de N for igual a zero (0) e esta
 *      valor não deverá ser processado. 
 * Saída: 
 *      Para cada caso de entrada deverão ser impressas as informações ordenadas 
 *      pela cor em ordem ascendente, seguido pelos tamanhos em ordem descendente 
 *      e por último por ordem ascendente de nome.
 *
 * @author Emerson
 */
public class Uniform {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String owner, l, color, size;
        String[] details;
        Tshirt[] tshirts;
        Tshirt tshirt;
        int N;
        //boolean firstCase = true;

        while (!(l = read()).equals("0")) {
            N = toInt(l);
            tshirts = new Tshirt[N];

            for (int i = 0; i < N; i++) {
                owner = read();
                details = read().split(" ");
                color = details[0];
                size = details[1];

                tshirt = new Tshirt(size, color, owner);
                tshirts[i] = tshirt;
            }

            Arrays.sort(tshirts, new Comparator<Tshirt>() {
                @Override
                public int compare(Tshirt t1, Tshirt t2) {
                    String cmp1 = t1.getColor();
                    String cmp2 = t2.getColor();
                    int diff = cmp1.compareTo( cmp2 );

                    if ( diff != 0 ) {
                        return diff;
                    } else {
                        cmp1 = t1.getSize();
                        cmp2 = t2.getSize();
                        diff = cmp1.compareTo( cmp2 );

                        if ( diff == 0 ) {
                            cmp1 = t1.getOwner();
                            cmp2 = t2.getOwner();
                            diff = cmp1.compareTo( cmp2 );

                            return diff;
                        } else if (diff < 0) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }

                }
            });

            for (Tshirt tshirt1 : tshirts) {
                System.out.println(tshirt1);
            }
        }
    }

    private static String read() throws IOException {
        return in.readLine();
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static class Tshirt {

        private String size;
        private String color;
        private String owner;

        public Tshirt(String size, String color, String owner) {
            this.size = size;
            this.color = color;
            this.owner = owner;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        @Override
        public String toString() {
            return this.getColor() + " " + this.getSize() + " " + this.getOwner();
        }
    }
}
