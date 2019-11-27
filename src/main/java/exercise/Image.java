package exercise;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Image {

    public byte[] data;
    public int width;
    public int height;

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
    public void set(int x, int y, int value) {
        int offset = (y * width + x) * 3;
        data[offset + 0] = (byte) ((value & 0x00FF0000) >> 16);
        data[offset + 1] = (byte) ((value & 0x0000FF00) >> 8);
        data[offset + 2] = (byte) ((value & 0x000000FF) >> 0);
    }

    /*
     * Return the color value at position (x,y).
     */
    public int get(int x, int y) {
        int offset = (y * width + x) * 3;

        int red   = (int) data[offset + 0];
        int green = (int) data[offset + 1];
        int blue  = (int) data[offset + 2];

        int rgb = ((red & 0x0ff) << 16) | ((green & 0x0ff) << 8) | (blue & 0x0ff);
        return rgb;
    }

    /*
     * Saves the image as a png file.
     *
     * @param filename File name of the image <em>with</em> file extension (i.e. you have to specify
     * if you want to have the <pre>.png</pre> ending.
     */
	public void writePNG(String filename) throws IOException {
	    BufferedImage image = getImage();
	    File outputfile = new File(filename);
	    ImageIO.write(image, "png", outputfile);
	}

    private BufferedImage getImage() throws IOException {
        BufferedImage bufferedImage = new BufferedImage(
                this.width,
                this.height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++) {
                bufferedImage.setRGB(x, y, get(x,y));
            }
        return bufferedImage;
    }

    /*
     * Return the ray starting from the origin, going through the pixel (x, y) of the image.
     *
     * @param x x position of the pixel
     * @param y y position of the pixel
     */
    public Ray ray(int x, int y) {
        throw new UnsupportedOperationException("Image.ray() method not implemented.");
    }

    /*
     * Traces the image and writes it to a ppm file.
     */
    public void trace(Transform t) {
    // • From each image pixel, create a ray.
    // • For each ray, find the Shape which
    //     ◦ intersects the ray in front of the camera
    //     ◦ is closest to the camera/origin
    // • Assign a color of your choice to the corresponding pixel.
        throw new UnsupportedOperationException("Image.trace() method not implemented.");
    }
}
