package image.compression;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtils {

    public static BufferedImage convertByteArrayToBufferedImage(byte[] imageInByte) {

        InputStream in = new ByteArrayInputStream(imageInByte);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bufferedImage;
    }

    public static byte[] compressImage(byte[] imageInByte) {
        return convertBufferedImageToByeArray(convertByteArrayToBufferedImage(imageInByte));
    }

    public static byte[] convertBufferedImageToByeArray(BufferedImage bufferedImage) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "jpg", baos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return baos.toByteArray();
    }
}
