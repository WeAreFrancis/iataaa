Feature: Remove player

  Background:
    Given there are these aiPlayers data in database:
      | id | difficulty | name | token | ip        | port | path |
      | 0a | EASY       | ia1  | toto  | 127.0.0.1 | 8080 | api  |
      | 1a | HARD       | ia2  | toto  | 127.0.0.1 | 8081 | api  |

  Scenario: I make call to DELETE right entity.
    When I set a "DELETE" request to "/api/aiPlayers/0a"
    And I send the request
    Then the response status code is 204
    And the aiPlayers data database is:
      | id | difficulty | name | token | ip        | port | path |
      | 1a | HARD       | ia2  | toto  | 127.0.0.1 | 8081 | api  |

  Scenario: I make call to DELETE non-existent entity.
    When I set a "DELETE" request to "/api/aiPlayers/incorrectId"
    And I send the request
    Then the response status code is 404
    And the aiPlayers data database is:
      | id | difficulty | name | token | ip        | port | path |
      | 0a | EASY       | ia1  | toto  | 127.0.0.1 | 8080 | api  |
      | 1a | HARD       | ia2  | toto  | 127.0.0.1 | 8081 | api  |