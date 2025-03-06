package br.edu.ufersa.cc.sd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class.getSimpleName());

    static int contagem = 0;

    public static void main(String[] args) {
        exemplo2();
    }

    public static void exemplo1() {
        final var t0 = new Thread(Main::incrementar);
        final var t1 = new Thread(Main::incrementar);
        final var t2 = new Thread(Main::incrementar);
        final var t3 = new Thread(Main::incrementar);
        final var t4 = new Thread(Main::incrementar);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public static void exemplo2() {
        final var threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(Main::incrementarSync);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

    private static void incrementar() {
        LOG.info("{}", ++contagem);
    }

    private static synchronized void incrementarSync() {
        LOG.info("{}", ++contagem);
    }

}