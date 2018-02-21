package de.mdaehnert.graphql.serverless.resolvers;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import de.mdaehnert.graphql.serverless.input.OrderInput;
import de.mdaehnert.graphql.serverless.models.Customer;
import de.mdaehnert.graphql.serverless.models.Order;
import org.joda.time.DateTime;

public class MutationResolver implements GraphQLMutationResolver {


  public Order addOrder(OrderInput newOrder) {
    Customer c = getDB().load(Customer.class, newOrder.getCustomerId());

    Order o = new Order();

    o.setAmount(newOrder.getAmount());
    o.setDate(DateTime.now().toDateTimeISO().toString());

    c.getOrders().add(o);

    getDB().save(c);

    return o;
  }


  private DynamoDBMapper getDB() {
    AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
    builder.withRegion(Regions.EU_CENTRAL_1);

    return new DynamoDBMapper(builder.build());
  }

}