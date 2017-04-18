Feature: Add aiPlayers

  Scenario: I make call to POST /aiPlayers.
    When I set a "POST" request to "/api/aiPlayers"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
       {
        "name":"ia1",
        "difficulty":"HARD",
        "ip":"127.0.0.1",
        "port":8080,
        "path":"api"
      }
    """
    And I send the request
    Then the response status code is 201
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the response body matches :
      | difficulty | HARD      |
      | name       | ia1       |
      | token      | toto      |
      | ip         | 127.0.0.1 |
      | port       | 8080      |
      | path       | api       |
    And the aiPlayers data database is:
      | difficulty | name | token | ip        | port | path |
      | HARD       | ia1  | toto  | 127.0.0.1 | 8080 | api  |

  Scenario: I make call to POST /aiPlayers without path in json..
    When I set a "POST" request to "/api/aiPlayers"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
       {
        "name":"ia1",
        "difficulty":"HARD",
        "ip":"127.0.0.1",
        "port":8080
      }
    """
    And I send the request
    Then the response status code is 201
    And the "Content-Type" attribute of the response header is "application/json;charset=UTF-8"
    And the response body matches :
      | difficulty | HARD      |
      | name       | ia1       |
      | token      | toto      |
      | ip         | 127.0.0.1 |
      | port       | 8080      |


  Scenario: I make call to POST without name in json.
    When I set a "POST" request to "/api/aiPlayers"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "difficulty":"HARD",
        "ip":"127.0.0.1",
        "port":8080,
        "path":"api"
      }
    """
    And I send the request
    Then the response status code is 400
    And the aiPlayers data database is:
      | difficulty | name | token | ip | port | path |


  Scenario: I make call to POST without difficulty in json.
    When I set a "POST" request to "/api/aiPlayers"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "name":"ia1",
        "ip":"127.0.0.1",
        "port":8080,
        "path":"api"
      }
    """
    And I send the request
    Then the response status code is 400
    And the aiPlayers data database is:
      | difficulty | name | token | ip | port | path |

  Scenario: I make call to POST without ip in json.
    When I set a "POST" request to "/api/aiPlayers"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "name":"ia1",
        "difficulty":"HARD",
        "port":8080,
        "path":"api"

      }
    """
    And I send the request
    Then the response status code is 400
    And the aiPlayers data database is:
      | difficulty | name | token | ip | port | path |

  Scenario: I make call to POST without port in json.
    When I set a "POST" request to "/api/aiPlayers"
    And the "Content-Type" attribute of the request header is "application/json"
    And the request body is :
    """
      {
        "name":"ia1",
        "difficulty":"HARD",
        "port":8080,
        "path":"api"

      }
    """
    And I send the request
    Then the response status code is 400
    And the aiPlayers data database is:
      | difficulty | name | token | ip | port | path |


  Scenario: I make call to POST /aiPlayers with invalid ip.
    When I set a "POST" request to "/api/aiPlayers"
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
      | difficulty | name | token | ip | port | path |