package de.mdaehnert.graphql.serverless;

public class HandlerTest {

  @Test
  public void testGetCustomer() {
    testGraphQl("""
      {"query": "
        query testFind {
          matches {
            id
            notificationSeen

            pdProjectRequest {
              description
              projectLocation

              pdProject {
                customerName
              }
            }
          }
        }
      "}
    """,
    "{}")
  }