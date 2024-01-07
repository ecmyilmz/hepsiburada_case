package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pages.BasePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class stepDef {
    final static Logger logger = LogManager.getLogger(stepDef.class);
    BasePage basePage = new BasePage();


    @Given("Customer is not logged in")
    public void customerIsNotLoggedIn() {
        Driver.getAppiumDriver();
        logger.info("Hepsiburada app was launched");
        basePage.closedButtons();
    }


    @When("Customer {string} the product on product detail page")
    public void customerTheProductOnProductDetailPage(String arg0) {
    }

    @Then("Customer should see the product is favorite")
    public void customerShouldSeeTheProductIsFavorite() {
    }

    @Given("Customer search by typing {string} in the search box")
    public void customerSearchByTypingInTheSearchBox(String product) {
        basePage.productSearch(product);
    }

    @When("User adds the product to the {string}")
    public void userAddsTheProductToThe(String arg0) {

    }

    @And("User went to the listing page by typing {string} in search.")
    public void userWentToTheListingPageByTypingInSearch(String arg0) {
    }

    @When("User clicks on a random product from the listing page")
    public void userClicksOnARandomProductFromTheListingPage() {
    }

    @Then("User should see he product page")
    public void userShouldSeeHeProductPage() {
    }

    @Given("User is not logged in")
    public void userIsNotLoggedIn() {
    }

    @And("User is on the product detail page")
    public void userIsOnTheProductDetailPage() {
    }

    @Then("User should see that the product has been added to the cart")
    public void userShouldSeeThatTheProductHasBeenAddedToTheCart() {
    }


    @Then("User should see that the product has been added to favorites")
    public void userShouldSeeThatTheProductHasBeenAddedToFavorites() {
    }
}
