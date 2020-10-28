package TestSuite;

import Common.BaseTest;
import Common.DataFactory;
import Page.CourseRegPage;
import Page.SubmitPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Calendar;

public class CourseRegTest extends BaseTest {

    private final WebDriver driver = getDriver();

    private final String formUrl = "https://form.jotform.com/202996849872174";
    private final String submitUrl = "https://submit.jotform.com/submit/202996849872174/";



    //Tests
    @Test(enabled = true, groups = "RyanExample", description = "Verify Course Reg Form")
    public void verifyCourseRegForm() {
        //Open Student Registration Form
        driver.navigate().to(formUrl);
        Assert.assertEquals(driver.getCurrentUrl(), formUrl, "Verify URL is correct for the Course Registration Form");

        CourseRegPage courseRegPage = new CourseRegPage(driver);
        Assert.assertTrue(courseRegPage.validatePage(), "Verify All Course Registration Form Elements are Present");

        //Enter Random Form Data
        courseRegPage.enterName(DataFactory.generateFirstName(), DataFactory.generateFirstName(),
                DataFactory.generateLastName());

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        courseRegPage.enterBirthDate(DataFactory.getDateBetween(
                LocalDate.of(currentYear - 18, 1, 1),
                LocalDate.of(currentYear - 17, 12, 31)));

        courseRegPage.enterRandomGender();

        courseRegPage.enterAddress(DataFactory.generateAddr1(), DataFactory.generateAddr2(), DataFactory.generateCity(),
                DataFactory.generateState(), DataFactory.generateZip());

        courseRegPage.enterEmail(DataFactory.generateEmailAddress());

        courseRegPage.enterPhoneNumbers(DataFactory.generatePhoneNumber(), DataFactory.generatePhoneNumber(),
                DataFactory.generatePhoneNumber());

        courseRegPage.enterCompany(DataFactory.generateLastName() + " Corporation");

        Assert.assertTrue(courseRegPage.courseHasOption("Math 101"));
        courseRegPage.enterRandomCourses();

        courseRegPage.enterAdditionalComments("Top 15% of Class with Several AP Courses");

        //Submit and Be Sent to Submit Page
        courseRegPage.submit();

        courseRegPage.getWait().until(ExpectedConditions.urlToBe(submitUrl));
        Assert.assertEquals(driver.getCurrentUrl(), submitUrl, "Verify URL is correct for the Submit Page");

        SubmitPage submitPage = new SubmitPage(driver);
        Assert.assertTrue(submitPage.validatePage(), "Verify All Submit Page Elements are Present");
    }

}