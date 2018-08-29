package com.gnavin.jolt.experimentations;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    // How to access the test artifacts, i.e. JSON files
    //  JsonUtils.classpathToList : assumes you put the test artifacts in your class path
    //  JsonUtils.filepathToList : you can use an absolute path to specify the files

    final List<Object> objects = JsonUtils.filepathToList("sample/spec.json");
    System.out.println("objects = " + objects);

    final List<Object> chainrSpecJSON = JsonUtils.filepathToList("sample/spec.json");
    Chainr chainr = Chainr.fromSpec(chainrSpecJSON);

    Object inputJSON = JsonUtils.filepathToObject("sample/input.json");

    final Map<String, Object> stringStringHashMap = new HashMap<>();
    stringStringHashMap.put("key1", "key2");

    Object transformedOutput = chainr.transform(inputJSON, stringStringHashMap);
    System.out.println(JsonUtils.toJsonString(transformedOutput));
  }
}
