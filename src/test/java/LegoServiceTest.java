import org.example.Exception.LegoException;
import org.example.Model.Lego;
import org.example.Service.LegoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LegoServiceTest {

    LegoService legoService;
    // before each test, reset the lego service to a newly instantiated object
    @Before
    public void setUp(){
        legoService = new LegoService();

    }
    // when lego service is first created, it should contain zero lego sets.
    @Test
    public void legoServiceEmptyAtBeginning() {
        List<Lego> legoList = legoService.getAllLego();
        //this checks that there are no lego sets at the start
        Assert.assertTrue(legoList.size() == 0);

    }
    // happy test path
    // exception behavior
    @Test
    public void legoServiceAddLego() {
        // set up - enter junk data to test
        String testName = "blue";
        String testDifficultyRate = "easy";
        int testItemNumber = 1234;
        // act
        try {
            legoService.addLego(testName, testItemNumber, testDifficultyRate);

        } catch (LegoException e) {
            //if exception is thrown, fail the test
            e.printStackTrace();
            Assert.fail("Lego exception incorrectly thrown");
        }
        // assert
        List<Lego> legos = legoService.getAllLego();
        // expecting a single lego at index 0
        Lego actual = legos.get(0);
        Assert.assertEquals(testName, actual.getName());
        Assert.assertEquals(testItemNumber, actual.getItemNumber());
        Assert.assertEquals(testDifficultyRate, actual.getDifficultyRate());
    }

    @Test
    public void addLegoInvalidItemNumber() {
        // set up - enter junk data to test
        String testName = "pink";
        String testDifficultyRate = "medium";
        int testItemNumber = -123;
        // act
        try {
            legoService.addLego(testName, testItemNumber, testDifficultyRate);
            //because lego exception should have been thrown on the above line, getting this
            //far should be impossible - so fail the test
            Assert.fail();

        } catch (LegoException e) {
            /* we should reach the catch block since the exception should have been thrown. */

        }
    }

}
