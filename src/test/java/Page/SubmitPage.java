package Page;

import Common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubmitPage extends BasePage {

    //WebElements
    @FindBy(css = "form.jotform-form")
    private WebElement submitForm;

    @FindBy(css = "button#input_4")
    private WebElement btnSubmit;



    //Constructor
    public SubmitPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }



    //Methods
    public void submit() {
        btnSubmit.click();
    }

    public boolean validatePage() {
        List<WebElement> allElements = Arrays.asList(submitForm, btnSubmit);
        List<WebElement> missingElements = new ArrayList<>();

        for(WebElement element : allElements) {
            if(!element.isDisplayed()) {
                missingElements.add(element);
            }
        }

        return missingElements.isEmpty();
    }

}
