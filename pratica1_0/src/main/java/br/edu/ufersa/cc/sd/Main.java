package br.edu.ufersa.cc.sd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    static final Logger LOG = LoggerFactory.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) {
        terceiraAbordagem();
    }

    public static void primeiraAbordagem() {
        LOG.info("Iniciando...");

        final var primeiraThread = new PrimeiraThread();
        primeiraThread.run();
        primeiraThread.start();

        final var segundaThread = new SegundaThread();
        segundaThread.run();
        segundaThread.start();

        final var runnable = new MinhaThread();
        final var threadGenerica = new Thread(runnable);
        threadGenerica.run();
        threadGenerica.start();

        final var t3 = new Thread(runnable);
        t3.start();

        final var t4 = new Thread(runnable);
        t4.start();
    }

    public static void segundaAbordagem() {
        final var r0 = new MinhaThread();
        final var t0 = new Thread(r0);
        t0.start();

        // Usando classe anônima
        final var r1 = new Runnable() {
            @Override
            public void run() {
                LOG.info("Oi, eu sou a {}", Thread.currentThread().getName());
            }
        };
        final var t1 = new Thread(r1);
        t1.start();

        // Usando lambda
        final Runnable r2 = () -> LOG.info("Oi, eu sou a {}", Thread.currentThread().getName());
        final var t2 = new Thread(r2);
        t2.start();

        final var t3 = new Thread(() -> LOG.info("Oi, eu sou a {}", Thread.currentThread().getName()));
        t3.start();
    }

    public static void terceiraAbordagem() {
        new Thread(() -> informacoes()).start();
    }

    private static void informacoes() {
        final var t = Thread.currentThread();

        LOG.info("Nome: {}", t.getName());
        // LOG.info("ID: {}", t.getId());
        LOG.info("Estado: {}", t.getState());
        LOG.info("Prioridade: {}", t.getPriority());
        LOG.info("Grupo: {}", t.getThreadGroup());
        LOG.info("Viva?: {}", t.isAlive());
        LOG.info("Interrompida?: {}", t.isInterrupted());
        LOG.info("Daemon?: {}", t.isDaemon());
    }

}
