package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getAppiumDriver(), this);
    }

    @FindBy(id = "com.pozitron.hepsiburada:id/clProductBoxTop")
    WebElement premiumOpportunitiesArea;
    @FindBy(id = "com.pozitron.hepsiburada:id/btnAddToCart")
    WebElement AddToCartButton;
    @FindBy(id = "com.pozitron.hepsiburada:id/com_braze_inappmessage_full_close_button")
    WebElement campaignButton;

    @FindBy(id = "com.pozitron.hepsiburada:id/etSearchBox")
    WebElement inputSearchBox;

    @FindBy(id = "com.pozitron.hepsiburada:id/search_suggestion")
    WebElement firstProduct;

    public void closedButtons(){
        //campaignButton.click();
    }
    public void goesToProductDetail(){
        ReusableMethods.scrollUntilElementFound(premiumOpportunitiesArea);
        AddToCartButton.click();
    }

    public void enterProduct(String product){
        inputSearchBox.sendKeys(product);
    }

    public void productSearch(String product){
        inputSearchBox.click();
        enterProduct(product);
        firstProduct.click();


    }
}
