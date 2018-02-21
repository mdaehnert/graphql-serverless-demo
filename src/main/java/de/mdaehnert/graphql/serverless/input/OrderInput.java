package de.mdaehnert.graphql.serverless.input;

public class OrderInput {

  private int customerId;
  private int amount;

  public Integer getCustomerId() { return customerId; }
  public void setCustomerId(int amount) { this.customerId = customerId; }

  public Integer getAmount() { return amount; }
  public void setAmount(int amount) { this.amount = amount; }

}
