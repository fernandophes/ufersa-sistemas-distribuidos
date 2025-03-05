package br.edu.ufersa.cc.sd;

public class Main {
    public static void main(String[] args) {

        final var currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());

        final var primeiraThread = new PrimeiraThread();
        primeiraThread.run();
        primeiraThread.start();

        final var segundaThread = new SegundaThread();
        segundaThread.run();
        segundaThread.start();

        final var runnable = new MinhaThread();
        Thread threadGenerica = new Thread(runnable);
        threadGenerica.run();
        threadGenerica.start();
    }
}
