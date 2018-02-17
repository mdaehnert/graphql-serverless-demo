package de.mdaehnert.graphql.serverless.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

@DynamoDBDocument
public class Order {

  private Integer id;
  private String date;

  @DynamoDBHashKey(attributeName = "id")
  public Integer getId() { return id; }
  public void setId(Integer id) { this.id = id; }

  @DynamoDBHashKey(attributeName = "date")
  public String getDate() { return date; }
  public void setDate(String date) { this.date = date; }

}
