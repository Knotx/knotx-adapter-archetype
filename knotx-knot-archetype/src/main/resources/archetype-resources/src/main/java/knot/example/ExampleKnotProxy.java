package ${package}.knot.example;

import io.knotx.dataobjects.ClientResponse;
import io.knotx.dataobjects.KnotContext;
import io.knotx.knot.AbstractKnotProxy;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import java.util.Collections;
import java.util.Set;
import rx.Single;

public class ExampleKnotProxy extends AbstractKnotProxy {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExampleKnotProxy.class);

  private static final String DEFAULT_TRANSITION = "next";

  @Override
  protected Single<KnotContext> processRequest(KnotContext knotContext) {
    LOGGER.trace("This request is processed by me!");
    String value = someBusinessLogic(knotContext);
    return Single.just(knotContext).map(context -> {
      JsonObject jsonObject = new JsonObject(Collections.singletonMap("param", value));
      context.getCache().put("example", Single.just(jsonObject));
      context.setTransition(DEFAULT_TRANSITION);
      return context;
    });
  }

  @Override
  protected boolean shouldProcess(Set<String> knots) {
    // our example Knot processes all incoming messages
    return true;
  }

  @Override
  protected KnotContext processError(KnotContext knotContext, Throwable error) {
    HttpResponseStatus statusCode;
    if (error instanceof IllegalArgumentException) {
      statusCode = HttpResponseStatus.BAD_REQUEST;
    } else {
      statusCode = HttpResponseStatus.INTERNAL_SERVER_ERROR;
    }
    knotContext.setClientResponse(new ClientResponse().setStatusCode(statusCode.code()));
    return knotContext;
  }

  private String someBusinessLogic(KnotContext knotContext) {
    return "value";
  }
}