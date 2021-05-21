@Store
Feature: Store

  @Store_001 @deleteAddedItem
  Scenario: Verify that user is able to search an item
  #First Test Case:
  #1 Go to Amazon.com
  #2 Search for Samsung Galaxy Note 20
  #3 Verify Item is displayed on the screen and  locate the first one, then store the price
  #4 Click on the First Result
  #5 Once in the details page compare this price vs the above one (first stored price)
  #6 Click on Add to Cart.
  #7 Go to Cart and verify again the price of the phone
  #8 Delete Item
    Given I navigate to Amazon Portal
    When I search the "Actual Phone" item
    Then The result page is displayed
    And The "Actual Phone" item is displayed in the page
    And I save the item price for "Actual Phone"
    When I click on the first item on the result list
    Then The item page is displayed
    And The item price displayed should be the same as saved "Actual Phone" price
    When I add the item to the Cart
    Then The pre-order page is displayed
    And The item price added should be the same as saved "Actual Phone" price


