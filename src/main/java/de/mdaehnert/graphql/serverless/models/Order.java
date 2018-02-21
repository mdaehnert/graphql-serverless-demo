package de.mdaehnert.graphql.serverless.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

@DynamoDBDocument
public class Order {

  private int amount;
  private String date;

  @DynamoDBHashKey(attributeName = "amount")
  public int getAmount() { return amount; }
  public void setAmount(int amount) { this.amount = amount; }

  @DynamoDBHashKey(attributeName = "date")
  public String getDate() { return date; }
  public void setDate(String date) { this.date = date; }

}
