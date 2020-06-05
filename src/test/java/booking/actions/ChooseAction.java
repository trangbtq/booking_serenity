package booking.actions;

import net.serenitybdd.screenplay.Interaction;

import java.time.LocalDateTime;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChooseAction {
    public static Interaction StartDate(LocalDateTime dateTime)
    {
        return instrumented(ChooseDateAction.class, dateTime, "Start date");
    }

    public static Interaction EndDate(LocalDateTime dateTime)
    {
        return instrumented(ChooseDateAction.class, dateTime, "End date");
    }

    public static Interaction Destination(String destination)
    {
        return instrumented(ChooseDestinationAction.class, destination);
    }
}
