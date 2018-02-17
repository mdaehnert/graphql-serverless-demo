package de.mdaehnert.graphql.serverless;

import org.junit.Test;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HandlerTest {

  @Test
  public void testGetCustomer() throws Exception {
    String res = new Handler().handleRequest(getRequestJson(), null);

    System.out.println(res);
  }


  private String getRequestJson() throws Exception {
    URL url = this.getClass().getClassLoader().getResource("query.json");
    Path path = Paths.get(url.toURI());
    byte[] fileBytes = Files.readAllBytes(path);

    return new String(fileBytes);
  }
}
