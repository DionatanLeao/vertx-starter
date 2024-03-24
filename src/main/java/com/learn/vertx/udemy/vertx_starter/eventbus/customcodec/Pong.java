package com.learn.vertx.udemy.vertx_starter.eventbus.customcodec;

public class Pong {
  private Integer id;

  public Pong() {}

  public Pong(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
