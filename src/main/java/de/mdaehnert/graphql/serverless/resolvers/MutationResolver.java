package de.mdaehnert.graphql.serverless.resolvers;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import de.mdaehnert.graphql.serverless.models.Order;

public class MutationResolver implements GraphQLMutationResolver {


  public Order addOrder(Order order) {

    return null;
  }


  private DynamoDBMapper getDB() {
    AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
    builder.withRegion(Regions.EU_CENTRAL_1);

    return new DynamoDBMapper(builder.build());
  }

}