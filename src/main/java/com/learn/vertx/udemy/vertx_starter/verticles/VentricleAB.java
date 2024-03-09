package com.learn.vertx.udemy.vertx_starter.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VentricleAB extends AbstractVerticle {
  private static final Logger LOG = LoggerFactory.getLogger(VentricleAB.class);

  @Override
  public void start(Promise<Void> startPromise) {
    LOG.debug("Start {}", getClass().getName());
    startPromise.complete();
  }

  @Override
  public void stop(Promise<Void> stopPromise) {
    LOG.debug("Stop {}", getClass().getName());
    stopPromise.complete();
  }
}
