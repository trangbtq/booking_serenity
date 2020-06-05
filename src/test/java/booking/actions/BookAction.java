package booking.actions;

import booking.ui.BookingPageElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BookAction implements Interaction{
    private int adult;
    private int child;
    private int room;

    public BookAction(int room, int adult, int child)
    {
        this.room = room;
        this.adult = adult;
        this.child = child;
    }

    public static CustomerBuilder rooms(int room)
    {
        return new CustomerBuilder(room);
    }

    @Step("{0} books #room for #adult  and #child ")
    @Override
    public <T extends Actor> void performAs(T actor) {
        BookingPageElement.CUSTOMER.resolveFor(actor).click();

        int numberOfAdult = Integer.parseInt(BookingPageElement.NUMBER_OF_ADULT.resolveFor(actor).getText());
        if(numberOfAdult>adult)
        {
            for(int i =numberOfAdult; i>adult; i--)
            {
                BookingPageElement.DECREASE_NUMBER_OF_ADULT.resolveFor(actor).click();
            }
        }
        else if(adult> numberOfAdult)
        {
            for(int i =numberOfAdult; i<adult; i++)
            {
                BookingPageElement.INCREASE_NUMBER_OF_ADULT.resolveFor(actor).click();
            }
        }

        int numberOfChildren = Integer.parseInt(BookingPageElement.NUMBER_OF_CHILDREN.resolveFor(actor).getText());
        if(numberOfChildren> child)
        {
            for(int i=child; i<numberOfChildren; i++)
            {
                BookingPageElement.DECREASE_NUMBER_OF_CHILDREN.resolveFor(actor).click();
            }
        }
        else if(numberOfChildren<child)
        {
            for(int i=numberOfChildren; i<child; i++)
            {
                BookingPageElement.INCREASE_NUMBER_OF_CHILDREN.resolveFor(actor).click();
            }
        }

        int numberOfRoom = Integer.parseInt(BookingPageElement.NUMBER_OF_ROOM.resolveFor(actor).getText());

        if(numberOfRoom> room)
        {
            for(int i=room; i<numberOfRoom; i++)
            {
                BookingPageElement.DECREASE_NUMBER_OF_ROOM.resolveFor(actor).click();
            }
        }
        else if(numberOfRoom<room)
        {
            for(int i=numberOfRoom; i<room; i++)
            {
                BookingPageElement.INCREASE_NUMBER_OF_ROOM.resolveFor(actor).click();
            }
        }
            BookingPageElement.DONE_GUESS.resolveFor(actor).click();

    }

    public static class CustomerBuilder
    {
        private int adult;
        private int child;
        private int room;

        public CustomerBuilder(int room)
        {
            this.room = room;
        }

        public CustomerBuilder forAdult(int adult)
        {
            this.adult = adult;
            return this;
        }
    }
}