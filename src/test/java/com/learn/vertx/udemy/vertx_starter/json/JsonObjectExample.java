package com.learn.vertx.udemy.vertx_starter.json;

import io.vertx.core.json.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonObjectExample {

  @Test
  void jsonObjectCanBeMapped() {
    final JsonObject myJsonObject = new JsonObject();
    myJsonObject.put("id", 1);
    myJsonObject.put("name", "Alice");
    myJsonObject.put("loves_vertx", true);

    final String encoded = myJsonObject.encode();
    Assertions.assertEquals("{\"id\":1,\"name\":\"Alice\",\"loves_vertx\":true}", encoded);

    final JsonObject decodedJsonObject = new JsonObject(encoded);
    Assertions.assertEquals(myJsonObject, decodedJsonObject);
  }

  @Test
  void jsonObjectCanBeCreatedFromMap() {
    final Map<String, Object> myMap = new HashMap<>();
    myMap.put("id", 1);
    myMap.put("name", "Alice");
    myMap.put("loves_vertx", true);

    final JsonObject asJsonObject = new JsonObject(myMap);
    Assertions.assertEquals(myMap, asJsonObject.getMap());
  }

}
