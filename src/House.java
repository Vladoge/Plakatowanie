public class House
{
    private int width;
    private int height;

    public House(int w, int h)
    {
        this.width = w;
        this.height = h;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWight() {
        return this.width;
    }

    public House setHeight(int h) {
        this.height = h;
        return this;
    }

    public House setWidth(int w) {
        this.width = w;
        return this;
    }
}
