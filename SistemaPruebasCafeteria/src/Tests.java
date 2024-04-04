import org.junit.*;
import org.junit.Test;
import org.junit.Assert;

import static junit.framework.TestCase.assertEquals;

public class Tests {
    @Test
    public void correctEntryWithoutSpaces ()
    {
        assertEquals(true, Main.checkNewBeverage("Milkshake,1,2,3,4,5"));
    }
    @Test
    //in this case the spaces should be ignored
    public void correctEntryWithSpacesAtTheEndOfBeverageName ()
    {
        assertEquals(true, Main.checkNewBeverage("Milkshake               ,1,2,3,4,5"));
    }

    @Test
    public void correctEntryWithSpacesAtTheBeginningOfBeverageName ()
    {
        assertEquals(true, Main.checkNewBeverage("           Milkshake,1,2,3,4,5"));
    }

    @Test
    public void correctEntryWithSpacesAtTheBeginningAndEndOfBeverageName ()
    {
        assertEquals(true, Main.checkNewBeverage("           Milkshake               ,1,2,3,4,5"));
    }

    @Test
    public void badEntryMoreCharactersBeverageName ()
    {
        assertEquals(false, Main.checkNewBeverage("Milkshake of strawberry,1,2,3,4,5"));
    }

    @Test
    public void badEntryMoreSizesThanExpected ()
    {
        assertEquals(false, Main.checkNewBeverage("Milkshake,1,2,3,4,5,6"));
    }

    @Test
    public void badEntryNotAlphabeticalBeverageName ()
    {
        assertEquals(false, Main.checkNewBeverage("1Milkshake,1,2,3,4,5"));
    }

    @Test
    public void correctEntryNumbersWithSpaces ()
    {
        assertEquals(true, Main.checkNewBeverage("Milkshake,1  , 2 ,3,4,5"));
    }

    @Test
    public void badEntryNotLargerThanPreviousSize ()
    {
        assertEquals(false, Main.checkNewBeverage("Milkshake,1,2,3,4,3"));
    }

    @Test
    public void badEntryNotEnoughSizes ()
    {
        assertEquals(false, Main.checkNewBeverage("Milkshake"));
    }

    @Test
    public void badEntryEmptyString ()
    {
        assertEquals(false, Main.checkNewBeverage(""));
    }

    @Test
    public void badEntrySizeButNoBeverage ()
    {
        assertEquals(false, Main.checkNewBeverage("8"));
    }

    @Test
    public void badEntrySizesButNoBeverage ()
    {
        assertEquals(false, Main.checkNewBeverage("8,7,9"));
    }

    @Test
    public void badEntrySeparatedNotByCommas ()
    {
        assertEquals(false, Main.checkNewBeverage("Milkshake/1/2/3/4/5"));
    }

    @Test
    public void badEntryLargerSize ()
    {
        assertEquals(false, Main.checkNewBeverage("Milkshake,1,2,3,4,50"));
    }

    @Test
    public void badEntrySpacesBetweenSizes ()
    {
        assertEquals(false, Main.checkNewBeverage("Milkshake,1 2,2,3,4,50"));
    }


    @Test
    public void correctEntryBeveragesWithSpaces ()
    {
        assertEquals(true, Main.checkNewBeverage("Mint Tea,1,2,3,4,5"));
    }

    @Test
    public void badEntrySmallSize ()
    {
        assertEquals(false, Main.checkNewBeverage("Milkshake,0,1,2,3,4"));
    }

    @Test
    public void badEntrySameSize ()
    {
        assertEquals(false, Main.checkNewBeverage("Milkshake,5,5"));
    }

    @Test
    public void correctEntry1Sizes ()
    {
        assertEquals(true, Main.checkNewBeverage("Milkshake,1"));
    }

    @Test
    public void correctEntry2Sizes ()
    {
        assertEquals(true, Main.checkNewBeverage("Milkshake,1,2"));
    }

    @Test
    public void correctEntry3Sizes ()
    {
        assertEquals(true, Main.checkNewBeverage("Milkshake,1,2,3"));
    }

    @Test
    public void correctEntry4Sizes ()
    {
        assertEquals(true, Main.checkNewBeverage("Milkshake,1,2,3,4"));
    }

    @Test
    public void badEntryNotLargeEnoughBeverageName ()
    {
        assertEquals(false, Main.checkNewBeverage("M,1,2,3,4"));
    }

    @Test
    public void badEntryInvertedInputs ()
    {
        assertEquals(false, Main.checkNewBeverage("1,2,3,4,Milkshake"));
    }

    @Test
    public void badEntryIntegerAndStringSizeInput ()
    {
        assertEquals(false, Main.checkNewBeverage("Milkshake,1,two,3,four,5"));
    }

    @Test
    public void correctEntryUpperLimitOfBeverageSize ()
    {
        assertEquals(true, Main.checkNewBeverage("Milkshake,44,45,46,47,48"));
    }

    @Test
    public void correctEntryRandomNextSizeOfBeverage ()
    {
        assertEquals(true, Main.checkNewBeverage("Milkshake,3,20,21,34,45"));
    }

    @Test
    public void badEntryParametersSeparatedWithSpaces()
    {
        assertEquals(false, Main.checkNewBeverage("Milkshake 3 20 21 34 45"));
    }

    @Test
    public void badEntryBeverageSizeAtDecreasingOrder()
    {
        assertEquals(false, Main.checkNewBeverage("Milkshake,10,8,6,4,2"));
    }

}
