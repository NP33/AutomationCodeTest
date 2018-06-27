import pages.FindAMeeting;
import pages.HomePage;
import util.Browser;
import util.ReadData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AutomationExecution {

    public static void main(String args[]) throws Exception {

        int position = 1;

        Browser browser = new Browser();
        browser.launch();

        System.out.println(browser.getTitle());

        String homePageTitle = browser.getTitle();

        assertThat(homePageTitle, equalTo("Weight Loss Program, Recipes & Help | Weight Watchers"));

        HomePage homePage = new HomePage();
        homePage.clickFindAMeeting();

        String finaAMeetingPageTitle = browser.getTitle();
        System.out.println(browser.getTitle());
        assertThat(finaAMeetingPageTitle, containsString("Get Schedules & Times Near You"));

        FindAMeeting findAMeeting = new FindAMeeting();
        ReadData readData = new ReadData();
        findAMeeting.search(readData.getZipCode());

        String selectedLocation = findAMeeting.getLocationName(position);

        System.out.println("Location Name = " + selectedLocation);

        System.out.println("Location Distance = " + findAMeeting.getLocationDistance(position));

        findAMeeting.clickOnLocation(position);

        String displayedLocationName = findAMeeting.getSelectedMeetingLocationName();

        assertThat(selectedLocation, equalTo(displayedLocationName));

        System.out.println("Current Date Day = " + findAMeeting.getHoursOfOperationCurrentDay());

        System.out.println("Current Date Operation Hours = " + findAMeeting.getHoursOfOperationCurrentDayHours());

        browser.close();

    }

}
