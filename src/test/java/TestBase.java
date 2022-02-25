import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {



    protected static Manager mng = new Manager(System.getProperty("device","emulator"));

    @BeforeSuite(alwaysRun = true)
    public void init() throws IOException, InterruptedException {
        mng.initProperties();
    }



}
