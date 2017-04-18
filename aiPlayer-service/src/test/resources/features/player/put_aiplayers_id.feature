Feature: Put player

  Background:
    Given there are these aiPlayers data in database:
      | id | difficulty | name | token | ip        | port | path |
      | 0a | EASY       | ia1  | toto  | 127.0.0.1 | 8080 | api  |
      | 1a | HARD       | ia2  | toto  | 127.0.0.1 | 8081 | api  |

  Scenario: I make call to PUT right player.
    When I set a "PUT" request to "/api/aiPlayers/0a"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
     """
      {
        "difficulty":"HARD",
        "name":"terminator",
        "ip":"172.16.254.1",
        "port":8081,
        "path":"api/game"
      }
    """
    And I send the request
    Then the response status code is 200
    And the response body matches :
      | id         | 0a           |
      | difficulty | HARD         |
      | name       | terminator   |
      | token      | toto         |
      | ip         | 172.16.254.1 |
      | port       | 8081         |
      | path       | api/game     |
    And the aiPlayers data database is:
      | id | difficulty | name       | token | ip           | port | path     |
      | 0a | HARD       | terminator | toto  | 172.16.254.1 | 8081 | api/game |
      | 1a | HARD       | ia2        | toto  | 127.0.0.1    | 8081 | api      |


  Scenario: I make call to PUT entity without json in body request.
    When I set a "PUT" request to "/api/aiPlayers/0a"
    And I send the request
    Then the response status code is 400
    And the aiPlayers data database is:
      | id | difficulty | name | token | ip        | port | path |
      | 0a | EASY       | ia1  | toto  | 127.0.0.1 | 8080 | api  |
      | 1a | HARD       | ia2  | toto  | 127.0.0.1 | 8081 | api  |


  Scenario: I make call to PUT non-existent player.
    When I set a "PUT" request to "/api/aiPlayers/incorrectId"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "difficulty":"HARD",
        "name":"terminator",
        "ip":"172.16.254.1",
        "port":8081,
        "path":"api/game"
      }
    """
    And I send the request
    Then the response status code is 404
    And the aiPlayers data database is:
      | id | difficulty | name | token | ip        | port | path |
      | 0a | EASY       | ia1  | toto  | 127.0.0.1 | 8080 | api  |
      | 1a | HARD       | ia2  | toto  | 127.0.0.1 | 8081 | api  |

  Scenario: I make call to PUT without name in json.
    When I set a "PUT" request to "/api/aiPlayers/01"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "difficulty":"HARD",
        "ip":"172.16.254.1",
        "port":8081,
        "path":"api/game"
      }
    """
    And I send the request
    Then the response status code is 400
    And the aiPlayers data database is:
      | id | difficulty | name | token | ip        | port | path |
      | 0a | EASY       | ia1  | toto  | 127.0.0.1 | 8080 | api  |
      | 1a | HARD       | ia2  | toto  | 127.0.0.1 | 8081 | api  |

  Scenario: I make call to PUT without difficulty in json.
    When I set a "PUT" request to "/api/aiPlayers/01"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "name":"terminator",
        "ip":"172.16.254.1",
        "port":8081,
        "path":"api/game"
      }
    """
    And I send the request
    Then the response status code is 400
    And the aiPlayers data database is:
      | id | difficulty | name | token | ip        | port | path |
      | 0a | EASY       | ia1  | toto  | 127.0.0.1 | 8080 | api  |
      | 1a | HARD       | ia2  | toto  | 127.0.0.1 | 8081 | api  |


  Scenario: I make call to PUT without ip in json.
    When I set a "PUT" request to "/api/aiPlayers/01"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "name":"terminator",
        "difficulty":"HARD",
        "port":8081,
        "path":"api/game"
      }
    """
    And I send the request
    Then the response status code is 400
    And the aiPlayers data database is:
      | id | difficulty | name | token | ip        | port | path |
      | 0a | EASY       | ia1  | toto  | 127.0.0.1 | 8080 | api  |
      | 1a | HARD       | ia2  | toto  | 127.0.0.1 | 8081 | api  |

  Scenario: I make call to PUT without port in json.
    When I set a "PUT" request to "/api/aiPlayers/01"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "name":"terminator",
        "difficulty":"HARD",
        "port":8081,
        "path":"api/game"
      }
    """
    And I send the request
    Then the response status code is 400
    And the aiPlayers data database is:
      | id | difficulty | name | token | ip        | port | path |
      | 0a | EASY       | ia1  | toto  | 127.0.0.1 | 8080 | api  |
      | 1a | HARD       | ia2  | toto  | 127.0.0.1 | 8081 | api  |

  Scenario: I make call to PUT /aiPlayers with invalid ip.
    When I set a "PUT" request to "/api/aiPlayers/01"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
       {
        "name":"ia1",
        "difficulty":"HARD",
        "ip":"yolo",
        "port":8080,
        "path":"api"
      }
    """
    And I send the request
    Then the response status code is 400
    And the aiPlayers data database is:
      | id | difficulty | name | token | ip        | port | path |
      | 0a | EASY       | ia1  | toto  | 127.0.0.1 | 8080 | api  |
      | 1a | HARD       | ia2  | toto  | 127.0.0.1 | 8081 | api  |