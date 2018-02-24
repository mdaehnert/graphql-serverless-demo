package de.mdaehnert.graphql.serverless;

import de.mdaehnert.graphql.serverless.input.OrderInput;
import org.junit.Test;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class HandlerTest {

  @Test
  public void testGetCustomer() throws Exception {
    InputType data = new InputType();
    data.setQuery(getCustomerJson());

    Map<String, Object> vars = new HashMap<>();
    vars.put("id", 0);

    data.setVariables(vars);

    String res = new Handler().handleRequest(data, null);

    System.out.println(res);
  }


  @Test
  public void testAddOrder() throws Exception {
    InputType data = new InputType();
    data.setQuery(getOrderJson());

    Map<String, Object> vars = new HashMap<>();
    OrderInput input = new OrderInput();
    input.setCustomerId(0);
    input.setAmount(123);

    data.setVariables(vars);
    String res = new Handler().handleRequest(data, null);

    System.out.println(res);
  }


  private String getCustomerJson() throws Exception {
    URL url = this.getClass().getClassLoader().getResource("query.graphql");
    Path path = Paths.get(url.toURI());
    byte[] fileBytes = Files.readAllBytes(path);

    return new String(fileBytes);
  }

  private String getOrderJson() throws Exception {
    URL url = this.getClass().getClassLoader().getResource("mutation.graphql");
    Path path = Paths.get(url.toURI());
    byte[] fileBytes = Files.readAllBytes(path);

    return new String(fileBytes);
  }
}
