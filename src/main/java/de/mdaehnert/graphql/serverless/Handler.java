package de.mdaehnert.graphql.serverless;


import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.lambda.runtime.Context;

public class Handler {

  private DynamoDB init() {
    AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
    builder.setRegion(Regions.EU_CENTRAL_1.getName());

    return new DynamoDB(builder.build());
  }


  public String handleRequest(String input, Context context) {
    DynamoDB db = init();


    QuerySpec spec = new QuerySpec()
      .withKeyConditionExpression("Id = :id")
      .withValueMap(new ValueMap()
        .withString(":id", "1"));

    Item res = db.getTable("Customer").query(spec).iterator().next();

    return res.toString();
  }

}
