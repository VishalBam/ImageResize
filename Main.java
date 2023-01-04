import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
// Call static method to resize an image to 200 pixels width
        String result_message = resize("F:\\DSA\\ImageResize\\src\\flower.jpg",
                "F:\\DSA\\ImageResize\\src\\flowerRe.jpg",200);
        System.out.println(result_message);

    }

    // This method will resize the image to the specified width and will maintain aspect ratio for the height of the picture to maintain quality
    public static String resize(String sourceFile, String ResizedFile, int width) throws Exception {
        try {
            File f = new File(sourceFile);
            if (!f.exists()) {
                return "File doesn’t exist";
            }

// Logic to implement image resizing
            BufferedImage bim = ImageIO.read(new FileInputStream(sourceFile));
            Image resizedImg = bim.getScaledInstance(width, -1, Image.SCALE_FAST);
            int scaled_height = resizedImg.getHeight(null);

            BufferedImage rBimg = new BufferedImage(width, scaled_height, bim.getType());
// Create Graphics object
            Graphics2D g = rBimg.createGraphics();// Draw the resizedImg from 0,0 with no ImageObserver
            g.drawImage(resizedImg, 0, 0, null);

// Dispose the Graphics object, we no longer need it
            g.dispose();

            ImageIO.write(rBimg, ResizedFile.substring(ResizedFile.indexOf(".") + 1), new FileOutputStream(ResizedFile))
            ;
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Picture Resized Successfully";
    }
}