package ${package}.adapters.example;

import io.knotx.adapter.AbstractAdapterProxy;
import io.knotx.dataobjects.AdapterRequest;
import io.knotx.dataobjects.AdapterResponse;
import io.knotx.dataobjects.ClientResponse;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import rx.Observable;

public class ExampleServiceAdapterProxy extends AbstractAdapterProxy {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExampleServiceAdapterProxy.class);

  @Override
  protected Observable<AdapterResponse> processRequest(AdapterRequest adapterRequest) {
    final String message = adapterRequest.getParams().getString("message");
    LOGGER.info("Processing request with message: `{}`", message);
    /**
     * In a real scenario, one would connect to an external service here
     */
    return prepareResponse(message);
  }

  private Observable<AdapterResponse> prepareResponse(String message) {
    final AdapterResponse response = new AdapterResponse();
    final ClientResponse clientResponse = new ClientResponse();
    clientResponse.setBody(Buffer.buffer("{\"message\":\"" + message + "\"}"));
    response.setResponse(clientResponse);
    AdapterResponse[] responses = {response};
    return Observable.from(responses);
  }

}