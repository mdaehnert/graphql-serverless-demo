# graphql-serverless-demo

This project is a demonstration on how to implement GraphQL with AWS Lambda.

## Services
The following AWS features will be used / are required:
* API Gateway
* Lambda
* DynamoDB


## Setup environment
1. Create DynamoDB Table with name *customer* and an item like:
```json
{
  "age": 27,
  "birthday": "1991-09-12",
  "id": 0,
  "name": "Micha",
  "orders": [
    {
      "amount": 123,
      "date": "2017-12-21"
    }
  ]
}
```
2. Lambda: Deploy Fat-JAR
3. Create API Gateway with 1 endpoint as *Lambda Proxy* and wire it with the previously created lambda.


## Build Lambda function and execute query + mutation
``mvn clean package``
