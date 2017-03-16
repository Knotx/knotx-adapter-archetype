package ${package}.adapters.example;

import io.vertx.core.json.JsonObject;

public class ExampleServiceAdapterConfiguration {

  private String address;

  private JsonObject clientOptions;

  public ExampleServiceAdapterConfiguration(JsonObject config) {
    address = config.getString("address");
    clientOptions = config.getJsonObject("message", new JsonObject());
  }

  public JsonObject getClientOptions() {
    return clientOptions;
  }

  public String getAddress() {
    return address;
  }
}
