package ${package}.knot.example;

import io.vertx.core.json.JsonObject;

class ExampleKnotConfiguration {

  private String address;

  ExampleKnotConfiguration(JsonObject config) {
    address = config.getString("address");
  }

  String getAddress() {
    return address;
  }
}
