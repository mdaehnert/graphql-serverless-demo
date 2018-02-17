package de.mdaehnert.graphql.serverless;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.ArrayList;
import java.util.List;

public class HandlerTest {

  @Test
  public void testGetCustomer() {
  }


  private init() {
    AmazonDynamoDB ddb = DynamoDBEmbedded.create().amazonDynamoDB();
  }


  private static CreateTableResult createTable(AmazonDynamoDB ddb) {
    String tableName = "customer";
    String hashKeyName = "id";

    List<AttributeDefinition> attributeDefinitions = new ArrayList<>();
    attributeDefinitions.add(new AttributeDefinition(hashKeyName, ScalarAttributeType.S));

    List<KeySchemaElement> ks = new ArrayList<>();
    ks.add(new KeySchemaElement(hashKeyName, KeyType.HASH));

    ProvisionedThroughput provisionedthroughput = new ProvisionedThroughput(1000L, 1000L);

    CreateTableRequest request =
      new CreateTableRequest()
        .withTableName(tableName)
        .withAttributeDefinitions(attributeDefinitions)
        .withKeySchema(ks)
        .withProvisionedThroughput(provisionedthroughput);

    return ddb.createTable(request);
  }
}
