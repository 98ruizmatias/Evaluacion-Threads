public class Counter {

    private int value;

    public Counter(int initialValue) {
        this.value = initialValue;
    }

    public int getValue() {
        return this.value;
    }

    public void inc() {
        this.value++;
    }

    public void incN(int n) {
        if (n > 0) {
            this.value += n;
        }
    }

    public void dec() {
        this.value--;
    }

    public void decN(int n) {
        if (n > 0) {
            this.value -= n;
        }
    }

    public void setDefault() {
        this.value = 0;
    }
}