package br.edu.ufersa.cc.sd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrimeiraThread extends Thread {

    private static final Logger LOG = LoggerFactory.getLogger(PrimeiraThread.class.getSimpleName());

    @Override
    public void run() {
        LOG.info(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}
