package exercise;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.io.IOException;

public class Image {

    public byte[] data;
    public int width;
    public int height;
    private Vec3D camera = new Vec3D (0, 0, -4.0);
    private Vec3D screenPlane = new Vec3D (0, 0, 0);

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

    // set camera distance from screen
    public void setCameraDistance (float dist){
        this.camera.z = -1*dist;
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
        //Ray(Vec3D origin, Vec3D direction)

        // the origin should be camera as if light come fom camera
        Vec3D origin = this. camera;
        // the direction will be defined by pixel location
        // assume screen loaction is at z= 0
        // pixel start from 0 to width/ height
        // need reset to centre of screen
        Vec3D direction = new Vec3D( x -(this.width/2), y - (this.height/2), this.screenPlane.z);
        return new Ray(origin, direction);
    }

        // Assume structure is as below:
        //
        // Transform (Group)
        //  |_  Children List (Transform)
        //       |_ Shape
        //           |_ Geometry (Cone/Sphere/ Plane)
        //           |      |_ Color
        //           |_ Apperance
        //                  |_ Material

    /*
     * Traces the image and writes it to a ppm file.
     */
    public void trace(Transform t) {
        // iterate through every pixel
        // x as column
        // y as row
        
        for (int row = 0; row < this.height; row++) {
            for (int column = 0; column < this.width; column++){
                // • From each image pixel, create a ray.
                Ray r = this.ray(row, column);
                Geometry g = t.shape.geometry;

                // Preset Background Color as White
                int color = 0xFFFFFFF;

                // • For each ray, find the Shape which          
                Vec3D point = g.intersect(r);

                // if no intersection, the sequence skip rest of code
                // Leverage concept from previous attempt to solve assignment

                // intersects the ray in front of the camera
                if (point == null) continue;
                
                // is closest to the camera/origin
                if (point.z < this.camera.z) continue;
                
                // Preset the furthest distance as highest value in Double datatype
                double closestDistance = Double.MAX_VALUE;
                // Replace the color mapping for nearest Object
                if (point.len() > closestDistance) continue;

                // if the condition valid for all
                // Set respective pixel as corresponding shape color
                color = g.color;

                // • Assign a color of your choice to the corresponding pixel.
                // Because inverted effect row should be reinverted
                this.set( column, this.height - row, color);           
            }
        }

        // Writing test file based on data byte set.
        try {
            // file stream Method
            FileOutputStream stream = new FileOutputStream("test");
            // write in format of ppM to file
		    stream.write(new String("P6 "+this.width+" "+this.height+" 255\n").getBytes());
		    stream.write(data);
		    stream.close();
        } catch (Exception e) {
            //Threw Debug error
            System.out.println("Error writing test files");
        }
    
    }
}
