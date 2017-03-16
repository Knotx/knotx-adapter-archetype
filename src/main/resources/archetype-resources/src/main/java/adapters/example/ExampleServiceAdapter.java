package ${package}.adapters.example;

import io.knotx.proxy.AdapterProxy;
import io.vertx.core.Context;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.serviceproxy.ProxyHelper;

public class ExampleServiceAdapter extends AbstractVerticle {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExampleServiceAdapter.class);

  private MessageConsumer<JsonObject> consumer;

  private ExampleServiceAdapterConfiguration configuration;

  @Override
  public void init(Vertx vertx, Context context) {
    super.init(vertx, context);
    configuration = new ExampleServiceAdapterConfiguration(config());
  }

  @Override
  public void start() throws Exception {
    LOGGER.info("Starting <{}>", this.getClass().getSimpleName());
    //register the service proxy on event bus
    consumer = ProxyHelper
        .registerService(AdapterProxy.class, getVertx(),
            new ExampleServiceAdapterProxy(),
            configuration.getAddress());
  }

  @Override
  public void stop() throws Exception {
    ProxyHelper.unregisterService(consumer);
  }
}