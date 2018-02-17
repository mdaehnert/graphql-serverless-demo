package de.mdaehnert.graphql.serverless;

import org.junit.Test;

public class HandlerTest {

  @Test
  public void testGetCustomer() {
    new Handler().handleRequest("", null);
  }

}
