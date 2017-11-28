package testbase;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

    public Logger log = Logger.getLogger(this.getClass());
    String name = this.getClass().getSimpleName();

    public String getName(){
        return name;
    }

    @BeforeClass
    public void start(){
        DateFormat format = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
        String time = "_" + format.format(new Date());
        System.setProperty("logDir", getName() + time);
        DOMConfigurator.configure("log4j.xml");
    }

}
