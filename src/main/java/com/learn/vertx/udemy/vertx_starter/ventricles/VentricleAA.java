package com.learn.vertx.udemy.vertx_starter.ventricles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VentricleAA extends AbstractVerticle {
  private static final Logger LOG = LoggerFactory.getLogger(VentricleAA.class);

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
