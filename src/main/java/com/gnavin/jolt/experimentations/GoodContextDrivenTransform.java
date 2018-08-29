package com.gnavin.jolt.experimentations;

import com.bazaarvoice.jolt.ContextualTransform;
import java.util.Map;

public class GoodContextDrivenTransform implements ContextualTransform {

  public static final String CONTEXT_KEY = "test_context_key_1";

  private static final String STATIC_KEY = "c";

  @Override
  public Object transform(Object input, Map<String, Object> context) {

    String contextValue = (String) context.get(CONTEXT_KEY);

    ((Map) input).put(STATIC_KEY, contextValue);

    return input;
  }

}
