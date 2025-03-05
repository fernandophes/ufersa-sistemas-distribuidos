package br.edu.ufersa.cc.sd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinhaThread implements Runnable {

    static final Logger LOG = LoggerFactory.getLogger(MinhaThread.class.getSimpleName());

    @Override
    public void run() {
        LOG.info("Oi, eu sou a {}", Thread.currentThread().getName());
    }

}
