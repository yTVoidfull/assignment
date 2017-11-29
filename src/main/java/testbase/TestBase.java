package testbase;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hamcrest.Matcher;
import org.testng.annotations.BeforeClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class TestBase {

    public Logger log = Logger.getLogger(this.getClass());
    private final String ASSERT_LOG_TEMPLATE = "%s%s - expected: %s%s - actual %s";
    String name = this.getClass().getSimpleName();

    public String getName(){
        return name;
    }

    @BeforeClass
    public void start(){
        DateFormat format = new SimpleDateFormat("dd_MM_yy HH_mm_ss");
        String time = "_" + format.format(new Date());
        System.setProperty("logDir", getName() + time);
        DOMConfigurator.configure("log4j.xml");
    }

    protected  <T> void customAssertThat(String message, T actual, Matcher<? super T> matcher){
        String logStart = "Validate " + message;
        log.info(String.format(ASSERT_LOG_TEMPLATE, logStart, System.lineSeparator(), matcher.toString(), System.lineSeparator(), actual));
        assertThat(matcher.matches(actual)).isEqualTo(true);
    }

}
