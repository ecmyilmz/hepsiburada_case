Feature:  Product Details
@wip
  Scenario: user verifies that they are on the product detail page
  Given User is not logged in
  And  User went to the listing page by typing "elbise" in search.
  When User clicks on a random product from the listing page
  Then User should see he product page

  Scenario: Verifies that they successfully added the product to the cart
  Given User is not logged in
  And  User is on the product detail page
  When User adds the product to the "cart"
  Then User should see that the product has been added to the cart

  Scenario: User confirms that they successfully bookmarked the product
  Given User is not logged in
  And  User is on the product detail page
  When User adds the product to the "favorites"
  Then User should see that the product has been added to favorites





