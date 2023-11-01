import java.awt.Robot;
import java.awt.Rectangle;
import javax.imageio.ImageIO;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

public class Screenshot {
    public Screenshot(String fileName){//fileName/filePath: if u insert a path, it's will save as that.
        try{
            Robot robot = new Robot();
            Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
            ImageIO.write(bufferedImage,"png",new File(fileName));
            System.out.println("Succesfully, save as " + fileName);
        }catch (Exception e){
            System.out.println("Can't take a screenshot due to error: "+e.toString());
        }
    }

    public static void main(String[] arg){
        new Screenshot("img2.png");
    }
}
