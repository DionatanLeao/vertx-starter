package com.learn.vertx.udemy.vertx_starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class MainVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    final Logger LOG = LoggerFactory.getLogger(MainVerticle.class);
    vertx.createHttpServer().requestHandler(req -> {
      req.response()
        .putHeader("content-type", "text/plain")
        .end("Hello from Vert.x!");
    }).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        LOG.info("HTTP server started on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    });
    vertx.setPeriodic(500, id -> {
      LOG.debug(String.valueOf(new Random().nextDouble()));
    });
  }
}
