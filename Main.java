import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedImage img1 = ImageIO.read(new File("image1.jpg"));
            BufferedImage img2 = ImageIO.read(new File("image2.jpg"));

            int width = img1.getWidth();
            int height = img1.getHeight();

            int[] img1Array = new int[width * height];
            int[] img2Array = new int[width * height];
            int[] resultArray = new int[width * height];

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    img1Array[y * width + x] = img1.getRGB(x, y);
                }
            }

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    img2Array[y * width + x] = img2.getRGB(x, y);
                }
            }

            for (int i = 0; i < img1Array.length; i++) {
                resultArray[i] = img1Array[i] ^ img2Array[i];
            }

            BufferedImage resultImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    resultImg.setRGB(x, y, resultArray[y * width + x]);
                }
            }

            ImageIO.write(resultImg, "jpg", new File("result.jpg"));

            System.out.println("Результирующее изображение сохранено как result.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
