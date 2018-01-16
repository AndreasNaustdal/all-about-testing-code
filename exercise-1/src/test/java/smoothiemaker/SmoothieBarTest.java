package smoothiemaker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmoothieBarTest {
    SmoothieBar smoothieBar;
    public static final int ENOUGH_APPLES_FOR_BLENDING = 2;
    public static final int ENOUGH_ORANGES_FOR_BLENDING = 2;

    @Before public void initializeSmoothieBar() {
        smoothieBar = new SmoothieBar();
    }

    @Test
    public void canBlendOrangeAndAppleSmoothie() {
        smoothieBar.restockApples(ENOUGH_APPLES_FOR_BLENDING);
        smoothieBar.restockOranges(ENOUGH_ORANGES_FOR_BLENDING);

        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);

        assertTrue(smoothie.getKind() == SmoothieKind.OrangeAndAppleSmoothie);
    }

    @Test
    public void blendingOrangeAndAppleSmoothieConsumesOrangesAndApples() {
        smoothieBar.restockApples(ENOUGH_APPLES_FOR_BLENDING);
        smoothieBar.restockOranges(ENOUGH_ORANGES_FOR_BLENDING);

        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);

        assertEquals("Wrong quantity of apples", smoothieBar.getApplesInStock(),0);
        assertEquals("Wrong quantity of oranges", smoothieBar.getOrangesInStock(),0);
    }

    @Test(expected = IllegalStateException.class)
    public void canNotRestockWhenStockIsTooLow() {
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotBlendZeroSmoothie(){
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotRestockZeroApples(){
        smoothieBar.restockApples(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotRestockZeroOranges(){
        smoothieBar.restockOranges(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotRestockZeroBananas(){
        smoothieBar.restockBananas(0);
    }
}