package com.learn.vertx.udemy.vertx_starter.ventricles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VentricleAB extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) {
    System.out.println("Start " + getClass().getName());
    startPromise.complete();
  }

  @Override
  public void stop(Promise<Void> stopPromise) {
    System.out.println("Stop " + getClass().getName());
    stopPromise.complete();
  }
}
