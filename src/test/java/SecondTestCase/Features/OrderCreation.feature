Feature: Create an Order
  Scenario: Create a order from a new Customer
    Given Create a new customer
    When Create a new order
    Then The new customer should be available