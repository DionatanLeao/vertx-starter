package com.learn.vertx.udemy.vertx_starter.ventricles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VentricleA extends AbstractVerticle {
  private static final Logger LOG = LoggerFactory.getLogger(VentricleA.class);

  @Override
  public void start(Promise<Void> startPromise) {
    LOG.debug("Start {}", getClass().getName());
    vertx.deployVerticle(new VentricleAA(), whenDeployed -> {
      LOG.debug("Deployer {}", VentricleAA.class.getName());
      vertx.undeploy(whenDeployed.result());
    });
    vertx.deployVerticle(new VentricleAB(), whenDeployed -> {
      LOG.debug("Deployer {}", VentricleAB.class.getName());
      // Do not undeploy
    });
    startPromise.complete();
  }
}
