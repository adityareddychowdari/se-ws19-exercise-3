package exercise;

public class Image {

    public byte[] data;
    int width;
    int height;

    Image(int width, int height) {
        this.width = width;
        this.height = height;
        data = new byte[width * height * 3];
    }

    /*
     * Set the pixel at position (x,y) to a certain color.
     * The color is determined by the last 3 bytes of `value`, where each byte stands for the color
     * value of red, green, and blue respectively.
     */
    void set(int x, int y, int value) {
        int offset = (y * width + x) * 3;
        data[offset + 0] = (byte) ((value & 0x00FF0000) >> 16);
        data[offset + 1] = (byte) ((value & 0x0000FF00) >> 8);
        data[offset + 2] = (byte) ((value & 0x000000FF) >> 0);
    }

    /*
     * Return the color value at position (x,y).
     */
    int get(int x, int y) {
        int offset = (y * width + x) * 3;

        int red   = (int) data[offset + 0];
        int green = (int) data[offset + 1];
        int blue  = (int) data[offset + 2];

        int rgb = ((red & 0x0ff) << 16) | ((green & 0x0ff) << 8) | (blue & 0x0ff);
        return rgb;
    }
}
