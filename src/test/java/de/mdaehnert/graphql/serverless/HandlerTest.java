package de.mdaehnert.graphql.serverless;

import org.junit.Test;

public class HandlerTest {

  @Test
  public void testGetCustomer() {
    String res = new Handler().handleRequest("", null);

    System.out.println(res);
  }

}
