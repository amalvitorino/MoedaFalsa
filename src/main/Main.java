/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import control.Operacoes;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Amal
 */
public class Main {

    public static void main(String[] args) {

        double[] array = new double[12];

        //inserindo peso em todas as moedas
        double n = 2;
        array = Operacoes.insertValue(array, n);

        //dividindo o array em 3 partes iguais
        double[] grupoA = Operacoes.insertValues(array, 0, 3);
        double[] grupoB =  Operacoes.insertValues(array, 4, 7);
        double[] grupoC =  Operacoes.insertValues(array, 8, 11);

        //imprimindo todas as moedas
        System.out.println(Arrays.toString(array));
        System.out.println("");
        System.out.println("Vamos dividir o array em  3 grupos");
        System.out.println("Grupo A: " + Arrays.toString(grupoA));
        System.out.println("Grupo B: " + Arrays.toString(grupoB));
        System.out.println("Grupo C: " + Arrays.toString(grupoC));
        System.out.println("");

        //verificando o equilibrio entre a parte A e B
        System.out.println("[1]. Vamos pesar o grupo_A com o grupo_B");
        if (Operacoes.equilibrio(grupoA, grupoB)) { //quando a 1 pesagem começa com equilíbrio (E)
            System.out.println("Há Equilíbrio, Então a moda falsa só pode estar no grupo_C");
            System.out.println("");
            System.out.println("[2]. Vamos pesar duas do grupo_A/grupo_B e duas do grupo_C");
            if (grupoA[0] + grupoA[1] == grupoC[0] + grupoC[1]) { //quando a 2 pesagem começa com equilíbrio (EE)
                System.out.println("Há equilibrio entao a moeda falsa está entre as outras duas moedas do grupo_C");
                System.out.println("");
                System.out.println("[3]. vamos substituir uma das moedas do grupo_C por outra do Grupo_C");
                if (grupoA[0] + grupoA[2] == grupoC[1] + grupoC[2]) { //quando a 3 pesagem começa com equilíbrio (EEE)
                    System.out.println("Há equilibrio entao a moeda falsa está na posicao [12] e pesa: " + grupoC[3]);
                } else { //quando a 3 pesagem começa com desequilíbrio (EED)
                    System.out.println("Há desequilíbrio entao a moeda falsa está na posicao [11] e pesa: " + grupoC[2]);
                }
            } else { //quando a 2 pesagem começa com desequilíbrio (ED)
                System.out.println("Há desequilíbrio entao a moeda falsa está entre essas duas moedas do grupo_C");
                System.out.println("");
                System.out.println("[3]. Então nesse grupo de moedas vamos pesar uma moeda do grupo_A/grupo_B com uma do grupo_C");
                if (grupoA[0] == grupoC[0]) { //quando a 3 pesagem começa com equilíbrio (EDE)
                    System.out.println("Há equilibrio entao a moeda falsa está na posicao [10] e pesa: " + grupoC[1]);
                } else { //quando a 3 pesagem começa com desequilíbrio (EDD)
                    System.out.println("Há desequilíbrio entao a moeda falsa está na posicao [9] e pesa: " + grupoC[0]);
                }
            }
        } else if (Arrays.stream(grupoA).sum() > Arrays.stream(grupoB).sum()) {//quando a 1 pesagem começa com equilíbrio (D)
            System.out.println("Há desequilíbrio, O grupo_A pesa mais que o grupo_B");
            System.out.println("Todas moedas do grupo_C são verdadeiras, Então a moeda falsa está no grupo_A ou no grupo_B");
            System.out.println("");
            System.out.println("[2]. Vamos pesar 3 moedas do grupo_A e uma do grupo_B com 3 moedas do grupo_C e uma do grupo_A");
            if (grupoA[0] +grupoA[1] +grupoA[2] + grupoB[0] == grupoC[0] +grupoC[1] +grupoC[2] + grupoA[3]) {//quando a 2 pesagem começa com equilibrio (DE)
                System.out.println("Há equilíbrio então a moeda falsa está entre as 3 restantes do grupo_B e é a mais leve");
                System.out.println("");
                System.out.println("[3]. Vamos pesar duas dessas 3 moedas do grupo_B ");
                if (grupoB[1] == grupoB[2]) {//quando a 3 pesagem começa com equilíbrio (DEE)
                    System.out.println("Há equilibrio entao a moeda falsa está na posicao 8 e pesa: " + grupoB[3]);
                } else {//quando a 3 pesagem começa com desequilíbrio (DED)
                    if (grupoB[1] > grupoB[2]) {//quando a 3 pesagem começa com equilíbrio (DED)
                        System.out.println("Há desequilíbrio então a moeda falsa está na posicao [7] e pesa: " + grupoB[2]);
                    } else {//quando a 3 pesagem começa com equilíbrio (DED)
                        System.out.println("Há desequilíbrio então a moeda falsa está na posicao 6 e pesa: " + grupoB[1]);
                    }
                }
            } else if(grupoA[0] +grupoA[1] +grupoA[2] + grupoB[0] > grupoC[0] +grupoC[1] +grupoC[2] + grupoA[3]){//quando a 2 pesagem começa com desequilíbrio (DD)
                System.out.println("Há desequilíbrio então a moeda falsa está no grupo_A e é mais pesada");
                System.out.println("");
                System.out.println("[3]. Vamos pesar duas dessas 3 moedas do grupo_A ");
                if (grupoA[0] == grupoA[1]) {//quando a 3 pesagem começa com equilíbrio (DDE)
                    System.out.println("Há equilibrio entao a moeda falsa está na posicao 3 e pesa: " + grupoA[2]);
                } else {//quando a 3 pesagem começa com desequilíbrio (DDD)
                    if (grupoA[0] > grupoA[1]) {
                        System.out.println("Há desequilíbrio então a moeda falsa está na posicao [1] e pesa: " + grupoA[0]);
                    } else {
                        System.out.println("Há desequilíbrio então a moeda falsa está na posicao [2] e pesa: " + grupoA[1]);
                    }
                }
                
            }else {//quando a 2 pesagem começa com desequilíbrio (DD)
                System.out.println("Há desequilíbrio então a moeda falsa é A e mais pesada ou B a mais leve");
                System.out.println("");
                System.out.println("[3]. Vamos pesar uma do grupo_C com a moeda do grupo_B ");
                if (grupoC[1] > grupoB[0]) {//quando a 3 pesagem começa com desequilíbrio (DDD)
                    System.out.println("Há desequilíbrio então a moeda falsa está na posicao [5] e pesa: " + grupoB[0]);
                }else{//quando a 2 pesagem começa com desequilíbrio (DDD)
                    System.out.println("Há equilíbrio então a moeda falsa está na posicao [4] e pesa: " + grupoA[3]);
                }
            }
        } else {//quando a 1 pesagem começa com equilíbrio (D)
             System.out.println("Há desequilíbrio, O grupo_B pesa mais que o grupo_A");
            System.out.println("Todas moedas do grupo_C são verdadeiras, Então a moeda falsa está no grupo_A ou no grupo_B");
            System.out.println("");
            System.out.println("[2]. Vamos pesar 3 moedas do grupo_B e uma do grupo_A com 3 moedas do grupo_C e uma do grupo_B");
            if (grupoB[0] +grupoB[1] +grupoB[2] + grupoA[0] == grupoC[0] +grupoC[1] +grupoC[2] + grupoB[3]) {//quando a 2 pesagem começa com equilibrio (DE)
                System.out.println("Há equilíbrio então a moeda falsa está entre as 3 restantes do grupo_A e é a mais leve");
                System.out.println("");
                System.out.println("[3]. Vamos pesar duas dessas 3 moedas do grupo_A ");
                if (grupoA[1] == grupoA[2]) {//quando a 3 pesagem começa com equilíbrio (DEE)
                    System.out.println("Há equilibrio entao a moeda falsa está na posicao [4] e pesa: " + grupoA[3]);
                } else {//quando a 3 pesagem começa com desequilíbrio (DED)
                    if (grupoA[1] > grupoA[2]) {//quando a 3 pesagem começa com equilíbrio (DED)
                        System.out.println("Há desequilíbrio então a moeda falsa está na posicao [3] e pesa: " + grupoA[2]);
                    } else {//quando a 3 pesagem começa com equilíbrio (DED)
                        System.out.println("Há desequilíbrio então a moeda falsa está na posicao [2] e pesa: " + grupoA[1]);
                    }
                }
            } else if(grupoB[0] +grupoB[1] +grupoB[2] + grupoA[0] > grupoC[0] +grupoC[1] +grupoC[2] + grupoB[3]){//quando a 2 pesagem começa com desequilíbrio (DD)
                System.out.println("Há desequilíbrio então a moeda falsa está no grupo_B e é mais pesada");
                System.out.println("");
                System.out.println("[3]. Vamos pesar duas dessas 3 moedas do grupo_B ");
                if (grupoB[0] == grupoB[1]) {//quando a 3 pesagem começa com equilíbrio (DDE)
                    System.out.println("Há equilibrio entao a moeda falsa está na posicao [7] e pesa: " + grupoB[2]);
                } else {//quando a 3 pesagem começa com desequilíbrio (DDD)
                    if (grupoB[0] > grupoB[1]) {
                        System.out.println("Há desequilíbrio então a moeda falsa está na posicao [5] e pesa: " + grupoB[0]);
                    } else {
                        System.out.println("Há desequilíbrio então a moeda falsa está na posicao [6] e pesa: " + grupoB[1]);
                    }
                }
                
            }else {//quando a 2 pesagem começa com desequilíbrio (DD)
                System.out.println("Há desequilíbrio então a moeda falsa é B e mais pesada ou A a mais leve");
                System.out.println("");
                System.out.println("[3]. Vamos pesar uma do grupo_C com a moeda do grupo_A ");
                if (grupoC[1] > grupoA[0]) {//quando a 3 pesagem começa com desequilíbrio (DDD)
                    System.out.println("Há desequilíbrio então a moeda falsa está na posicao [4] e pesa: " + grupoA[0]);
                }else{//quando a 2 pesagem começa com desequilíbrio (DDD)
                    System.out.println("Há equilíbrio então a moeda falsa está na posicao [8] e pesa: " + grupoB[3]);
                }
            }
        }

    }

}
