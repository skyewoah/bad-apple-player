import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/home/skye/Documents/Image to Terminal/Audio.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        System.out.print("\033[H\033[2J");
        for(int i = 0; i <= 6513; i++){
            ImageProps image = new ImageProps("/home/skye/Documents/Image to Terminal/BadAppleInFrames/" + Integer.toString(i) +".png");
            int maxX = image.getMaxX() / 6;
            int maxY = image.getMaxY() / 6;
            image.imageResize(maxX, maxY); // Resize to 800x600 pixels
            for(int y = 0; y < maxY; y++){
                for(int x = 0; x < maxX; x++){
                    int white = image.getWhite(x, y);
                    if(white < 100){
                        System.out.print("@");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            Thread.sleep(1000/24);
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        clip.close();
    }
}