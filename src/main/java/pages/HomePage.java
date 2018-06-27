package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    @FindBy(id = "ela-menu-visitor-desktop-supplementa_find-a-meeting")
    WebElement findAMeeting;


    public void clickFindAMeeting() {
        findAMeeting.click();
    }

}
