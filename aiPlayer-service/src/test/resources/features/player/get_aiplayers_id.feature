Feature: Get player

  Background:
    Given there are these aiPlayers data in database:
      | id | difficulty | name | token | ip        | port | path |
      | 0a | EASY       | ia1  | toto  | 127.0.0.1 | 8080 | api  |
      | 1a | HARD       | ia2  | toto  | 127.0.0.1 | 8081 | api  |

  Scenario: I make call to GET right player.
    When I set a "GET" request to "/api/aiPlayers/0a"
    And I send the request
    Then the response status code is 200
    And the aiPlayers data database is:
      | id | difficulty | name | token | ip        | port | path |
      | 0a | EASY       | ia1  | toto  | 127.0.0.1 | 8080 | api  |
      | 1a | HARD       | ia2  | toto  | 127.0.0.1 | 8081 | api  |
    And the response body matches :
      | id         | 0a        |
      | difficulty | EASY      |
      | name       | ia1       |
      | token      | toto      |
      | ip         | 127.0.0.1 |
      | port       | 8080      |
      | path       | api       |


  Scenario: I make call to GET non-existent player.
    When I set a "GET" request to "/api/aiPlayers/incorrectId"
    And I send the request
    Then the response status code is 404
    And the aiPlayers data database is:
      | id | difficulty | name | token | ip        | port | path |
      | 0a | EASY       | ia1  | toto  | 127.0.0.1 | 8080 | api  |
      | 1a | HARD       | ia2  | toto  | 127.0.0.1 | 8081 | api  |