import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaterBottleTest {

    WaterBottle waterBottle;

    @Before
    public void beforeEach() {waterBottle = new WaterBottle();}

    @Test
    public void hasInitialVolume() { assertEquals(100, waterBottle.getVolume());}

    @Test
    public void canDrink() {
        waterBottle.drink();
        assertEquals(90, waterBottle.getVolume());
    }

    @Test
    public void canEmpty() {
        waterBottle.empty();
        assertEquals(0, waterBottle.getVolume());
    }

    @Test
    public void canFill () {
        waterBottle.empty();
        waterBottle.fill();
        assertEquals(100, waterBottle.getVolume() );
    }

    @Test
    public void canNotDrinkOnceEmpty () {
        waterBottle.empty();
        waterBottle.drink();
        assertEquals(0, waterBottle.getVolume());
    }

}
