package de.mdaehnert.graphql.serverless;

import org.junit.Test;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HandlerTest {

  @Test
  public void testGetCustomer() throws Exception {
    String res = new Handler().handleRequest(getCustomerJson(), null);

    System.out.println(res);
  }

  @Test
  public void testAddOrder() throws Exception {
    String res = new Handler().handleRequest(getOrderJson(), null);

    System.out.println(res);
  }


  private String getCustomerJson() throws Exception {
    URL url = this.getClass().getClassLoader().getResource("query.json");
    Path path = Paths.get(url.toURI());
    byte[] fileBytes = Files.readAllBytes(path);

    return new String(fileBytes);
  }

  private String getOrderJson() throws Exception {
    URL url = this.getClass().getClassLoader().getResource("mutation.json");
    Path path = Paths.get(url.toURI());
    byte[] fileBytes = Files.readAllBytes(path);

    return new String(fileBytes);
  }
}
