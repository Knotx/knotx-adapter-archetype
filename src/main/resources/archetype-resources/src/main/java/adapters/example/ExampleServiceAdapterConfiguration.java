package ${package}.adapters.example;

import io.vertx.core.json.JsonObject;

public class ExampleServiceAdapterConfiguration {

  private String address;

  public ExampleServiceAdapterConfiguration(JsonObject config) {
    address = config.getString("address");
  }

  public String getAddress() {
    return address;
  }
}
