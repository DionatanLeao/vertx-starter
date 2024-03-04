package com.learn.vertx.udemy.vertx_starter.ventricles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VentricleN extends AbstractVerticle {
  private static final Logger LOG = LoggerFactory.getLogger(VentricleN.class);

  @Override
  public void start(Promise<Void> startPromise) {
    LOG.debug("Start {} with config {}", getClass().getName(), config().toString());
    LOG.debug("Start {} on thread {}", getClass().getName(), Thread.currentThread().getName());
    startPromise.complete();
  }
}
