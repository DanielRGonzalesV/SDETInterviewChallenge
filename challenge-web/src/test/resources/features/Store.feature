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
    And I save the item price for first "Actual Phone"
    When I click on the "Actual Phone" first item on the result list
    Then The item page is displayed
    And The item price displayed should be the same as saved "Actual Phone" price
    When I add the item to the Cart
    Then The pre-order page is displayed
    And The item price added should be the same as saved "Actual Phone" price

  @Store_001 @deleteAddedItem
  Scenario: Verify that user is able to search an item
    #  1. Go to Amazon main page
    #  2. Locate at the upper right corner the button: Hello, Sign In Account & lists and click on it
    #  3. Click on "New customer? Start right here"
    #  4. Fill Name field with the response of this API => [Options in the AC]
    #  5. Fill Email field with the data from the API response Firstname.Lastname@fake.com
    #  6. Click on Condition of Use link
    #  7. Locate the search bar and Search for Echo
    #  8. Locate "Echo support" options and click on it
    #  9. Following elements should be displayed: Getting Started, Wi-Fi and Bluetooth, Device Software and Hardware, TroubleShooting
    Given I navigate to Amazon Portal
    When I open the Account and list options
    And I click on Start here for New customer
    Then The Create account page is displayed
    When I fill out the form with the information of employee number 1
      | Your name         | employeeNameAPI |
      | Email             | employeeEmailAPI |
      | Password          | employeePasswordAPI |
      | Re-enter password | employeePasswordAPI |
    And I click on Create your Amazon account
    Then The Verify email address page is displayed