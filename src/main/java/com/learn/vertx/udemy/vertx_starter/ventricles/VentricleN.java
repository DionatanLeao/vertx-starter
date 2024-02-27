package com.learn.vertx.udemy.vertx_starter.ventricles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VentricleN extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) {
    System.out.println("Start " + getClass().getName() + " on thread " + Thread.currentThread().getName());
    startPromise.complete();
  }
}
