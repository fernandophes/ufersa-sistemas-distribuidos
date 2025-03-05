package br.edu.ufersa.cc.sd;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SegundaThread extends Thread {

    private static final Logger LOG = LoggerFactory.getLogger(SegundaThread.class.getSimpleName());

    @Override
    public void run() {
        LOG.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        final var numbers = Stream.iterate(0, i -> i + 1).limit(5)
                .reduce("", (s, i) -> s + i, (s, n) -> n);

        LOG.info(numbers);
    }
}
