package com.gnavin.jolt.experimentations;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main2 {

  public static void main(String[] args) throws IOException {

    String testPath = "sample/spec_with_context.json";
    Map<String, Object> testSuite = JsonUtils.filepathToMap( testPath );

    Object spec = testSuite.get( "spec" );
    List<Map> tests = (List<Map>) testSuite.get( "tests" );

    List<Object[]> accum = new ArrayList<>();

    for ( Map testCase : tests ) {

      String testCaseName = (String) testCase.get( "testCaseName" );
      Object input = testCase.get( "input" );
      Map<String,Object> context = (Map<String,Object>) testCase.get( "context" );
      Object expected = testCase.get( "expected" );

//      accum.add( new Object[] { testCaseName, spec, input, context, expected } );
      successCase(testCaseName, spec, input, context, expected);
    }


  }

  public static void successCase( String testCaseName, Object spec, Object input, Map<String,Object> context, Object expected ) throws IOException {

    Chainr unit = Chainr.fromSpec( spec );

    Object actual = unit.transform( input, context );

    System.out.println("actual = " + actual);
  }

}
