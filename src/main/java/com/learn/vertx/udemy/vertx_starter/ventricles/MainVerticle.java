package com.learn.vertx.udemy.vertx_starter.ventricles;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    final Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }

  @Override
  public void start(Promise<Void> startPromise) {
    System.out.println("Start " + getClass().getName());
    vertx.deployVerticle(new VentricleA());
    vertx.deployVerticle(new VentricleB());
    startPromise.complete();
  }
}
