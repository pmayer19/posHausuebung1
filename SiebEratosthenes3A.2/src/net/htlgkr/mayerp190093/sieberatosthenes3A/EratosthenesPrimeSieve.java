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

    int obergrenze;
    public ArrayList<Integer> primes = new ArrayList<Integer>();

    public EratosthenesPrimeSieve(int obergrenze) {
        this.obergrenze = obergrenze;
    }

    public static void main(String[] args) {
        EratosthenesPrimeSieve e = new EratosthenesPrimeSieve(15);
        e.findprimes();
        e.printPrimes();
    }

    @Override
    public boolean isPrime(int p) {
        boolean b = false;
        for (int i = 2; i < p; i++) {
            if (i % p != 0) {
                b = true;
            }
        }
        return b;
    }

    public void findprimes() {

        for (int i = 2; i <= obergrenze; i++) {
            primes.add(i);
        }

        for (int i = 2; i < primes.size(); i++) {
            if (isPrime(i) == true) {
                for (int j = 2; j < primes.size(); j++) {
                    if (primes.contains(i * j)) {
                        int result = i * j;
                        primes.remove(result);
                    }
                }
            }
        }
    }

    @Override
    public void printPrimes() {
        for (int i = 0; i < primes.size(); i++) {
            System.out.println(primes.get(i));
        }
    }

}
