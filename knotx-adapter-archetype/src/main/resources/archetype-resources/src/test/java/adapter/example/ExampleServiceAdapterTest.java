package ${package}.adapter.example;

import io.knotx.dataobjects.AdapterRequest;
import io.knotx.dataobjects.AdapterResponse;
import io.knotx.dataobjects.ClientRequest;
import io.knotx.junit.rule.KnotxConfiguration;
import io.knotx.junit.rule.Logback;
import io.knotx.junit.rule.TestVertxDeployer;
import io.knotx.reactivex.proxy.AdapterProxy;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.RunTestOnContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.reactivex.core.Vertx;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.runner.RunWith;
import rx.functions.Action1;


@RunWith(VertxUnitRunner.class)
public class ExampleServiceAdapterTest {

  private final static String ADAPTER_ADDRESS = "knotx.adapter.service.example";

  //Test Runner Rule of Verts
  private RunTestOnContext vertx = new RunTestOnContext();

  //Test Runner Rule of Knotx
  private TestVertxDeployer knotx = new TestVertxDeployer(vertx);

  //Junit Rule, sets up logger, prepares verts, starts verticles according to the config (supplied in annotation of test method)
  @Rule
  public RuleChain chain = RuleChain.outerRule(new Logback()).around(vertx).around(knotx);


  @Test
  @KnotxConfiguration("test-config.json")
  public void integrationTestToBeWrittenHere(TestContext context) {
    callAdapterServiceWithAssertions(context, "/service/mock/first.json",
        adapterResponse -> {
          // assertions here
        },
        error -> context.fail(error.getMessage()));
  }

  private void callAdapterServiceWithAssertions(TestContext context, String servicePath,
      Action1<AdapterResponse> onSuccess,
      Action1<Throwable> onError) {
    AdapterRequest message = payloadMessage(servicePath);
    Async async = context.async();

    AdapterProxy service = AdapterProxy.createProxy(new Vertx(vertx.vertx()), ADAPTER_ADDRESS);

    service.rxProcess(message)
        .subscribe(
            success -> {
              try {
                onSuccess.call(success);
              } catch (Throwable e) {
                context.fail(e);
              } finally {
                async.complete();
              }
            },
            err -> {
              onError.call(err);
              async.complete();
            }
        );
  }

  private AdapterRequest payloadMessage(String servicePath) {
    return new AdapterRequest().setRequest(new ClientRequest())
        .setParams(new JsonObject().put("path", servicePath));
  }

}