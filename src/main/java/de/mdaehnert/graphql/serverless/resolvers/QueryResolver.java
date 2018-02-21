package de.mdaehnert.graphql.serverless.resolvers;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.mdaehnert.graphql.serverless.models.Customer;

public class QueryResolver implements GraphQLQueryResolver {


  public Customer getCustomer(int id) {
    return getDB().load(Customer.class, id);
  }

  private DynamoDBMapper getDB() {
    AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
    builder.withRegion(Regions.EU_CENTRAL_1);

    return new DynamoDBMapper(builder.build());
  }

}