package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FindAMeeting extends Page {

    @FindBy(id = "meetingSearch")
    WebElement searchTextBox;

    @FindBy(css = ".meeting-change-location__container button")
    WebElement searchButton;

    @FindBy(css = ".meeting-location .location__name span")
    List<WebElement> locationName;

    @FindBy(css = ".meeting-location .location__distance")
    List<WebElement> locationDistance;

    @FindBy(css = ".meeting-information .location__name span")
    WebElement selectedMeetingLocationName;


    @FindBy(css = ".hours-list--currentday .hours-list-item-day")
    WebElement hoursOfOperationCurrentDay;


    @FindBy(css = ".hours-list--currentday .hours-list-item-hours")
    WebElement hoursOfOperationCurrentDayHours;


    /**
     * To search for a meeting
     *
     * @param zipCode
     */
    public void search(String zipCode) {
        searchTextBox.sendKeys(zipCode);
        searchButton.click();
    }

    public String getLocationName(int position) {
        waitForElement(locationName, 5000);
        return locationName.get(position - 1).getText();
    }

    public String getLocationDistance(int position) {
        waitForElement(locationDistance, 3000);
        return locationDistance.get(position - 1).getText();
    }


    public void clickOnLocation(int position) {
        waitForElement(locationName, 3000);
        locationName.get(position - 1).click();
    }

    public String getSelectedMeetingLocationName() {
        return selectedMeetingLocationName.getText();
    }

    public String getHoursOfOperationCurrentDay() {
        return hoursOfOperationCurrentDay.getText();
    }

    public String getHoursOfOperationCurrentDayHours() {
        return hoursOfOperationCurrentDayHours.getText();
    }

}
