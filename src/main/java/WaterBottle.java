public class WaterBottle {

    private int maxVolume = 100;
    private int volume = maxVolume;

    public int getVolume() {
        return this.volume;
    }

    public void drink() {
        if (this.volume >= 10) {
            this.volume -= 10;
        }
    }

    public void empty() {
        this.volume = 0;
    }

    public void fill() {
        this.volume = this.maxVolume;
    }
}
