
Feature: QA Assessment feature

  @CheckLogin
  Scenario Outline: Successful Login
    Given on the Home page navigate to <URL>
    # Sign In
    And on the Home page Sign In button is clicked
    # Check Login functionality
    When on the Login page <Email> is set for the Email value
    And on the Login page <Password> is set for the Password value
    And on the Login page Submit button is clicked
    Then on the Dashboard page Welcome message is visible

    Examples:
      |Email| Password| URL|
      | quipu@byom.de| Test1234| http://www.automationpractice.pl/index.php|

  @CheckSearch
    Scenario Outline: Search for a product

      Given on the Home page navigate to <URL>
      # Check Search functionality
      And on the Search page <ItemToSearch> is searched
      And the user scrolls 2 times


      Examples:
        | ItemToSearch| URL|
        | Dress| http://www.automationpractice.pl/index.php|



  @CheckAddCart
    Scenario Outline: Product is added to Cart

      Given on the Home page navigate to <URL>
      # Search a product
      # Click on the product
      # Add to cart button clicked
      # Then Product is added to cart message

      Examples:
        | URL|
        | http://www.automationpractice.pl/index.php|



