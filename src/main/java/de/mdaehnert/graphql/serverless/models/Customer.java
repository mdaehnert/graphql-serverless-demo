package de.mdaehnert.graphql.serverless.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "customer")
public class Customer {

  private Integer id;
  private String name;
  private Integer age;
  private String birthdate;
  private List<Order> orders;


  @DynamoDBHashKey(attributeName = "id")
  public Integer getId() { return id; }
  public void setId(Integer id) { this.id = id; }

  @DynamoDBAttribute(attributeName="name")
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  @DynamoDBAttribute(attributeName="age")
  public Integer getAge() { return age; }
  public void setAge(Integer age) { this.age = age; }

  @DynamoDBAttribute(attributeName="birthdate")
  public String getBirthdate() { return birthdate; }
  public void setBirthdate(String birthdate) { this.birthdate = birthdate; }

  @DynamoDBAttribute(attributeName="orders")
  public List<Order> getOrders() { return orders; }
  public void setOrders(List<Order> orders) { this.orders = orders; }

}
