package br.edu.ufersa.cc.sd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        exemplo1();
    }

    public static void exemplo1() {
        final var t0 = new Thread(() -> contar(0, 10));
        final var t1 = new Thread(() -> contar(10, 20));
        final var t2 = new Thread(() -> contar(20, 30));
        final var t3 = new Thread(() -> contar(30, 40));
        final var t4 = new Thread(() -> contar(40, 50));

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public static void contar(final Integer inicio, final Integer fim) {
        for (var i = inicio; i < fim; i++) {
            LOG.info("{}", i);
        }
    }

    public static void contarComSleep(final Integer inicio, final Integer fim, final Integer tempo) {
        for (var i = inicio; i < fim; i++) {
            LOG.info("{}", i);

            try {
                Thread.sleep(tempo);
            } catch (final InterruptedException e) {
                LOG.error("Erro ao dormir a thread", e);
            }

            LOG.info("FIM");
        }
    }

}