package ${package}.handlebars;

import com.github.jknack.handlebars.Options;
import io.knotx.knot.templating.handlebars.CustomHandlebarsHelper;
import java.io.IOException;

public class TrainsHelper implements CustomHandlebarsHelper<Object> {

  @Override
  public String getName() {
    return "train";
  }

  @Override
  public CharSequence apply(Object value, Options options) throws IOException {
    Options.Buffer buffer = options.buffer();
    buffer.append("\uD83D\uDE82\uD83D\uDE83\uD83D\uDE83\uD83D\uDE83 ");
    buffer.append("<strong>I like trains!</strong>");
    buffer.append(options.fn());
    return buffer;
  }
}
