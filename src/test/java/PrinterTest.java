import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrinterTest {

    Printer printer;
    Printer lowTonePrinter;

    @Before
    public void beforeEach() {
        printer = new Printer(200, 4000);
        lowTonePrinter = new Printer(2000, 40);
    }

    @Test
    public void canGetNumberOfPagesLeft() {
        assertEquals(200,printer.getNumberOfPagesLeft());
    }

    @Test
    public void canSeeIfPrintWasSuccessful() {
        assertTrue(printer.print(6, 20));
    }

    @Test
    public void canSeeIfPrintWasUnsuccessful() {
        assertFalse(printer.print(6, 200));
    }

    @Test
    public void canPrint() {
        printer.print(6, 20);
        assertEquals(80,printer.getNumberOfPagesLeft());
    }

    @Test
    public void cantPrintTooManyPages() {
        printer.print(6, 200);
        assertEquals(200,printer.getNumberOfPagesLeft());
    }

    @Test
    public void canRefill() {
        printer.print(6, 20);
        printer.refill(40);
        assertEquals(120, printer.getNumberOfPagesLeft());
    }

    @Test
    public void cantOverfillPrinter () {
        printer.refill(40);
        assertEquals(200, printer.getNumberOfPagesLeft());
    }

    @Test
    public void canHaveTonerVolume () {
        assertEquals(4000,printer.getTonerVolume());
    }

    @Test
    public void tonerVolumeReducesAfterPrint () {
        printer.print(6, 20);
        assertEquals(3880,printer.getTonerVolume());
    }

    @Test
    public void tonerVolumeCantDipBelowZero () {
        lowTonePrinter.print(6, 20);
        assertEquals(0,lowTonePrinter.getTonerVolume());
    }

}
