package booking.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BookingPageElement {
    public static Target DESTINATION_FIELD = Target.the("destination field")
            .locatedBy("//*[@id=\"ss\"]");

    public static Target FIRST_ITEM = Target.the("first item from suggestion box")
            .locatedBy("//*[@id=\"hotellist_inner\"]/div[1]/table/tbody/tr[1]/td[2]/div[1]/h3/a/span[1]");

    public static Target CUSTOMER = Target.the("choose the customer")
            .locatedBy("//*[@id=\"xp__guests__toggle\"]");

    public static Target NUMBER_OF_ADULT = Target.the("number of adult")
            .locatedBy("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[1]/div/div[2]/span[1]");

    public static Target DECREASE_NUMBER_OF_ADULT = Target.the("decrease number of adult")
            .locatedBy("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[1]/div/div[2]/button[1]");

    public static Target INCREASE_NUMBER_OF_ADULT = Target.the("increase number of adult")
            .locatedBy("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[1]/div/div[2]/button[2]");

    public static Target NUMBER_OF_CHILDREN = Target.the("number of children")
            .locatedBy("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[2]/div/div[2]/span[1]");

    public static Target DECREASE_NUMBER_OF_CHILDREN = Target.the("decrease numnber of Children")
            .locatedBy("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[2]/div/div[2]/button[1]");

    public static Target INCREASE_NUMBER_OF_CHILDREN = Target.the("decrease numnber of Children")
            .locatedBy("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[2]/div/div[2]/button[2]");

    public static Target NUMBER_OF_ROOM = Target.the("number of room")
            .locatedBy("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[3]/div/div[2]/span[1]");

    public static Target DECREASE_NUMBER_OF_ROOM = Target.the("decrease number of Room")
            .locatedBy("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[3]/div/div[2]/button[1]");

    public static Target INCREASE_NUMBER_OF_ROOM = Target.the("increase number of Room")
            .locatedBy("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[3]/div/div[2]/button[2]");

    public static Target SEARCH_BUTTON = Target.the("search button")
            .locatedBy("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button");

    public static Target DONE_GUESS = Target.the("done button")
            .locatedBy("//div[starts-with(@aria-label, \"Select guests/rooms\")]//button[@data-section-overlay-apply]");
}

