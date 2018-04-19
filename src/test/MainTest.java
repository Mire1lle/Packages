package test;

import org.junit.Assert;
import org.junit.Test;
import pakendsort.Main;

/**
 * Created by admin on 15.03.17.
 */
public class MainTest {

    @Test
    public void notEnoughConditionsTest() throws Exception {
        boolean fits = Main.main("60, 120");
        Assert.assertFalse(fits);
    }

    @Test
    public void doesNotFitOneToruTest() throws Exception {
        boolean fits = Main.main("60, 120, 20");
        Assert.assertFalse(fits);
    }

    @Test
    public void fitsTwoToruOneTurnTest() throws Exception {
        boolean fits = Main.main("60,120, 100, 75");
        Assert.assertTrue(fits);
    }

    @Test
    public void fitsFiveToruFourTurnsTest() throws Exception {
        boolean fits = Main.main("100, 35, 75, 50, 80, 100, 37");
        Assert.assertTrue(fits);
    }

    @Test
    public void doesNotFitFourToruThreeTurnsTest() throws Exception {
        boolean fits = Main.main("70, 50, 60, 60, 55, 90");
        Assert.assertFalse(fits);
    }

    @Test
    public void doesNotFitByLaius() throws Exception {
        boolean fits = Main.main("70, 50, 40, 1000");
        Assert.assertFalse(fits);
    }
}
