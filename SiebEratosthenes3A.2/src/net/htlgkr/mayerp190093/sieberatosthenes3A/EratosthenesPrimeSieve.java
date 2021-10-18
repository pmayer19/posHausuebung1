/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgkr.mayerp190093.sieberatosthenes3A;

import java.util.ArrayList;

/**
 *
 * @author mayer
 */
public class EratosthenesPrimeSieve implements EratosthenesInterface {

    int obergrenze = 10;
    public boolean[] primes = new boolean[obergrenze];

    public static void main(String[] args) {
        EratosthenesPrimeSieve e = new EratosthenesPrimeSieve();
        e.arrayPrepare();

        for (int i = 2; i < e.primes.length; i++) {
            e.isPrime(i);
        }

        e.printPrimes();
        e.zweiteAufgabe();
    }

    public void arrayPrepare() {
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }
    }

    @Override
    public boolean isPrime(int p) {
        int e = 2;
        boolean b = false;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == true) {
                while (e * p < primes.length) {
                    if (primes[e * p] == true) {
                        primes[e * p] = false;
                        b = false;
                    }
                    e++;
                }
            }
        }
        return b;
    }

    @Override
    public void printPrimes() {
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == true) {
                System.out.println(i);
            }

        }
    }

    public void zweiteAufgabe() {

        int[] arr = new int[obergrenze];
        for (int i = 0; i < primes.length; i++) {
            if (primes[i] == true) {
                arr[i] = i;
            }
        }
        boolean b = true;
        for (int i = 2; i <= arr.length; i = i + 2) {
            b = true;
            for (int j = 2; j < arr.length; j++) {
                for (int k = 2; k < arr.length; k++) {
                    if (i == k + j && b == true) {
                        System.out.println(i + " = " + j + "+" + k);
                        b = false;
                    }
                }
            }
        }
    }

}
