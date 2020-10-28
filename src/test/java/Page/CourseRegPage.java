package Page;

import Common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CourseRegPage extends BasePage {

    //WebElements
    //Student Name
    @FindBy(css = "input#first_4")
    private WebElement firstName;

    @FindBy(css = "input#middle_4")
    private WebElement middleName;

    @FindBy(css = "input#last_4")
    private WebElement lastName;

    //Birth Date
    @FindBy(css = "select#input_24_month")
    private WebElement monthDropdown;

    private Select monthSelect;

    @FindBy(css = "select#input_24_month > option[value]")
    private List<WebElement> monthOptions;

    @FindBy(css = "select#input_24_day")
    private WebElement dayDropdown;

    private Select daySelect;

    @FindBy(css = "select#input_24_day > option[value]")
    private List<WebElement> dayOptions;

    @FindBy(css = "select#input_24_year")
    private WebElement yearDropdown;

    private Select yearSelect;

    @FindBy(css = "select#input_24_year > option[value]")
    private List<WebElement> yearOptions;

    //Gender
    @FindBy(css = "select#input_3")
    private WebElement genderDropdown;

    private Select genderSelect;

    @FindBy(css = "select#input_3 > option[value]")
    private List<WebElement> genderOptions;

    //Address
    @FindBy(css = "input#input_23_addr_line1")
    private WebElement streetAddress1;

    @FindBy(css = "input#input_23_addr_line2")
    private WebElement streetAddress2;

    @FindBy(css = "input#input_23_city")
    private WebElement city;

    @FindBy(css = "input#input_23_state")
    private WebElement stateOrProvince;

    @FindBy(css = "input#input_23_postal")
    private WebElement postalOrZipCode;

    //Student Contact Info
    @FindBy(css = "input#input_6")
    private WebElement email;

    @FindBy(css = "input#input_27_full")
    private WebElement mobileNumber;

    @FindBy(css = "input#input_25_full")
    private WebElement phoneNumber;

    @FindBy(css = "input#input_26_full")
    private WebElement workNumber;

    //Additional Student Info
    @FindBy(css = "input#input_14")
    private WebElement company;

    @FindBy(css = "select#input_46")
    private WebElement coursesDropdown;

    private Select coursesSelect;

    @FindBy(css = "select#input_46 > option[value]")
    private List<WebElement> coursesOptions;

    @FindBy(css = "textarea#input_45")
    private WebElement additionalComments;

    //Buttons
    @FindBy(css = "button#input_20")
    private WebElement btnSubmitApplication;

    @FindBy(css = "button#input_19")
    private WebElement btnClearFields;



    //Access
    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getMiddleName() {
        return middleName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public Select getMonthSelect() {
        return monthSelect;
    }

    public List<WebElement> getMonthOptions() {
        return monthOptions;
    }

    public Select getDayDropdown() {
        return daySelect;
    }

    public List<WebElement> getDayOptions() {
        return dayOptions;
    }

    public WebElement getYearDropdown() {
        return yearDropdown;
    }

    public Select getYearSelect() {
        return yearSelect;
    }

    public List<WebElement> getYearOptions() {
        return yearOptions;
    }

    public Select getGenderDropdown() {
        return genderSelect;
    }

    public List<WebElement> getGenderOptions() {
        return genderOptions;
    }

    public WebElement getStreetAddress1() {
        return streetAddress1;
    }

    public WebElement getStreetAddress2() {
        return streetAddress2;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getStateOrProvince() {
        return stateOrProvince;
    }

    public WebElement getPostalOrZipCode() {
        return postalOrZipCode;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getMobileNumber() {
        return mobileNumber;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public WebElement getWorkNumber() {
        return workNumber;
    }

    public WebElement getCompany() {
        return company;
    }

    public Select getCoursesDropdown() {
        return coursesSelect;
    }

    public List<WebElement> getCoursesOptions() {
        return coursesOptions;
    }

    public WebElement getAdditionalComments() {
        return additionalComments;
    }

    public WebElement getBtnSubmitApplication() {
        return btnSubmitApplication;
    }

    public WebElement getBtnClearFields() {
        return btnClearFields;
    }



    //Constructor
    public CourseRegPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        monthSelect = new Select(monthDropdown);
        daySelect = new Select(dayDropdown);
        yearSelect = new Select(yearDropdown);
        genderSelect = new Select(genderDropdown);
        coursesSelect = new Select(coursesDropdown);
    }



    //Methods
    public void submit() {
        btnSubmitApplication.click();
    }

    public void clear() {
        btnClearFields.click();
    }

    public void enterName(String first, String middle, String last) {
        firstName.clear();
        firstName.sendKeys(first);
        middleName.clear();
        middleName.sendKeys(middle);
        lastName.clear();
        lastName.sendKeys(last);
    }

    public void enterBirthDate(LocalDate date) {
        String month = Stream.of(date.getMonth().name().split("[^a-zA-Z0-9]"))
                .map(v -> v.substring(0, 1).toUpperCase() + v.substring(1).toLowerCase())
                .collect(Collectors.joining());

        List<String> monthOptions = monthSelect.getOptions().stream()
                .map(e -> e.getAttribute("value"))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if(monthOptions.contains(month)) {
            monthSelect.selectByValue(month);
        } else {
            System.out.println("Unknown month selection: " + month);
        }

        String day = Integer.toString(date.getDayOfMonth());

        List<String> dayOptions = daySelect.getOptions().stream()
                .map(e -> e.getAttribute("value"))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if(dayOptions.contains(day)) {
            daySelect.selectByValue(day);
        } else {
            System.out.println("Unknown day selection: " + day);
        }

        String year = Integer.toString(date.getYear());

        List<String> yearOptions = yearSelect.getOptions().stream()
                .map(e -> e.getAttribute("value"))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if(yearOptions.contains(year)) {
            yearSelect.selectByValue(year);
        } else {
            System.out.println("Unknown year selection: " + year);
        }
    }

    public void enterGender(String gender) {
        List<String> dropdownOptions = genderSelect.getOptions().stream()
                .map(e -> e.getAttribute("value"))
                .filter(s -> !s.contains("Please Select"))
                .collect(Collectors.toList());

        if(dropdownOptions.contains(gender)) {
            genderSelect.selectByValue(gender);
        } else System.out.println("Unknown gender selection: " + gender);
    }

    public void enterRandomGender() {
        final SecureRandom rnd = new SecureRandom();

        List<String> dropdownOptions = genderSelect.getOptions().stream()
                .map(WebElement::getText)
                .filter(s -> !s.contains("Please Select"))
                .collect(Collectors.toList());

        genderSelect.selectByVisibleText(dropdownOptions.get(rnd.nextInt(dropdownOptions.size()-1)));
    }

    public boolean genderHasOption(String option) {
        genderDropdown.click();
        Optional<String> possibleOption = genderOptions.stream()
                .map(WebElement::getText)
                .filter(s -> s.contains(option))
                .findAny();
        genderDropdown.click();

        return possibleOption.isPresent() && possibleOption.toString().contains(option);
    }

    public void enterAddress(String addr1, String addr2, String city, String state, String zip) {
        streetAddress1.clear();
        streetAddress1.sendKeys(addr1);
        streetAddress2.clear();
        streetAddress2.sendKeys(addr2);
        this.city.clear();
        this.city.sendKeys(city);
        stateOrProvince.clear();
        stateOrProvince.sendKeys(state);
        postalOrZipCode.clear();
        postalOrZipCode.sendKeys(zip);
    }

    public void enterEmail(String email) {
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void enterPhoneNumbers(String mobileNum, String phoneNum, String workNum) {
        mobileNumber.clear();
        mobileNumber.sendKeys(mobileNum);
        phoneNumber.clear();
        phoneNumber.sendKeys(phoneNum);
        workNumber.clear();
        workNumber.sendKeys(workNum);
    }

    public void enterCompany(String companyName) {
        company.clear();
        company.sendKeys(companyName);
    }

    public void enterCourses(String course) {
        List<String> dropdownOptions = coursesSelect.getOptions().stream()
                .map(WebElement::getText)
                .filter(s -> !s.contains("Please Select"))
                .collect(Collectors.toList());

        if(dropdownOptions.contains(course)) {
            coursesSelect.selectByValue(course);
        } else System.out.println("Unknown course selection: " + course);
    }

    public void enterRandomCourses() {
        final SecureRandom rnd = new SecureRandom();

        List<String> dropdownOptions = coursesSelect.getOptions().stream()
                .map(WebElement::getText)
                .filter(s -> !s.contains("Please Select"))
                .collect(Collectors.toList());

        coursesSelect.selectByVisibleText(dropdownOptions.get(rnd.nextInt(dropdownOptions.size()-1)));
    }

    public boolean courseHasOption(String option) {
        coursesDropdown.click();
        Optional<String> possibleOption = coursesOptions.stream()
                .map(WebElement::getText)
                .filter(s -> s.contains(option))
                .findAny();
        coursesDropdown.click();

        return possibleOption.isPresent() && possibleOption.toString().contains(option);
    }

    public void enterAdditionalComments(String comments) {
        additionalComments.clear();
        additionalComments.sendKeys(comments);
    }

    public boolean validatePage() {
        List<WebElement> allInputs = Arrays.asList(firstName, middleName, lastName, streetAddress1,
                streetAddress2, city, stateOrProvince, postalOrZipCode, email, mobileNumber, phoneNumber,
                workNumber, company, additionalComments, btnSubmitApplication, btnClearFields);
        List<WebElement> missingInputs = new ArrayList<>();

        for(WebElement element : allInputs) {
            if(!element.isDisplayed()) {
                missingInputs.add(element);
            }
        }

        List<Select> allSelects = Arrays.asList(monthSelect, daySelect,
                yearSelect, genderSelect, coursesSelect);
        List<Select> emptySelects = new ArrayList<>();

        for(Select select : allSelects) {
            List<WebElement> options = select.getOptions();
            List<String> values = new ArrayList<>();
            for (WebElement element : options) {
                String option = element.getText();
                values.add(option);
            }

            if(values.isEmpty()) {
                emptySelects.add(select);
            }
        }

        return missingInputs.isEmpty() && emptySelects.isEmpty();
    }

}