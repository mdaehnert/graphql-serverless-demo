package de.mdaehnert.graphql.serverless;


import com.amazonaws.services.lambda.runtime.Context;
import com.coxautodev.graphql.tools.SchemaParser;
import com.coxautodev.graphql.tools.SchemaParserBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.mdaehnert.graphql.serverless.resolvers.QueryResolver;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;

import java.util.HashMap;
import java.util.Map;

public class Handler {

  private GraphQLSchema schema;


  public String handleRequest(String input, Context context) {
    init();

    ExecutionInput exec = ExecutionInput.newExecutionInput()
      .query(extractQueries(input))
      .variables(extractVariables(input))
      .build();

    ExecutionResult result = GraphQL.newGraphQL(schema).build().execute(exec);

    return result.toString();
  }


  private void init() {
    SchemaParserBuilder parser = SchemaParser.newParser().file("schema.graphqls");
    parser.resolvers(new QueryResolver());

    schema = parser.build().makeExecutableSchema();
  }


  private String extractQueries(String input) {
    JsonObject request = new JsonParser().parse(input).getAsJsonObject();

    return request.get("query").getAsString();
  }


  private Map<String, Object> extractVariables(String input) {
    return new HashMap<>();
  }
}
