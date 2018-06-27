package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.Browser;

public class Page extends Browser {

    public Page(){
        PageFactory.initElements(getDriver(), this);
    }


}
