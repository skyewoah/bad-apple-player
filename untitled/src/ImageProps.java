import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProps {
    int x;
    int y;

    private final BufferedImage image;
    private BufferedImage resizedImage;

    public ImageProps(String imagePath) throws IOException {
        this.image = ImageIO.read(new File(imagePath));
    }

    public void imageResize(int x, int y){
        image.getScaledInstance(x, y, Image.SCALE_FAST);
        Graphics2D g = image.createGraphics();
        g.drawImage(image, 0, 0, x, y, null);
        g.dispose();
    }

    public int getColor(int x, int y){
        return image.getRGB(x, y);
    }

    public int getWhite(int x, int y){
        int color = image.getRGB(x, y);
        int blue = color & 0xff;
        int green = (color & 0xff00) >> 8;
        int red = (color & 0xff0000) >> 16;

        return (blue + green + red) / 3; //get normalized

    }

    public Image getImage(){
        return image;
    }

    public int getMaxX(){
        return image.getWidth();
    }

    public int getMaxY(){
        return image.getHeight();
    }



}
