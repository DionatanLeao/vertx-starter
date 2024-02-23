package com.learn.vertx.udemy.vertx_starter.ventricles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VentricleA extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) {
    System.out.println("Start " + getClass().getName());
    vertx.deployVerticle(new VentricleAA(), whenDeployed -> {
      System.out.println("Start " + VentricleAA.class.getName());
      vertx.undeploy(whenDeployed.result());
    });
    vertx.deployVerticle(new VentricleAB(), whenDeployed -> {
      System.out.println("Start " + VentricleAB.class.getName());
      // Do not undeploy
    });
    startPromise.complete();
  }
}
