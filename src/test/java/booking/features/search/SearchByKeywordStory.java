package booking.features.search;
import booking.questions.SearchResult;
import booking.tasks.BookRoom;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import booking.tasks.OpenTheApplication;
import booking.tasks.Search;

import java.time.LocalDateTime;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void book_PhuQuoc_tour() {
        LocalDateTime startdate = LocalDateTime.now().plusDays(7);
        LocalDateTime enddate = startdate.plusDays(10);

        anna.wasAbleTo(openTheApplication);

        anna.attemptsTo(
                BookRoom.toDestination("Phu Quoc")
                        .from(startdate)
                        .to(enddate)
                        .numberOfRoom(2)
                        .forAdult(4)
                        .andChildren(3)
                        .build()
        );

        anna.should(seeThat("The number of matched rooms", SearchResult.totalRoom(), equalTo(276)));
    }
}