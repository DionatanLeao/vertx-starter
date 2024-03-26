package com.learn.vertx.udemy.vertx_starter.eventbus.customcodec;

import io.vertx.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingPongExample {
  static final Logger LOG = LoggerFactory.getLogger(PingPongExample.class);
  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new PingVerticle(), logOnError());
    vertx.deployVerticle(new PongVerticle(), logOnError());
  }

  private static Handler<AsyncResult<String>> logOnError() {
    return ar -> {
      if (ar.failed()) {
        LOG.error("err", ar.cause());
      }
    };
  }

  static class PingVerticle extends AbstractVerticle {
    static final Logger LOG = LoggerFactory.getLogger(PingVerticle.class);
    public static final String ADDRESS = PingVerticle.class.getName();

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
      var eventBus = vertx.eventBus();
      final Ping message = new Ping("Hello", true);
      LOG.debug("Sending: {}", message);
      // Register only once
      eventBus.registerDefaultCodec(Ping.class, new LocalMessageCodec<>(Ping.class));
      eventBus.<Pong>request(ADDRESS, message, reply -> {
        if (reply.failed()) {
          LOG.error("Failed: ", reply.cause());
          return;
        }
        LOG.debug("Response: {}", reply.result().body());
      });
      startPromise.complete();
    }
  }

  static class PongVerticle extends AbstractVerticle {
    static final Logger LOG = LoggerFactory.getLogger(PongVerticle.class);

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
      var eventBus = vertx.eventBus();
      // Register only once
      eventBus.registerDefaultCodec(Pong.class, new LocalMessageCodec<>(Pong.class));
      eventBus.<Ping>consumer(PingVerticle.ADDRESS, message -> {
        LOG.debug("Received Message: {}", message.body());
        message.reply(new Pong(0));
      }).exceptionHandler(error -> {
        LOG.error("Error: ", error);
      });
      startPromise.complete();
    }
  }
}
