  package com.learn.vertx.udemy.vertx_starter.worker;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkerExample extends AbstractVerticle {
  private static final Logger LOG = LoggerFactory.getLogger(WorkerExample.class);
  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new WorkerExample());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    vertx.deployVerticle(new WorkerVerticle(),
      new DeploymentOptions()
        .setWorker(true)
        .setWorkerPoolSize(1)
        .setWorkerPoolName("my-worker-ventricle")
    );
    startPromise.complete();
    executeBlockingCode();
  }

  private void executeBlockingCode() {
    vertx.executeBlocking(event -> {
      try {
        LOG.debug("Executing blocking code");
        Thread.sleep(5000);
        event.fail("Force Fail!");
      } catch (InterruptedException e) {
        LOG.error("Failed ", e);
        event.fail(e);
      }
    }, result -> {
      if(result.succeeded()) {
        LOG.debug("Blocking call done.");
      } else {
        LOG.debug("Blocking call failed due to:", result.cause());
      }
    });
  }
}
