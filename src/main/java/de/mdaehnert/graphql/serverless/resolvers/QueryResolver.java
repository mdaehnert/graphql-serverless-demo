package de.mdaehnert.graphql.serverless.resolvers;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class QueryResolver implements GraphQLQueryResolver {

  private DynamoDB getDB() {
    AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
    builder.withRegion(Regions.EU_CENTRAL_1);

    return new DynamoDB(builder.build());
  }


  public String getCustomer() {
    QuerySpec spec = new QuerySpec()
      .withKeyConditionExpression("id = :id")
      .withValueMap(new ValueMap()
        .withInt(":id", 0));

    Item res = getDB().getTable("customer").query(spec).iterator().next();

    return res.toString();
  }

}