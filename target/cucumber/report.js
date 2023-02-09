$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/SecondTestCase/Features/OrderCreation.feature");
formatter.feature({
  "line": 1,
  "name": "Create an Order",
  "description": "",
  "id": "create-an-order",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Create a order from a new Customer",
  "description": "",
  "id": "create-an-order;create-a-order-from-a-new-customer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "Create a new customer",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "Create a new order",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "The new customer should be available",
  "keyword": "Then "
});
formatter.match({
  "location": "OrderPage.create_a_new_customer()"
});
formatter.result({
  "duration": 22425711700,
  "status": "passed"
});
formatter.match({
  "location": "OrderPage.create_a_new_order()"
});
formatter.result({
  "duration": 1799577900,
  "status": "passed"
});
formatter.match({
  "location": "OrderPage.the_new_customer_should_be_available()"
});
formatter.result({
  "duration": 45737600,
  "error_message": "org.junit.ComparisonFailure: Customer found must be \u0027Company Name [9897]\u0027 expected:\u003c[Company Name [9897]]\u003e but was:\u003c[No matches found]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat SecondTestCase.Pages.OrderPage.the_new_customer_should_be_available(OrderPage.java:71)\r\n\tat ✽.Then The new customer should be available(src/test/java/SecondTestCase/Features/OrderCreation.feature:5)\r\n",
  "status": "failed"
});
});