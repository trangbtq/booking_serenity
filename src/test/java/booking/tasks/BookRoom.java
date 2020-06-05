package booking.tasks;
import booking.actions.BookAction;
import booking.actions.ChooseAction;
import booking.ui.BookingPageElement;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.time.LocalDateTime;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BookRoom implements Task{
    private  String destination;
    private  LocalDateTime startdate;
    private  LocalDateTime enddate;
    private int room;
    private int adult;
    private int child;

    public BookRoom(String destination, LocalDateTime from, LocalDateTime to, int room, int adult, int child) {
        this.destination = destination;
        this.startdate = startdate;
        this.enddate = enddate;
        this.room=room;
        this.adult=adult;
        this.child=child;
    }

    public static BookRoomBuilder toDestination(String destination) {
        return new BookRoomBuilder(destination);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ChooseAction.Destination(this.destination),
                ChooseAction.StartDate(this.startdate),
                ChooseAction.EndDate(this.enddate),
                BookAction.rooms(room).forAdult(adult).andChildren(child),
                Click.on(BookingPageElement.SEARCH_BUTTON)
        );
    }
    public static class BookRoomBuilder
    {
        private  String destination;
        private  LocalDateTime startdate;
        private  LocalDateTime enddate;
        private  int room;
        private  int adult;
        private  int child;

        public BookRoomBuilder(String destination)
        {
            this.destination = destination;
        }

        public BookRoomBuilder from(LocalDateTime startdate)
        {
            this.startdate = startdate;
            return this;
        }

        public BookRoomBuilder to(LocalDateTime enddate)
        {
            this.enddate = enddate;
            return this;
        }

        public BookRoomBuilder numberOfRoom(int room)
        {
            this.room = room;
            return this;
        }

        public BookRoomBuilder forAdult(int adult)
        {
            this.adult = adult;
            return this;
        }

        public BookRoomBuilder andChildren(int child)
        {
            this.child = child;
            return this;
        }

        public BookRoom build()
        {
            return instrumented(BookRoom.class, destination, startdate, enddate, room, adult, child);
        }
    }
}
