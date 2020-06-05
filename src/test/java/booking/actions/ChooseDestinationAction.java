package booking.actions;

import booking.ui.BookingPageElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

public class ChooseDestinationAction implements Interaction {
    String destination;
    @Step("{0} select #destination as a destination")
    @Override
    public <T extends Actor> void performAs(T actor) {
        BookingPageElement.DESTINATION_FIELD.resolveFor(actor).click();
        BookingPageElement.DESTINATION_FIELD.resolveFor(actor).sendKeys(destination);
        BookingPageElement.FIRST_ITEM.resolveFor(actor).click();
    }

    public ChooseDestinationAction(String destination)
    {
        this.destination = destination;
    }
}

