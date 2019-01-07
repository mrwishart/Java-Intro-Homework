public class Printer {

    private int numberOfPagesLeft;
    private int printerFullVolume;
    private int tonerVolume;

    public Printer(int printerFullVolume, int tonerVolume) {
        this.printerFullVolume = printerFullVolume;
        // Printer always starts full
        this.numberOfPagesLeft = this.printerFullVolume;
        this.tonerVolume = tonerVolume;
    }

    public int getNumberOfPagesLeft() {
        return this.numberOfPagesLeft;
    }

    public boolean print(int numberOfPages, int numberOfCopies) {

        boolean printSuccessful = false;
        int printVolume = numberOfPages * numberOfCopies;

        if (printVolume <= this.numberOfPagesLeft) {
            this.numberOfPagesLeft -= printVolume;
            this.reduceToner(printVolume);
            printSuccessful = true;
        }

        return printSuccessful;
    }

    public void refill(int numberOfPagesAdded) {

        this.numberOfPagesLeft += numberOfPagesAdded;

        if (this.numberOfPagesLeft > this.printerFullVolume) {
            this.numberOfPagesLeft = this.printerFullVolume;
        }
    }

    public int getTonerVolume() {
        return this.tonerVolume;
    }

    private void reduceToner(int numberOfPagesPrinted) {

        this.tonerVolume -= numberOfPagesPrinted;

        if (this.tonerVolume < 0) {
            this.tonerVolume = 0;
        }
    }
}
