package ${package}.knot.example;

import io.knotx.proxy.KnotProxy;
import io.vertx.core.Context;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.serviceproxy.ProxyHelper;

public class ExampleKnot extends AbstractVerticle {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExampleKnot.class);

  private MessageConsumer<JsonObject> consumer;

  private ExampleKnotConfiguration configuration;

  @Override
  public void init(Vertx vertx, Context context) {
    super.init(vertx, context);
    configuration = new ExampleKnotConfiguration(config());
  }

  @Override
  public void start() throws Exception {
    LOGGER.info("Starting <{}>", this.getClass().getSimpleName());
    //register the service proxy on event bus
    consumer = ProxyHelper
        .registerService(KnotProxy.class, getVertx(),
            new ExampleKnotProxy(configuration.getSecret()),
            configuration.getAddress());
  }

  @Override
  public void stop() throws Exception {
    ProxyHelper.unregisterService(consumer);
  }
}