package de.mdaehnert.graphql.serverless;


import com.amazonaws.services.lambda.runtime.Context;
import com.coxautodev.graphql.tools.SchemaParser;
import com.coxautodev.graphql.tools.SchemaParserBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.mdaehnert.graphql.serverless.resolvers.MutationResolver;
import de.mdaehnert.graphql.serverless.resolvers.QueryResolver;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;

import java.util.HashMap;
import java.util.Map;

public class Handler {

  private GraphQLSchema schema;


  public String handleRequest(InputType input, Context context) {
    init();

    ExecutionInput exec = ExecutionInput.newExecutionInput()
      .query(input.getQuery())
      .variables(input.getVariables())
      .build();

    ExecutionResult result = GraphQL.newGraphQL(schema).build().execute(exec);

    return result.toSpecification().toString();
  }


  private void init() {
    SchemaParserBuilder parser = SchemaParser.newParser().file("schema.graphqls");
    parser.resolvers(new QueryResolver(), new MutationResolver());

    schema = parser.build().makeExecutableSchema();
  }

}

class InputType {
  private String query;
  private Map<String, Object> variables = new HashMap<>();

  public void setQuery(String query) {
    this.query = query;
  }

  public String getQuery() {
    return query;
  }



  public void setVariables(Map<String, Object> variables) {
    this.variables = variables;
  }

  public Map<String, Object> getVariables() {
    return variables;
  }

}
