package exercise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImageTest {

    @Test
    public void ImageTestConstructor() {
        Image i = new Image(100, 100);
        assertEquals(i.data.length, 30000);
    }

    @Test
    public void ImageTestSet() {
        Image image = new Image(100, 100);
        image.set(0, 0, 0x123456);
        assertEquals(image.data[0], (byte)0x12);
        assertEquals(image.data[1], (byte)0x34);
        assertEquals(image.data[2], (byte)0x56);
        assertEquals(image.data[3], (byte)0x00);
    }
}
