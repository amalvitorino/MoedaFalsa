/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Amal
 */
public class Operacoes {

    //Inserindo pesos no array e sorteando um indice para atribuir um peso diferente
    public static double[] insertValue(double[] array, double n) {
        for (int i = 0; i < array.length; i++) {
            array[i] = n;
        }
        DecimalFormat fmt = new DecimalFormat("0.0");
        Random aleatorio = new Random();
        if (n % 2 == 0) {
            if (n <= 4) {
                array[aleatorio.nextInt(12)] = Double.parseDouble(fmt.format(n + aleatorio.nextInt(3) + 1));
            } else {
                array[aleatorio.nextInt(12)] = Double.parseDouble(fmt.format(n - aleatorio.nextInt(3) - 1));
            }
        } else {
            if (n <= 3) {
                array[aleatorio.nextInt(12)] = Double.parseDouble(fmt.format(n + (aleatorio.nextInt(2) + 1)));
            } else {
                array[aleatorio.nextInt(12)] = Double.parseDouble(fmt.format(n - (aleatorio.nextInt(2) + 1)));
            }
        }
        return array;
    }

    //Verificando equilíbrio entre dois arrays
    public static boolean equilibrio(double[] array1, double[] array2) {
        return Arrays.stream(array1).sum() == Arrays.stream(array2).sum();
    }

    //Verificando equilíbrio entre dois pesos
    public static boolean equilibrio(double peso1, double peso2) {
        return peso1 == peso2;
    }

    public static double[] insertValues(double[] array, int inicio, int fim) {
        double[] novoArray = new double[4];
        for (int i = inicio, j = 0; i <= fim; i++, j++) {
            novoArray[j] = array[i];
        }
        return novoArray;
    }

}
