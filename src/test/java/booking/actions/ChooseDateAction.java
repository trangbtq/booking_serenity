package booking.actions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;

public class ChooseDateAction implements Interaction {
    public String date ="td[data-date=\"";
    private String startdate;
    private String enddate;
    public ChooseDateAction(String startdate, String enddate)
    {
        this.startdate = startdate;
        this.enddate = enddate;

    }
    @Step("{0} select date from #startdate to #enddate")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Target START_DATE = Target.the("date")
                .located(By.cssSelector(date + this.startdate + "\"]"));
        START_DATE.resolveFor(actor).click();

        Target END_DATE = Target.the("date")
                .located(By.cssSelector(date + this.enddate + "\"]"));
        END_DATE.resolveFor(actor).click();
    }
}